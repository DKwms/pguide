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
  {
    path: '/homePage',
    name: "homePage",
    component: HomeView,
    children:[
      {
        path:"/detailPage",
        name:"detailPage",
        component: ()=>import("@/views/details/DetailPage.vue")
      }
    ]
  },
  {
    path: '/details',
    name: "detailPage",
    component: ()=>import("@/views/details/DetailPage.vue")
  },
  {
    path: '/user',
    name: 'userCenter',
    component: () => import('@/views/details/user/UserCenter.vue'),
    children: [
      {
        path: '', // Empty path means it will be the default child route
        name: 'UserCenterIndex',
        component: () => import('@/views/details/user/created/UserCenterIndex.vue')
      },
      {
        path: 'create/group',
        name: 'CreatedGroup',
        component: () => import('@/views/details/user/created/CreatedGroup.vue')
      },
      {
        path: 'create/resume',
        name: 'CreatedResume',
        component: () => import('@/views/details/user/created/CreatedResume.vue')
      }
    ]
  },
  {
    path: '/403',
    name:"error",
    component: ()=>import("../views/error/403.vue")
  },
  {
    path: '/group',
    name:"groupCreate",
    component: ()=>import("@/views/details/user/created/CreatedGroup.vue")
  },
  {
    path: '/resume',
    name:"groupResume",
    component: ()=>import("@/views/details/user/created/CreatedResume.vue")
  }
]

const router = new VueRouter({
  routes
})

export default router
