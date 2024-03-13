import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
// 导入es的css文件
import 'element-ui/lib/theme-chalk/index.css'
import '../src/assets/css/animista.css'


Vue.config.productionTip = false


// 添加守护路由，后面开启
router.beforeEach((to, from, next) => {
  if (to.path === '/login') return next();
  //获取token,这里暂时只存在session里面
  const tokenStr = window.localStorage.getItem('token')
  if (!tokenStr) return next('/login')
  next()
})

Vue.use(ElementUI)


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
