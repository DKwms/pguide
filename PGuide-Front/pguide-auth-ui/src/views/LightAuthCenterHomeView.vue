<template>
    <div class="body">
        <div class="login">
            <div>
                <h2>项导鉴权中心</h2>
            </div>
            <br>
            <div class="formBox">
                <div class="loginInput">
                    <div class="inputBox">
                        <input type="text"
                               class="account"
                               v-model="loginBody.account"
                                placeholder="账户">
                    </div>
                </div>
                <div class="loginInput">
                    <div class="inputBox">
                        <input type="password"
                               class="password"
                               v-model="loginBody.password"
                                placeholder="密码">
                    </div>
                </div>
                <div class="loginInput">
                    <input type="text"
                           style="width: 60%;height: 100%;font-size: 20px;text-align: center;background-color: #c5e5f5;border:none" v-model="loginBody.code">
                    <label style="width: 40%;line-height: 50px;text-align: center">
                        <img :src="imgUrl" @click="getCode" class="codeImage" alt="error" style="border-radius: 2px;border:0px;padding: 0;text-decoration: none;">
                    </label>
                </div>

                <div class="loginBox" style="justify-content: space-between;display: flex;">
                    <div @click="checkBox('teacher')">
                       <template v-if="userType==='teacher'">
                           <id-check-button value="teacher" style="border-radius: 10px;background-color:  #9ce179;background:#9ce179;transition: background-color 0.41s" ></id-check-button>
                       </template>
                        <template v-if="userType!=='teacher'">
                            <id-check-button value="teacher" style="border-radius: 10px;" ></id-check-button>
                        </template>
                    </div>
                    <div  @click="checkBox('student')">
                        <template v-if="userType==='student'">
                            <id-check-button value="student" style="border-radius: 10px;background-color: #9ce179;transition: background-color 0.41s"></id-check-button>
                        </template>
                        <template v-if="userType!=='student'">
                            <id-check-button value="student" style="border-radius: 10px;"></id-check-button>
                        </template>

                    </div>
                </div>

                <!--              第三方登录-->
                <div class="loginInputT" style="margin-top: 15px;position: relative;padding: 5px">
                    <div class="threeParty">
                        <!--                      第三方盒子数量大于四的时候-->
                        <template v-if="threePartyInfo.length>=4">
                            <div class="threePartyBox">{{ threePartyInfo[0]["thirdPartyName"] }}</div>
                            <div class="threePartyBox">{{ threePartyInfo[1]["thirdPartyName"] }}</div>
                            <div class="threePartyBox">{{ threePartyInfo[2]["thirdPartyName"] }}</div>
                            <div class="threePartyBox moreThreePartyLogin" style="text-align: center;line-height: 45px;"
                                 v-on:mouseenter="threePartyHover">
                                ...
                                <div class="leftMoreLoginNav" v-if="moreThreePartyKey">
                                    <div style="width: 20px;height: 20px;border: 1px solid red;position: absolute;right: 0"
                                         v-on:mouseenter="threePartyNavHover"></div>
                                    <!--                                  更多第三方登录盒-->
                                    <div class="threePartyBox" style="margin-top: 30px">
                                        {{ threePartyInfo[3]["thirdPartyName"] }}
                                    </div>
                                    <template v-for="tpi in threePartyInfo" id="tpi.thirdPartyId">
                                        <div class="threePartyBox" v-if="threePartyInfo.indexOf(tpi)>3">
                                            {{ tpi["thirdPartyName"] }}
                                        </div>
                                    </template>
                                </div>
                            </div>
                        </template>
                        <!--                      第三方盒子数量小的时候-->
                        <template v-if="threePartyInfo.length<4">
                            <template v-for="tpi in threePartyInfo" id="tpi.thirdPartyId">
                                <div class="threePartyBox">{{ tpi["thirdPartyName"] }}</div>
                            </template>
                        </template>
                    </div>
                </div>

                <!--              登录-->
                <div style="display: flex;justify-content: center;width: 80%;margin-bottom: 20px;">
<!--                    <input type="button" value="登录" class="loginButton" @click="login()">-->
<!--                    <login-button  @click="login()"></login-button>-->
                    <div @click="login()">
                        <login-button  style="border-radius: 10px">登录</login-button>
                    </div>

                </div>
            </div>
        </div>
    </div>
</template>

<script>
import {getCodeImg, getThirdPartyList, login, subSystemLogin} from "@/api/login";
import  {TOKEN_PRE} from "@/utils/constant/TokenInfo";
import LoginButton from "@/components/button/LoginButton.vue";
import IdCheckButton from "@/components/button/IdCheckButton.vue";

export default {
    name: 'DarkAuthCenterHomeView',
    components: {IdCheckButton, LoginButton},
    data() {
        return {
            moreThreePartyKey: false,
            imgUrl: "",
            userType:"",
            sysType:"pguide",
            loginBody: {
                account: "",
                password: "",
                uuid: "",
                code: "",
                redirectUrl: ""
            },
            isFromSubSystem:false,
            subSystemLoginBody: {
                account: "",
                password: "",
                uuid: "",
                code: "",
                tokenCode:"",
                redirectUrl: ""
            },
            threePartyInfo: [],

        }
    },
    methods: {
        checkBox(name){
            this.userType = name;
        },
        threePartyHover() {
            this.moreThreePartyKey = true;
        },
        threePartyNavHover() {
            this.moreThreePartyKey = false;
        },
        // login api
        login() {
            //pre deal 前置判断，看是否符合值
            if (this.loginBody.account == null) {
                console.log("密码不能为空");
                return
            }

            if (!this.isFromSubSystem){
                this.loginBody.sysType = this.sysType;
                this.loginBody.userType = this.userType;
                login(this.loginBody).then(res => {
                    // get token in local with token_pre
                    localStorage.setItem(TOKEN_PRE, res.data)
                }).catch(e => {
                    // exception dealer
                    console.log(e)
                })
            }else{
                // 封装属性
                this.subSystemLoginBody.code = this.loginBody.code
                this.subSystemLoginBody.sysType = this.sysType;
                this.subSystemLoginBody.userType = this.userType;
                this.subSystemLoginBody.account = this.loginBody.account
                this.subSystemLoginBody.password = this.loginBody.password
                this.subSystemLoginBody.uuid = this.loginBody.uuid

                subSystemLogin(this.subSystemLoginBody).then(res => {
                    // 进行重定向
                    //TODO 储存TOKEN，以及重定向回原来位置
                    console.log(res.data.token)
                    console.log(res.data.redirectUrl)
                    //TODO 返回原来位置的时候，在子系统通过tokenCode来兑换token
                    window.location = res.data.redirectUrl
                }).catch(e => {
                    console.log(e)
                })
            }
        },
        getCode() {
            getCodeImg().then(res => {
                // deal the return value ,
                this.loginBody.uuid = res.data.uuid;
                this.imgUrl = "data:image/gif;base64," + res.data.img;
            })
        },
        // 拉取第三方信息
        getThreePartyInfo() {
            getThirdPartyList().then(res => {
                this.threePartyInfo = res.data
            }).catch()
        },
        subSysLoginCheck(){
            //TODO 开发环境中使用会hash模式来解析，后面上限nginx代理后需要更改
            var prehref = window.location.href;
            // 开发模式去#/
            var href = prehref.split('#/');
            var url = new URL(href);
            const code = url.searchParams.get('code');
            console.log(code)
            const sendUrl = url.searchParams.get('sendUrl');
            console.log(sendUrl)

            this.subSystemLoginBody.tokenCode = code;
            this.subSystemLoginBody.redirectUrl = sendUrl

            // 登录模式切换
            if (sendUrl!=null &&(code!=null)){
                this.isFromSubSystem = true;
            }
        }
    },
    mounted() {
        console.log("=====================重定向参数检查====================================")
        this.subSysLoginCheck()

        console.log("=====================get the token by token_pre======================")
        console.log(localStorage.getItem(TOKEN_PRE))

        // 第三方信息拉取
        this.getThreePartyInfo()

        //验证码
        this.getCode()
    }
}
</script>


<style scoped>
.codeImage {
    width: 100%;
    height: 100%;
}

.body {
    height: 100vh;
    width: 80vw;
    display: flex;
    justify-content: center;
    align-items: center;
}

.login {
    background-color: rgba(89, 89, 89, 0.15);
    backdrop-filter: blur(1px);
    -webkit-backdrop-filter: blur(30px);
    border: 0.888889px solid rgba(255, 255, 255, 0.18);
    box-shadow: rgba(14, 14, 14, 0.19) 0px 6px 15px 0px;
    -webkit-box-shadow: rgba(14, 14, 14, 0.19) 0px 6px 15px 0px;
    border-radius: 25px;
    -webkit-border-radius: 25px;
    color: rgba(128, 128, 128, 0.6);
    width: 100%;
    max-width: 450px;
    height: 500px;
    display: flex;
    flex-direction: column;
    align-items: center;

}

.formBox {
    display: flex;
    flex-direction: column;
    align-items: center;
    border-radius: 30px;
    width: 80%;
}

.loginInput {
    box-sizing: content-box;
    width: 90%;
    height: 50px;
    border: 2px solid #a1b6b7;
    background-color: #dcdcdc;
    margin: 10px;
    display: flex;
    border-radius: 10px;
    justify-content: center;
    overflow: hidden;
}

.loginInputT{
    box-sizing: content-box;
    width: 90%;
    height: 50px;
    border: 2px solid #a1b6b7;
    background-color: #dcdcdc;
    margin: 10px;
    display: flex;
    border-radius: 10px;
    justify-content: center;
    overflow: hidden;
}

.loginInput:hover{
    position: relative;
    box-shadow:
        0px 0px 10px 2px #a2a2a2;
    transition: box-shadow 0.25s;
    &::after {
        position: absolute;
        text-align: center;
        content: "";
        z-index: 0;
        bottom: 0px;
        left: 0;
        width: 100%;
        height: 4px;
        /*background: linear-gradient(to right, #00bbff, #b600ff);*/
        background: #7e7b7b;
        animation: ani 0.24s ease;
    }
}

@keyframes ani {
    0%,20%{
        width: 20%;
    }
    30%,40%{
        width: 30%;
    }
    50%,60% {
        width: 45%;
    }
    70%,80%{
        width: 70%;
    }
    90%,100% {
        width: 100%;
    }

}

.loginBox {
    width: 90%;
    height: 50px;
}



.loginButton {
    width: 110px;
    height: 40px;
    border: 1px solid aqua;
}

.threeParty {
    display: flex;
    justify-content: space-between;
    width: 100%;
}

.threePartyBox {
    overflow: hidden;
    display: inline-block;
    border: 1px solid red;
    border-radius: 10px;
    width: 50px;
    height: 50px;
    text-align: center;
    line-height: 50px;
}

.leftMoreLoginNav {
    position: absolute;
    right: -100px;
    top: -100px;
    width: 80px;
    border: 1px solid aqua;
}


/*=========*/

body {
    /*font-family: 'Poppins', sans-serif;*/
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background-color: #29313a;
}


.inputBox input {
    position: relative;
    width: 100%;
    padding: 10px 0;
    background-color: transparent;
    border: none;
    outline: none;
    letter-spacing: .05em;
    font-size: 1.25em;
    transition: .5s;
}

button {
    font-size: 18px;
    letter-spacing: 2px;
    text-transform: uppercase;
    display: inline-block;
    text-align: center;
    font-weight: bold;
    padding: 0.7em 2em;
    border: 3px solid #00cfff;
    border-radius: 2px;
    position: relative;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.1);
    color: #34d9ca;
    text-decoration: none;
    transition: 0.3s ease all;
    z-index: 1;
}


.password{

}

.account{

}

</style>
