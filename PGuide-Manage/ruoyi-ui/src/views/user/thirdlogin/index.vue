<template>
  <div>
    {{ baseData }}
  </div>
</template>

<script>
import {listTable} from '@/api/user/thirdlogin'
export default {
  name: "ThirdPartLogin",
  data(){
    return {
      baseData:""
    }
  },
  mounted() {
   listTable().then(r=>{
     this.baseData = r;
     this.$message.success(r)
   });
  }
}
</script>

<style scoped>

</style>
