<template>
  <el-container>
  <el-header>
    <el-menu default-active="1" router class="el-menu-demo" mode="horizontal">
        <el-menu-item index="/manageHome">首页</el-menu-item>
        <el-menu-item index="/manageHome/userInfor">用户中心</el-menu-item>
        <el-menu-item index="/manageHome/gameInfor">游戏中心</el-menu-item>
        <el-menu-item index="/manageHome/roomInfor">房间中心</el-menu-item>
        <el-menu-item index="/manageHome/commentInfor">留言中心</el-menu-item>
        <el-menu-item index="/manageHome/logInfor">订单中心</el-menu-item>
        <el-menu-item style="margin-left:40%"><a href="/#/login">退出登录</a></el-menu-item>
    </el-menu>
  </el-header>
  <el-main>
    <el-image
        style="width: 100%; height: 533px"
        :src="url"
        v-show="show"
        fit="fill">
    </el-image>
    <router-view></router-view>
  </el-main>
</el-container>
</template>

<script>
export default {
    data(){
        return{
            show:true,
            url:'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202007%2F21%2F20200721113610_fesjn.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1686046703&t=e858866513ce34725c4b1c3bbdd8d5e0',
        }
    },
    watch:{
        $route(to,from){
            if(to.path !== '/manageHome'){
                this.show = false;
            }
            else{
                this.show = true;
            }
        }    
	}
}
</script>

<style scoped>
.el-header{
    padding: 0;
}
.el-main{
    padding: 0;
}
</style>