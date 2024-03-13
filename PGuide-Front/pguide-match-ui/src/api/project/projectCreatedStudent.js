import service from "@/utils/request";

export function getUserInfo(vo){
    return service({
        url:"/mms/create/student/project/check",
        method:"post",
        data:vo
    })
}
