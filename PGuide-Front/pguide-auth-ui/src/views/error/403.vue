<template>
  <div>
      {{ ifLoginText }}<br>
      <el-button type="primary" @click="clickToLogin">点击登录</el-button>
      <el-button type="danger" @click="clearHistory">点击删除登录缓存</el-button>
      <el-button type="success" @click="showLoginStatue">点击查看登录状态</el-button>
  </div>
</template>

<script>


import {getTokenByCode, loginToCenter} from "@/api/login";

export default {
    name: "403",
    data(){
        return {
            ifLoginText:"还没有登录，点击登录"
        }
    },
    methods:{
        clickToLogin(){
            this.$message.success("即将登录")
          loginToCenter();
        },
        /**
         * 测试清空历史数据，
         */
        clearHistory(){
            this.ifLoginText = "还没有登录，点击登录"
            localStorage.removeItem("tokenCode");
            localStorage.removeItem("token");
            this.$message.error("登录数据删除成功")
        },
        showLoginStatue(){
            var item = localStorage.getItem("token");
            this.$message.success("token:"+item+"\n\n"+"tokenCode:"+localStorage.getItem("tokenCode"))
        }
    },
    mounted() {

        // 如果有tokenCode，尝试发起请求获取token
        const item = localStorage.getItem("tokenCode");
        if (item!==null && item!=='null'){
            // 有item code
            const tokenCode = localStorage.getItem("tokenCode");
            this.$message.success("获取tokenCode成功："+tokenCode)
            // 换取token
            getTokenByCode(tokenCode).then((res)=>{
                //TODO 登录成功的返回信息比对
                if (res.data!=null){
                    // 登录成功
                    this.$message.success("tokenCode 登录成功："+res.data)
                    this.ifLoginText = "登录成功"
                    localStorage.setItem("token",res.data)
                    window.location = "/"
                }else {
                    // 通过item code换取token失败，过期或者未登录情况
                    this.$message.error("tokenCode 换取失败！")
                }
                // 登录成功清除tokenCode
                localStorage.removeItem("tokenCode")
            }).catch(e=>{
                // 登录换取tokenCode失败，也会清除token
                localStorage.removeItem("tokenCode")
                this.$message.error("tokenCode登录失败")
            })
        }else {
            this.$message.error("没有检测到tokenCode，尝试登录时重定向获取")
        }
    }
}
</script>

<style scoped>


</style>
