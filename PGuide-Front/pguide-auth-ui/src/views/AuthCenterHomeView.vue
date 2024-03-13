<template>
    <div class="body">
        <WaveInput></WaveInput>
        <div class="login">
            <div>
                <h2>项导鉴权中心</h2>
            </div>
            <br>
            <div class="formBox">
<!--                account-->
                <div class="loginInput">
                    <div class="inputBox">
                        <input type="text" required style="font-size: 18px;position: relative;z-index: 999"
                               v-model="loginBody.account">
                        <label id="waveLabel" class="waveLabel" style="font-size: 20px">account </label>
                    </div>
                </div>
<!--                password-->
                <div class="loginInput">
                    <div class="inputBox">
                        <input type="password" required style="font-size: 18px;position: relative;z-index: 999"
                               v-model="loginBody.password">
                        <label id="waveLabel" class="waveLabel" style="font-size: 20px">password </label>
                    </div>
                </div>
<!--                code-->
                <div class="loginInput">
                    <input type="text" class="password"
                           style="width: 60%;height: 100%;font-size: 20px;text-align: center;" v-model="loginBody.code">
                    <label style="width: 40%;line-height: 50px;text-align: center">
                        <img :src="imgUrl" @click="getCode" class="codeImage" alt="aa">
                    </label>
                </div>

                <!--              第三方登录-->
                <div class="loginInput" style="margin-top: 15px;position: relative">
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
                <div style="display: flex;justify-content: center;width: 80%;margin-bottom: 20px;margin-top: 30px">
                    <input type="button" value="登录" class="loginButton" @click="login()">
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import {getCodeImg, getThirdPartyList, login, subSystemLogin} from "@/api/login";
import  {TOKEN_PRE} from "@/utils/constant/TokenInfo";

export default {
    name: 'HomeView',
    data() {
        return {
            moreThreePartyKey: false,
            imgUrl: "",
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
            var href = prehref.split('#/')[0];
            var url = new URL(href);
            const code = url.searchParams.get('code');
            const sendUrl = url.searchParams.get('sendUrl');
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
        // waveinput init
        const labels = document.getElementsByClassName('waveLabel')
        for (const label of labels) {
            label.innerHTML = label.innerText.split('').map((letters, i) => `<span style="transition-delay: ${i * 80}ms; filter:hue-rotate(${i * 5}deg);">${letters}</span>`).join('')
        }

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
    border: 1px solid red;
    height: 100vh;
    width: 80vw;
    display: flex;
    justify-content: center;
    align-items: center;
}

.login {
    border: 1px solid red;
    width: 100%;
    max-width: 450px;
    height: 65%;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.formBox {
    display: flex;
    flex-direction: column;
    align-items: center;
    border: 1px solid aqua;
    width: 80%;
}

.loginInput {
    width: 90%;
    height: 50px;
    border: 1px solid greenyellow;
    margin: 10px;
    display: flex;
    justify-content: center;
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

.inputBox {
    position: relative;
    width: 400px;
}

.inputBox input {
    position: relative;
    width: 100%;
    padding: 10px 0;
    background-color: transparent;
    border: none;
    outline: none;
    border-bottom: 2px solid #d7fffc;
    color: #fff;
    letter-spacing: .05em;
    font-size: 1.25em;
    transition: .5s;
}

.inputBox label {
    position: absolute;
    left: 0;
    font-size: 1.25em;
    pointer-events: none;
    color: #666;
    user-select: none;
}

.inputBox label span {
    position: relative;
    display: inline-flex;
    flex-direction: row;
    font-size: 1.25em;
    letter-spacing: .05em;
    transition: .25s cubic-bezier(0.5, 1, 0.5, 1.5);
}

.inputBox input:focus ~ label span,
.inputBox input:valid ~ label span {
    color: #0f0;
    text-shadow: 0 0 5px #0f0,
    0 0 10px #0f0,
    0 0 30px #0f0;
    transform: translateY(-30px);
}

.inputBox input:focus,
.inputBox input:valid {
    border-bottom-color: #fff;
}


</style>
