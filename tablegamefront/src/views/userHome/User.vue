<template>
<div id="box">
  <h1>个 人 信 息</h1>
  <table cellspacing=0>
    <tr>
        <td>账号: <div class="content">{{user.account}}</div></td>
    </tr>
    <tr>
        <td>名称: <div class="content">{{user.name}}</div></td>
    </tr>
    <tr>
        <td>密码: <div class="content">{{user.password}}</div></td>
    </tr>
    <tr>
        <td>性别: <div class="content">{{user.sex}}</div></td>
    </tr>
    <tr>
        <td>电话: <div class="content">{{user.phone}}</div></td>
    </tr>
    <tr>
        <td class="last">
            <el-button>确定</el-button>
            <el-button type="primary" @click="change()">修改</el-button>
        </td>
    </tr>
  </table>
  <User :user='user' :dialog="dialog" @turnVisible='getVisible' v-if="dialog"></User>
</div>
</template>

<script>
import User from "@/components/User";
export default {
    components: { 
    User 
    },
    data(){
        this.$nextTick(()=>{
            this.getUserInfor();
        })
        return{
            dialog:false,
            judge:false,
            user:{
                account:'',
                name:'',
                password:'',
                sex:'',
                phone:'',
            }
        }
    },
    methods:{
        getUserInfor(){
            this.axios.get('/userHome/'+sessionStorage.getItem('account')).then((res)=>{
                if(res.data.flag){
                    this.user = res.data.data;
                }
            })
        },
        getVisible(value){
            console.log(value);
            this.dialog = value;
        },
        change(){
            this.dialog = true;
        }
    }
}
</script>

<style scoped>
#box{
    border: 1px solid black;
    width: 30%;
    height: 450px;
    margin: 4% 32% 0 32%;
}
h1{
    width: 100%;
    text-align: center;
}
table{
    width: 70%;
    margin: 10% 15% 0 15%;
}
td{
    border-left: 1px solid black;
    border-right: 1px solid black;
    border-top: 1px solid black;
    color:#606266;
    font-size: 15px;
    height: 50px;
}
.content{
    margin-left: 20%;
    color: #303133;
    font-size: 16px;
}
.last{
    height: 70px;
    border: 1px solid black;
}
.el-button{
    margin-left: 18%;
}
</style>