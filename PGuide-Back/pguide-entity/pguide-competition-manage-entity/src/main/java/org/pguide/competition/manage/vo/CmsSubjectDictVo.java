package org.pguide.competition.manage.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author DKwms
 * @Date 2024/1/17 10:56
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CmsSubjectDictVo {

    /**
     * 学科id
     */
    private Integer subjectId;

    /**
     * 学科名
     */
    private String subjectName;

    /**
     * 学科等级
     */
    private String subjectLevel;

    /**
     * 学科父级id subject_id
     */
    private Integer parentId;


}
