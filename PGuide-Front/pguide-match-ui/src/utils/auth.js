
// 读取token的方法，暂时只在session域中
export function getToken(){
    return window.sessionStorage.getItem('token');
}

export function setToken(token){
    return window.sessionStorage.setItem('token',token);
}
