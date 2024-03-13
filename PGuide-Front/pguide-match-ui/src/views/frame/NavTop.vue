<template>

  <div>
      <div class="navBox">
          <div class="leftBox" style="margin-left: 50px">
              <div>网站信息</div>
          </div>
          <div class="searchBox">
              <!--<el-input placeholder="搜点什么吧" class="input"></el-input>-->
              <!--<div style="display: inline-block;border: 1px solid red;width: 40px;text-align: center">icon</div>-->
          </div>
          <div class="rightBox" style="margin-right: 50px">
              <div class="userInfoBox" @mouseover="showUserInfo()" @mouseleave="closeUserInfo()" @mousedown="toUserCenter()">用户信息</div>
          </div>

      </div>

      <div v-show="showUserDetail" class="userDetail" style="margin-right: 35px;padding:10px">
          <div style="float: right">^</div> <br>
          <div>
              <ul style="list-style: none">
                  <li>a</li>
                  <li>b</li>
                  <li>c</li>
              </ul>

          </div>
      </div>
  </div>

</template>

<script>
// @ is an alias to /src

export default {
    name: 'NavTop',
    components: {
    },
    data(){
        return {
            showUserDetail:false
        }
    },
    methods:{
        showUserInfo(){
            this.showUserDetail = true;
        },
        closeUserInfo(){
           this.showUserDetail = false;
        },
        toUserCenter(){
            window.open(process.env.VUE_APP_SELF_PATH_HIS+"user")
        }
    }
}
</script>

<style scoped>
.navBox{
    display: flex;
    justify-content: space-between;
    box-shadow: 0 0 15px 2px black;
    width: 100vw;
    height: 50px;
    background-color: #80FFDB;
}

.leftBox{
    display: flex;
    justify-content: center;
    height: 100%;
    border: 1px solid red;
}
.searchBox{
    display: flex;
    justify-self: center;
    margin-top: 5px;
    width: 50vw;
    height: 40px;
}

.userInfoBox{
    display: flex;
    justify-self: center;
    border: 1px solid red;
    height: 100%;
}
.userDetail{
    position: absolute;
    right: 0;
    background-color: #b3b1b1;
    top:50px;

}

</style>
