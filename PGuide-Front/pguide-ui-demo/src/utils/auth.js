
// 读取token的方法，暂时只在session域中
export function getToken(){
    return window.localStorage.getItem('token');
}

export function setToken(token){
    return window.localStorage.setItem('token',token);
}
