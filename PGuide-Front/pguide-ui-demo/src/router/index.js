import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  //    登录路由组件
  {
    path: '/login',
    name: "login",
    component: () => import("../login.vue")
  }
]

const router = new VueRouter({
  routes
})

export default router
