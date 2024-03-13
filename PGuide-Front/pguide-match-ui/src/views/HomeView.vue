<template>
  <div class="bodyBox" >
      <!--    TOP-->
      <NavTop class="navTop" >

      </NavTop>
      <HomeBody class="homeBody" >

      </HomeBody>
  </div>


</template>

<script>
// @ is an alias to /src
import NavTop from "@/views/frame/NavTop.vue";
import HomeBody from "@/views/frame/HomeBody.vue";
export default {
  name: 'HomeView',
  components: {
      NavTop,
      HomeBody,
  }
}
</script>

<style scoped>

*{
    margin: 0px;
    padding: 0px;
}
.bodyBox{
    display: flex;
    justify-content: center;
    flex-direction: column;
}

.homeBody{
    width: 100vw;
}


</style>
