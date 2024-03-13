import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
Vue.config.productionTip = false

import VueAnimXYZ from '@animxyz/vue'
import '@animxyz/core'
Vue.use(VueAnimXYZ)

//el css
import 'element-ui/lib/theme-chalk/index.css'
// import '../src/assets/css/animista.css'

// 添加守护路由，后面开启
router.beforeEach((to,from,next)=>{
  var item = localStorage.getItem('token');

  // 未持有token，进行验证
  if (item==null && !(to.path === '/403') && (process.env.VUE_APP_IF_OPEN_AUTH==='true')) {
    // 重定向回来的请求
    next({path:"/403"})
  }

  next();
})


Vue.use(ElementUI)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
