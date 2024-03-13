import service from "@/utils/request";

/**
 * 学科树
 * @returns {*}
 */
export function getSubjectTree(){
    return service({
        url:"/cms/subject/tree",
        method:"get",
    })
}
