import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/AuthCenterHomeView.vue'
import Light from "../views/LightAuthCenterHomeView.vue"

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Light
  },
//     重定向路由, 用于处理其他系统的登录
  {
    path: '/redirect/:code/:sendUrl',
    name: 'redirectAuth',
    component: Light
  }
]

const router = new VueRouter({
  routes
})

export default router
