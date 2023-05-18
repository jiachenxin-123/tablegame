import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from '@/views/Login'
import Register from '@/views/Register'
import UserHome from '@/views/UserHome'
import Game from '@/views/userHome/Game'
import Room from '@/views/userHome/Room'
import Comment from '@/views/userHome/Comment'
import User from '@/views/userHome/User'

import ManageHome from '@/views/ManageHome'
import UserInfor from '@/views/manageHome/UserInfor'
import GameInfor from '@/views/manageHome/GameInfor'
import RoomInfor from '@/views/manageHome/RoomInfor'
import CommentInfor from '@/views/manageHome/CommentInfor'
import LogInfor from '@/views/manageHome/LogInfor'
Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    component: Login
  },
  {
    path: '/register',
    component: Register
  },
  {
    path: '/userHome',
    component: UserHome,
    children:[
      {
        path:'/userHome/game',
        component:Game
      },
      {
        path:'/userHome/room',
        component:Room
      },
      {
        path:'/userHome/comment',
        component:Comment
      },
      {
        path:'/userHome/user',
        component:User
      }
    ]
  },
  {
    path:'/manageHome',
    component:ManageHome,
    children:[
      {
        path:'/manageHome/userInfor',
        component:UserInfor
      },
      {
        path:'/manageHome/gameInfor',
        component:GameInfor
      },
      {
        path:'/manageHome/roomInfor',
        component:RoomInfor
      },
      {
        path:'/manageHome/commentInfor',
        component:CommentInfor
      },
      {
        path:'/manageHome/logInfor',
        component:LogInfor
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
