<template>
  <div>
      <div v-show="ifShowBase">
          <!--      用户信息-->
          <div style="margin-bottom: 10px">
              <div>USERINFO_HEADER</div>
              <div style="width: 95vw;min-width: 300px;height: 300px;border: 1px solid aqua;display: flex;justify-content: space-between;flex-direction: row;padding: 5px">
                  <div class="baseInfo" style="width: 49%;height: 100%;border: 1px solid red;display: flex;justify-content: space-between;flex-direction: row">
                      <ul style="list-style: none;width: 100%" class="userInfoUl">
                          <li>名称：{{ UserInfoVo.userName }}</li>
                          <li>账户：{{ UserInfoVo.userAccount }}</li>
                          <li>学院：{{ UserInfoVo.userAcademy }}</li>
                          <li>学校：{{ UserInfoVo.userSchool }}</li>
                          <li>用户类型：{{ UserInfoVo.userType }}</li>
                          <li>队伍：{{ UserInfoVo.userGroup }}</li>
                      </ul>
                      <div class="userBox" style="width: 200px;height: 100%;border: 1px solid red;display: flex;justify-content: center;align-items: center;flex-direction: column">
                          <!--  用户头像-->
                          <div style="width: 100%;height: 47%" class="userBoxHeader">
                          </div>
                          <!--用户头像下信息-->
                          <div style="width: 100%;height: 47%;text-align: center;line-height: 100px">
                              @ACCOUNT
                          </div>
                      </div>
                  </div>
                  <div class="otherInfo" style="width: 49%;height: 100%">
                      <div style="height: 20%;text-align: center;display: flex;justify-content: center;flex-direction: column">等级百分比图</div>
                      <div style="text-align: center;height: 7%">等级: xx  coin: xx</div>
                      <div style="width: 100%;height: 73%;text-align: center">
                          登录签到 | 积分记录
                      </div>
                  </div>
              </div>
          </div>
          <!--      用户组队信息-->
          <div style="margin-bottom: 10px">
              <div>GROUP INFO</div>
              <div style="width: 95vw;min-width: 300px;height: 300px;border: 1px solid aqua;padding: 5px">
                  <!--  没有队伍新增-->
                  <div v-show="!ifHasGroup" style="width: 100%;height: 100%">
                      <div
                              style="height: 100%;width: 100%;
                    display:flex;justify-content: center;align-items: center;flex-direction: column;">
                          <!--新增-->
                          <div @mousedown="projectAdd()">
                              <AddNewItemCard style="width: 360px;height: 180px;" ></AddNewItemCard>
                          </div>
                      </div>

                  </div>
                  <!--  有队伍队伍列表-->
                  <div v-show="ifHasGroup">

                  </div>
              </div>
          </div>
          <!--      其他-->
          <div>
              <div>RESUME</div>
              <div style="width: 95vw;min-width: 300px;height: 300px;border: 1px solid aqua;padding: 5px">
                  <!--  没有队伍新增-->
                  <div v-show="!ifHasGroup" style="width: 100%;height: 100%">
                      <div
                              style="height: 100%;width: 100%;
                    display:flex;justify-content: center;align-items: center;flex-direction: column;">
                          <!--新增-->
                          <div @mousedown="resumeAdd()">
                              <AddNewItemCard style="width: 360px;height: 180px;" ></AddNewItemCard>
                          </div>
                      </div>

                  </div>
                  <!--  有队伍队伍列表-->
                  <div v-show="ifHasGroup">

                  </div>
              </div>
          </div>
      </div>
  </div>
</template>

<script>
import AddNewItemCard from "@/components/card/AddNewItemCard.vue";
import {getUserInfoVo} from "@/api/login";

export default {
    name: "UserCenterIndex",
    components: {AddNewItemCard},
    data(){
        return{
            UserInfoVo:{},
            ifHasGroup:false,
            ifShowBase:true,
            // TODO 后端传值简历信息
            ifHasResume:false,
        }
    },
    mounted() {
        // 这里由于需要同步加载用户信息，所以直接同步使用
        // 同步
        // console.log(this.$store.state.user.userInfo)
        // // 异步
        // console.log(this.$store.getters.userInfo)

        this.UserInfoVo = null;
        if(this.$store.state.user.userInfo.userName=="null" || this.$store.state.user.userInfo.userName===""){
            // 没有用户信息，发起请求绑定
            getUserInfoVo().then(res=>{
                this.$store.commit("SET_USERINFO",res.data)
                this.UserInfoVo = res.data
                //TODO 为空 尚未加入任何组织
                if(res.data.userGroup !=null && res.data.userGroup!="null" && res.data.userGroup!==""){
                    this.ifHasGroup = true;
                }
            }).catch(e=>{
                console.log(e)
                this.$message.error("用户信息获取失败")
            })
        }else{
            this.UserInfoVo = this.$store.state.user.userInfo;
        }
        console.log(this.UserInfoVo)
    },
    methods:{

        // 项目创建引导
        projectAdd(){
            this.$message.success("开启项目创建")
            /**
             * 跳转新增页面
             */
            this.$router.push({
                name:"CreatedGroup"
            })
        },
        // 简历创建引导
        resumeAdd(){
            this.$message.success("开始创建简历")

            this.$router.push({
                name:"CreatedResume"
            })
        }
    }
}
</script>

<style scoped>
div{
    border: 1px dashed blueviolet;
}

.userInfoUl li{
    border-bottom: 1px solid gray;
    margin: 20px 10px;
}

.userBoxHeader {
    border-radius: 50% 50% 50% 50% / 50% 50% 50% 50%;
}
</style>
