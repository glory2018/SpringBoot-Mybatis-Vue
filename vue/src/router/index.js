import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/view/Login'
import UserIndex from '@/view/UserIndex'
import UserDetail from '@/view/UserDetail'
Vue.use(Router)

export default new Router({
  routes: [{
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/user',
    name: 'UserIndex',
    meta: {
      requireAuth: true
    },
    component: UserIndex
  },
  {
    path: '/userDetail',
    name: 'UserDetail',
    meta: {
      requireAuth: true
    },
    component: UserDetail
  }
  ]
})
