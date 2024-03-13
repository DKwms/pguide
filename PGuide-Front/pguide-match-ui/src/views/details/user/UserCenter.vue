<template>
  <div class="main" style="border: 1px solid red;display: flex;justify-content: center;align-items: center;flex-direction: column;">

      <div style="width: 100%;height: 50px;border: 1px red dashed;margin-bottom: 20px;
      display: flex;justify-content: space-between;">
          <div>
              <el-button type="primary" size="small" style="height: 100%" @click="backToIndex">
                  < RETURN
              </el-button>
          </div>
          <div>
              CONTROL
          </div>
      </div>


      <router-view></router-view>



      <div style="width: 100%;height: 50px;border: 1px dashed goldenrod">
          BOTTOM
      </div>


  </div>
</template>

<script>
import {getUserInfoVo} from "@/api/login";
import AddNewItemCard from "@/components/card/AddNewItemCard.vue";

export default {
    name: "UserCenter",
    methods:{
        // 返回首页
        backToIndex(){
            window.location = process.env.VUE_APP_SELF_PATH_HIS
        },

    },
    mounted() {

    }
}
</script>

<style scoped>

.main{

}




</style>
