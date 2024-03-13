
import {getToken, setToken} from "@/utils/auth";
import {login} from "@/api/login";

const user = {

    state: {
        token: getToken(),
        name: '',
        roles: [],
        permissions: [],
        userInfo:{
            userName:"null",
            userSchool:"",
            userAccount:"",
            userAcademy:"",
            userType:"",
            // 后续跳转相应控制台所需
            userGroup:[
                {
                    groupName:"",
                    groupId:""
                },
            ],
        }
    },

    mutations: {
        SET_TOKEN: (state, token) => {
            state.token = token
        },
        SET_NAME: (state, name) => {
            state.name = name
        },
        SET_ROLES: (state, roles) => {
            state.roles = roles
        },
        SET_PERMISSIONS: (state, permissions) => {
            state.permissions = permissions
        },
        SET_USERINFO:(state,userInfo)=>{
            state.userInfo = userInfo
        }
    },

    actions: {
        Login({ commit }, userInfo) {
            const username = userInfo.account
            const password = userInfo.password
            const code = userInfo.code
            const uuid = userInfo.uuid

            return new Promise((resolve, reject) => {
                login(username, password, code, uuid).then(res => {
                    console.log(res)

                    setToken(res.token)
                    commit('SET_TOKEN', res.token)
                    // 成功回调
                    resolve()
                }).catch(error => {
                    // 失败回调
                    reject(error)
                })
            })
        }
    }

}

export default user
