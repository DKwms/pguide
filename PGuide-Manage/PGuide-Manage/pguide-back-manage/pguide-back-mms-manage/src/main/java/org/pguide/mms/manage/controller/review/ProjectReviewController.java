package org.pguide.mms.manage.controller.review;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import org.pguide.mms.manage.domain.MmsProjectInfo;
import org.pguide.mms.manage.service.impl.MmsProjectInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author DKwms
 * @Date 2024/1/22 21:28
 * @description
 * 项目审阅
 */
@RequestMapping("/api/mms/review")
@RestController
public class ProjectReviewController extends BaseController {


    @Autowired
    MmsProjectInfoServiceImpl mmsProjectInfoService;


    @PostConstruct
    public void getDict(){

    }

    /**
     * 查询
     */
    @GetMapping("/list")
    public TableDataInfo list(MmsProjectInfo mmsProjectInfo){
        startPage();
        List<MmsProjectInfo> mmsProjectInfos = mmsProjectInfoService.selectMmsProjectInfoList(mmsProjectInfo);
        return getDataTable(mmsProjectInfos);
    }



}
