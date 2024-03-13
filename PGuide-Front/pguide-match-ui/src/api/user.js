import service from "@/utils/request";


/**
 * 获取基本用户信息
 * @returns {*}
 */
export function getUserInfo(){
    return service({
        url:"/auth/authCenter/redirect?sendUrl="+process.env.VUE_APP_SELF_PATH,
        method:"get"
    })
}
