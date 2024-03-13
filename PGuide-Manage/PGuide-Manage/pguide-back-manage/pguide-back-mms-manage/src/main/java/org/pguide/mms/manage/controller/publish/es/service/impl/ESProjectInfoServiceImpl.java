package org.pguide.mms.manage.controller.publish.es.service.impl;


import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.pguide.mms.manage.controller.publish.es.constant.ESConst;
import org.pguide.mms.manage.controller.publish.es.domain.dto.ProjectInfo;
import org.pguide.mms.manage.controller.publish.es.service.ESProjectInfoService;
import org.pguide.mms.manage.controller.publish.es.utils.ESJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author DKwms
 * @Date 2024/1/23 10:52
 * @description
 */
@Service
@Slf4j
public class ESProjectInfoServiceImpl implements ESProjectInfoService {

    @Autowired
    RestHighLevelClient client;

    @Override
    public AjaxResult addObj(ProjectInfo projectInfo, int projectId) {

        String json = ESJsonUtil.parseObjToJSONWithUnderscore(projectInfo);

        IndexRequest indexRequest = new IndexRequest(ESConst.IndexConst.PROJECT_INFO)
                .id(projectId+"")
                .source(json, XContentType.JSON);

        try {
            IndexResponse index = client.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("es请求处理失败，Exception:{}",e.getMessage());
            return AjaxResult.error("");
        }

        log.info("新增ProjectInfo成功,id:{}",projectId);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult getAimObj(String searchInfo) {
        SearchRequest searchRequest = new SearchRequest(ESConst.IndexConst.PROJECT_INFO);

        SearchSourceBuilder query = new SearchSourceBuilder()
                .query(QueryBuilders.matchQuery("search_info", searchInfo));

        try {
            SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = search.getHits();
            ArrayList<ProjectInfo> resArr = new ArrayList<>();
            for (SearchHit hit : hits) {
                String sourceAsString = hit.getSourceAsString();
                ProjectInfo projectInfo = JSON.parseObject(sourceAsString, ProjectInfo.class);
                resArr.add(projectInfo);
                return AjaxResult.success(resArr);
            }
        } catch (IOException e) {
            log.error("es请求处理失败");
        }
        return AjaxResult.error("es查询失败");
    }

    @Override
    public AjaxResult getAimObjPage(String searchInfo, int from, int size) {
        SearchRequest searchRequest = new SearchRequest(ESConst.IndexConst.PROJECT_INFO);

        SearchSourceBuilder query = new SearchSourceBuilder()
                .query(QueryBuilders.matchQuery("search_info", searchInfo));

        query.from(from);
        if(size>ESConst.SysConst.SYS_BASE_MAX_DOC_SIZE){
            log.error("单次查询projectinfo 超出系统默认上线，可能纯在有人恶意调用api攻击");
            return AjaxResult.error("不要乱搞，查这么多干什么！");
        }
        query.size(size);

        try {
            SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = search.getHits();
            ArrayList<ProjectInfo> resArr = new ArrayList<>();
            for (SearchHit hit : hits) {
                String sourceAsString = hit.getSourceAsString();
                ProjectInfo projectInfo = JSON.parseObject(sourceAsString, ProjectInfo.class);
                resArr.add(projectInfo);
                return AjaxResult.success(resArr);
            }
        } catch (IOException e) {
            log.error("es请求处理失败");
        }
        return AjaxResult.error("es查询失败");
    }


    /**
     * es返回结果处理<br>
     * 用于测试
     * @param searchOut
     */
    private static void handleResult(SearchResponse searchOut) {
        //结果处理
        SearchHits searchHits = searchOut.getHits();

        //总条数
        long value = searchHits.getTotalHits().value;

        //结果数组
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            String jsonResult = hit.getSourceAsString();
            //System.out.println("jsonResult = " + JSON.parseObject(jsonResult, HotelDoc.class).toString());
            System.out.println(jsonResult);
        }
    }
}
