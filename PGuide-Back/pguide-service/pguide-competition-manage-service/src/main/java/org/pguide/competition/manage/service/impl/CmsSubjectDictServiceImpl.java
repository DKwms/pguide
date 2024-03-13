package org.pguide.competition.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.pguide.competition.manage.entity.CmsSubjectDict;
import org.pguide.competition.manage.service.CmsSubjectDictService;
import org.pguide.competition.manage.mapper.CmsSubjectDictMapper;
import org.pguide.competition.manage.vo.CmsSubjectDictVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author ROG
* @description 针对表【cms_subject_dict】的数据库操作Service实现
* @createDate 2024-01-16 16:36:51
*/
@Service
public class CmsSubjectDictServiceImpl extends ServiceImpl<CmsSubjectDictMapper, CmsSubjectDict>
    implements CmsSubjectDictService{

    @Autowired
    CmsSubjectDictMapper cmsSubjectDictMapper;

    @Override
    public Map<Integer, List<CmsSubjectDictVo>> getSubjectTree() {
        List<CmsSubjectDict> list = this.list();
        List<CmsSubjectDictVo> rowVos = list.stream().map(e ->
                CmsSubjectDictVo.builder()
                        .subjectName(e.getSubjectName())
                        .subjectLevel(e.getSubjectLevel())
                        .subjectId(e.getSubjectId())
                        .parentId(e.getParentId()).build()
        ).collect(Collectors.toList());

        Map<Integer, List<CmsSubjectDictVo>> result = rowVos.stream()
                .collect(Collectors.groupingBy(e -> e.getParentId()));

        return result;
    }


}




