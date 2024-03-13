import axios from "axios";
import {HTTP_STATUS} from "@/utils/constant/HttpStatus";

// 创建axios实例
const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
    // withCredentials: true, // 跨域请求时发送cookie
    timeout: 25000, // 请求超时的时长
    // withCredentials: true //跨域请求时是否需要使用凭证  简单讲：跨域请求是否提供凭据信息(cookie、HTTP认证及客户端SSL证明等)，也可以简单的理解为，当前请求为跨域类型时是否在请求中协带cookie。
});

// 请求拦截器（对请求数据配置做统一处理）
service.interceptors.request.use(
    //在发送请求之前做些什么
    config => {

        // 在发送请求之前做些什么
        const tokenStr = window.localStorage.getItem('token')
        if (tokenStr!=null){
            config.headers['token'] = tokenStr;
        }
        // if (store.getters.token) {
        //     // 让每个请求都携带令牌
        //     // ['Authorization'] 是一个自定义标题键
        //     // 请根据实际情况修改
        //     config.headers['Authorization'] = 'Bearer ' + getToken();
        // } else {
        //     config.headers['Authorization'] = 'Basic UGFzc3dvcmQwbyFAIw==';
        // }
        return config;
    },

    // 对请求错误做些什么，异常一般由config抛出
    error => {
        // 处理请求错误
        return Promise.reject(error);
    }
);

// 响应拦截器（对成功请求到数据做处理）
service.interceptors.response.use(
    /**
     * 如果您想获取http信息，如标题或状态
     * Please return  response => response
     */
    /**
     * 通过自定义代码确定请求状态
     * 这里只是一个例子，参考即可
     * 您还可以通过HTTP状态代码来判断状态
     */

    response => {
        const res = response.data;
        if(res.code === HTTP_STATUS.SUCCESS || res.code === HTTP_STATUS.ACCEPTED) {
            // 正常响应处理
            return (res);
        } else{
            return Promise.reject(new Error(`异常响应 (code: ${res.code})`))
        }
    },
    error => {
        return Promise.reject(error)
    }
);




export default service;
