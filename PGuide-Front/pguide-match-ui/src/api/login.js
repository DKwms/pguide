
import loginService from "@/utils/loginRequest";

import server from "@/utils/request"

/**
 * 没有token时，向验证中心发起请求
 */
export function loginToCenter(){
  return loginService({
    url:"/auth/authCenter/redirect?sendUrl="+process.env.VUE_APP_SELF_PATH,
    method:"get",
  })
}

export function getTokenByCode(tokenCode){
  return loginService({
    url:"/auth/authCenter/tokenEx?tokenCode="+tokenCode,
    method:"get",
  })
}

/**
 * 在登录成功后，通过token换取userinfovo
 * @returns {*}
 */
export function getUserInfoVo(){
  return server({
    url:"/auth/userinfo/vo",
    method:"get",
  })
}



