package org.pguide.mms.manage.controller.publish.es.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pguide.mms.manage.controller.publish.es.domain.bo.CptInfo;
import org.pguide.mms.manage.controller.publish.es.domain.bo.Member;
import org.pguide.mms.manage.controller.publish.es.domain.bo.Needs;

import java.util.List;

/**
 * @author DKwms
 * @Date 2024/1/23 10:35
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectInfo {
    @JsonProperty
    private String projectName;
    @JsonProperty
    private String subject;
    //简介
    @JsonProperty
    private String introduction;
    // 详情
    @JsonProperty
    private String details;
    @JsonProperty
    private List<Member> member;
    @JsonProperty
    private String school;
    @JsonProperty
    private String academy;
    @JsonProperty
    private String openLevel;
    @JsonProperty
    private List<CptInfo> cptInfo;
    @JsonProperty
    private int coin;
    @JsonProperty
    private String city;
    @JsonProperty
    private Needs needs;
}
