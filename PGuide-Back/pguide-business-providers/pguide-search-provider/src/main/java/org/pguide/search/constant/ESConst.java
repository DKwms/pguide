package org.pguide.search.constant;

/**
 * @author DKwms
 * @Date 2024/1/23 11:14
 * @description
 */
public interface ESConst {

    /**
     * 基础常量
     */
    interface SysConst{
        // 系统默认最大单次查询文档数量上线
        int SYS_BASE_MAX_DOC_SIZE = 50;
    }

    /**
     * 索引常量
     */
    interface IndexConst{
        // 项目信息索引
        String PROJECT_INFO = "pguide_groupinfo";
    }
}
