import axios from "axios";
import {HTTP_STATUS} from "@/utils/constant/HttpStatus";
import { v4 as uuidv4 } from 'uuid';

const loginService = axios.create({
    baseURL: process.env.VUE_APP_AUTH_API, // url = base url + request url
    // withCredentials: true, // 跨域请求时发送cookie
    timeout: 25000, // 请求超时的时长
    // withCredentials: true //跨域请求时是否需要使用凭证  简单讲：跨域请求是否提供凭据信息(cookie、HTTP认证及客户端SSL证明等)，也可以简单的理解为，当前请求为跨域类型时是否在请求中协带cookie。
});

loginService.interceptors.request.use(
    config => {
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);

// 响应拦截器（对成功请求到数据做处理）
loginService.interceptors.response.use(
    response => {
        const res = response.data;

        // 正常流程处理
        if(res.code === HTTP_STATUS.SUCCESS || res.code === HTTP_STATUS.ACCEPTED || res.code===200) {
            return (res);
        } else if(res.code === HTTP_STATUS.REDIRECT){
            // 重定向处理流程
            console.log("============进行重定向登录===========")
            let redirectUrl = res.data["redirectUrl"]
            let sendUrl = res.data["sendUrl"]

            // 编码 sendUrl 参数的值
            const encodedSendUrl = encodeURIComponent(sendUrl);
            //关键uuid，后面需要换取token
            var uuid = uuidv4();
            localStorage.setItem("tokenCode",uuid);
            // 构建新的 URL
            const newURL = `${redirectUrl}#/redirect?code=${uuid}&sendUrl=${encodedSendUrl}`;

            window.location = newURL

        } else{
            return Promise.reject(new Error(`异常响应 (code: ${res.code})`))
        }
    },
    error => {
        return Promise.reject(error)
    }
);




export default loginService;
