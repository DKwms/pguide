package org.pguide.competition.manage.service;

import org.pguide.competition.manage.entity.CmsOrgDict;
import org.pguide.competition.manage.entity.CmsSubjectDict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.pguide.competition.manage.vo.CmsSubjectDictVo;

import java.util.List;
import java.util.Map;

/**
* @author ROG
* @description 针对表【cms_subject_dict】的数据库操作Service
* @createDate 2024-01-16 16:36:51
*/
public interface CmsSubjectDictService extends IService<CmsSubjectDict> {

    /**
     * 获取树状学科结构
     * @return
     */
    Map<Integer, List<CmsSubjectDictVo>> getSubjectTree();
}
