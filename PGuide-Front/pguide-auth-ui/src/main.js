import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

router.beforeEach((to,from,next)=>{
  // 开启验证
  console.log(to.path)
  if (process.env.VUE_APP_IF_OPEN_AUTH){
    // 关闭验证
    next()
  }
  // 守护路由检测

})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
