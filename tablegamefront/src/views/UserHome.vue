<template>
  <el-container>
    <el-header>
        <el-menu default-active="2"
            class="el-menu-demo"
            mode="horizontal"
            background-color="#545c64"
            text-color="#fff"
            router
            active-text-color="#ffd04b">
            <el-menu-item index="/userHome">首页</el-menu-item>
            <el-submenu index="2">
                <template slot="title">游戏中心</template>
                <el-menu-item index="/userHome/game">游戏信息</el-menu-item>
                <el-menu-item index="/userHome/room">房间信息</el-menu-item>
            </el-submenu>
            <el-menu-item index="/userHome/comment">留言</el-menu-item>
             <el-submenu index="4">
                <template slot="title">我的</template>
                <el-menu-item index="/userHome/user">基本信息</el-menu-item>
                <el-menu-item @click="table = true">历史订单</el-menu-item>
            </el-submenu>
            <el-menu-item style="margin-left:50%"><a href="/#/login" @click="clearSession()">退出登录</a></el-menu-item>
            </el-menu>
    </el-header>
    <el-main style="padding:0">
         <j-hover-btn bgColor = 'pink' 
			:width = '80' 
			text = '当前订单' 
            :btn-style = "btnStyle"
			@hoverBtnClick = "dialogshow = true">
            
        </j-hover-btn>
        <el-image
        style="width: 100%; height: 533px"
        :src="url"
        v-show="show"
        fit="fill"></el-image>
        <router-view></router-view>
        <HistoryLog :table='table' @turntable='gettable' v-if="table"></HistoryLog>
        <NowLog :dialogshow='dialogshow' @turndialog='getdialog' v-if="dialogshow"></NowLog>
    </el-main>
  </el-container>
</template>

<script>
import HistoryLog from "@/components/HistoryLog";
import NowLog from "@/components/NowLog";
export default {
    components: { 
        HistoryLog,
        NowLog
    },
    data() {
        return {
             btnStyle:{
                "marginLeft":'85%',
                "marginTop":'35%'
                },
            dialogshow:false,
            table:false,
            show:true,
            url: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202007%2F21%2F20200721112832_wwvog.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1686046703&t=6e4e01820d2a7be403d362bb2ac65e96'
        }
    },
    methods:{
        getdialog(value){
            this.dialogshow = value;
        },
        clearSession(){
            window.sessionStorage.clear();
        },
        gettable(value){
            this.table = value;
        },
    },
    watch:{
        $route(to,from){
            if(to.path !== '/userHome'){
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
.el-menu-item{
    width: 10%;
    text-align: center;
}
</style>