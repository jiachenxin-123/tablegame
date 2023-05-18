<template>
<div>
  <table v-for="(game,index) in gamelist" :key="game.id">
    <tr>
        <td rowspan="2" class="img"></td>
        <td class="col">游戏名：<div class="content">{{game.name}}</div></td>
        <td class="col">时长(小时)：<div class="content">{{game.time}}</div></td>
        <td rowspan="2" class="intro">简介</td>
        <td rowspan="2" class="text">{{game.text}}</td>
        <td rowspan="2" class="button"><button @click="addGame(index)">选定</button></td>
    </tr>
    <tr>
        <td class="col">价格：<div class="content">{{game.price}}元</div></td>
        <td class="col">人数：<div class="content">{{game.min}}~{{game.max}}人</div></td>
    </tr>
  </table>
</div>
</template>

<script>
export default {
    data(){
        this.$nextTick(()=>{
            this.getInfor();
        })
        return{
            gamelist:[],
        }
    },
    methods:{
        getInfor(){
            this.axios.get('/userHome/game').then((res)=>{
                if(!res.data.flag){
                    this.$message.error(res.data.data);
                }
                else{
                    this.gamelist = res.data.data;
                }
            })
        },
        addGame(index){
            window.sessionStorage.setItem('gamename',this.gamelist[index].name);
            window.sessionStorage.setItem('duration',this.gamelist[index].time);
            window.sessionStorage.setItem('money',this.gamelist[index].price);
        }
    }
}
</script>
<style scoped>
table{
    border: 1px solid black;
    margin-top: 3px;
    width: 100%;
}
td{
    border: 1px solid black;
    height: 70px;
}
.img{
    width: 140px;
}
.intro{
    width: 3%;
    text-align: center;
}
.col{
    width: 20%;
    color:#606266;
    font-size: 15px;
}
.text{
    width: 40%;
}
.button{
    text-align: center;
}
.content{
    color: #303133;
    margin-left: 30%;
}
</style>