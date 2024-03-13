import request from "@/utils/request";

export function login(loginBody) {
    return request({
        url: '/auth/login',
        method: 'post',
        data: {
            account: loginBody.account,
            password: loginBody.password,
            sysType:loginBody.sysType,
            userType:loginBody.userType,
            uuid: loginBody.uuid,
            code: loginBody.code,
            redirectUrl: loginBody.redirectUrl
        }
    })
}

export function subSystemLogin(reLoginBody) {
    return request({
        url:"/auth/authCenter/login",
        method:'post',
        data:reLoginBody
    })
}

export function getCodeImg() {
    return request({
        url: '/auth/getCaptch',
        method: 'get',
    })
}

/**
 * 第三方数据接口
 */
export function getThirdPartyList() {
    return request({
        url: "/auth/third",
        method: 'get'
    })
}
