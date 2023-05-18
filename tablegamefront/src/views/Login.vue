<template>
<div class="box">
    <h1>登&nbsp; &nbsp;&nbsp;&nbsp;录</h1>
    <el-form :model="loginInfor" :label-position="labelPosition" status-icon  label-width="80px" class="inner" :rules="rules">
      <el-form-item label="账号" prop="account">
        <el-input v-model="loginInfor.account" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="loginInfor.password" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="验证码" prop="validate"> 
        <el-input v-model="loginInfor.validate" autocomplete="off" class="vali"></el-input>
        <div class="confirm" @click="getCode">
            <ConfirmCode :confirmNum="confirmCode"/>
        </div>
          
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm()">登录</el-button>
      </el-form-item>
    </el-form>
    <a href="/#/register" class="super">去注册</a>
</div>
</template>

<script>
import ConfirmCode from "@/components/Confirm_Code";
export default {
    components: {
      ConfirmCode,
    },
    data() {
      var validatePass= (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          callback();
        }
      }
      var validateAccount = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入账号'));
        } else {
          callback();
        }
      }
      var validate1 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入验证码'));
        }else{
          callback();
        }
      };
      return {
        confirmCode: "",
        labelPosition: 'top',
        loginInfor:{
            account:'',
            password:'',
            validate:'',
        },
        rules: {
          password: [
            { validator: validatePass, trigger: 'blur' }
          ],
          account: [
            { validator: validateAccount, trigger: 'blur' }
          ],
          validate: [
            { validator: validate1, trigger: 'blur' }
          ],
        }
      };
    },
    created() {
      this.getCode();
    },
    methods:{
      getCode() {
        // 这里是随机进行产生4位字符串（26位小写字母和0-9数字中）
        this.confirmCode = Math.random().toString(36).slice(2, 6);
      },
      submitForm(){
        this.axios.get('/login/'+this.loginInfor.account+'/'+this.loginInfor.password).then((res)=>{
          if(res.data.flag){
            if(res.data.data === 0){
              window.sessionStorage.setItem('account',this.loginInfor.account);
              this.$router.push('/userHome');
            }else{
              this.$router.push('/manageHome');
            }
          }else{
            if(this.confirmCode !== this.loginInfor.validate)
            this.$message.error('验证码错误');
            else{
              this.$message.error(res.data.data);
            }
          }
        })
        this.getCode();
      },

    }
}
</script>

<style scoped>
    h1{
      text-align: center;
      margin-top: 35px;
    }
    .vali{
       width:50%;
       float: left;
    }
    .box{
      border: 1px solid black;
      width: 30%;
      height: 550px;
      margin: 2% 0 0 60%;
    }
    .form{
      height: 300px;
    }
    .inner{
      width: 80%;
      margin-left:10%;
    }
    .el-button{
      margin: 6% 10% 0 10%;
      width: 80%;
    }
    .confirm{
      height: 40px;
      float: left;
      margin-left: 25px;
    }
    .super{
      margin: 0 0 2% 80%;
    }
</style>