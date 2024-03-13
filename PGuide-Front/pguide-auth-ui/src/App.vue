<template>

  <div class="app move">
     <LightAuthCenterHomeView></LightAuthCenterHomeView>
  </div>
</template>

<style>

*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

.app{
    display: flex;
    justify-content: center;
    /*background-image: url("../src/static/svg.png");*/
    }

.move{
    background: linear-gradient(-45deg, rgba(100, 201, 201, 0.5), #97dfd2, #81d9c4, #88d9e6);
    background-size: 600% 600%;
    animation: moveb 5s ease infinite;
}


@keyframes moveb {
    0% {
        background-position: 0% 50%;
    }
    50% {
        background-position: 100% 50%;
    }
    100% {
        background-position: 0% 50%;
    }

}


</style>
<script>
import HomeView from "@/views/AuthCenterHomeView.vue";
import LightAuthCenterHomeView from "@/views/LightAuthCenterHomeView.vue";

export default {
    components: {LightAuthCenterHomeView, HomeView},

}
</script>
