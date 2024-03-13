package org.pguide.search.web.projectinfo.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchAction;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.pguide.api.search.domain.dto.ProjectInfo;
import org.pguide.common.core.result.JsonResult;
import org.pguide.common.search.ESJsonUtil;
import org.pguide.search.constant.ESConst;

import org.pguide.search.web.projectinfo.service.ESProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public JsonResult<Void> addObj(ProjectInfo projectInfo, int projectId) {

        String json = ESJsonUtil.parseObjToJSONWithUnderscore(projectInfo);

        IndexRequest indexRequest = new IndexRequest(ESConst.IndexConst.PROJECT_INFO)
                .id(projectId+"")
                .source(json,XContentType.JSON);

        try {
            IndexResponse index = client.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("es请求处理失败，Exception:{}",e.getMessage());
            return JsonResult.error("");
        }

        log.info("新增ProjectInfo成功,id:{}",projectId);
        return JsonResult.success();
    }

    @Override
    public JsonResult<List<ProjectInfo>> getAimObj(String searchInfo) {
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
                return JsonResult.success(resArr);
            }
        } catch (IOException e) {
            log.error("es请求处理失败");
        }
        return JsonResult.error("es查询失败");
    }

    @Override
    public JsonResult<List<ProjectInfo>> getAimObjPage(String searchInfo, int from, int size) {
        SearchRequest searchRequest = new SearchRequest(ESConst.IndexConst.PROJECT_INFO);

        SearchSourceBuilder query = new SearchSourceBuilder()
                .query(QueryBuilders.matchQuery("search_info", searchInfo));

        query.from(from);
        if(size>ESConst.SysConst.SYS_BASE_MAX_DOC_SIZE){
            log.error("单次查询projectinfo 超出系统默认上线，可能纯在有人恶意调用api攻击");
            return JsonResult.error("不要乱搞，查这么多干什么！");
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
                return JsonResult.success(resArr);
            }
        } catch (IOException e) {
            log.error("es请求处理失败");
        }
        return JsonResult.error("es查询失败");
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
