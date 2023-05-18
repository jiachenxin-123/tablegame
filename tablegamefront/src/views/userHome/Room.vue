<template>
<div>
  <table v-for="(room,index) in roomlist" :key="room.id">
    <tr>
        <td rowspan="2"></td>
        <td class="col">名称：<div class="content">{{room.name}}</div></td>
        <td class="col">状态：<div class="content">{{room.state | statefilter}}</div></td>
    </tr>
    <tr>
        <td class="col">容纳人数：<div class="content">{{room.min}}~{{room.max}}人</div></td>
        <td style="text-align:center"><button @click="addRoom(index)">选定</button></td>
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
            roomlist:[],
        }
    },
    methods:{
        getInfor(){
            this.axios.get('/userHome/room').then((res)=>{
                if(!res.data.flag){
                    this.$message.error(res.data.data);
                }
                else{
                    this.roomlist = res.data.data;
                }
            })
        },
        addRoom(index){
            window.sessionStorage.setItem('roomname',this.roomlist[index].name);
        }
    },
    filters: {
        statefilter(value) {
            if(value === 0){
                return '可选';
            }else{
                return '不可选';
            }
        }
    }

}
</script>

<style scoped>
table{
    width: 50%;

    float: left;
}
td{
    border: 1px solid black;
    height: 65px;
}
.col{
    color:#606266;
    font-size: 15px;
    width: 37%;
}
.content{
    color: #303133;
    margin-left: 30%;
}
</style>