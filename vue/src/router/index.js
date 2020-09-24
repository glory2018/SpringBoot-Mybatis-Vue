import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/view/Login'
import UserIndex from '@/view/UserIndex'
import UserDetail from '@/view/UserDetail'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/user',
      name: 'UserIndex',
      component: UserIndex
    },
    {
      path: '/userDetail',
      name: 'UserDetail',
      component: UserDetail
    }
  ]
})
