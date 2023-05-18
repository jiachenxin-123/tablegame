<template>
    <div id="box">
    <h1>注&nbsp;&nbsp;&nbsp;&nbsp;册</h1>
    <el-form :model="user" status-icon :rules="rules" ref="user" label-width="100px" class="demo-ruleForm">
        <el-form-item label="账号" prop="account">
            <el-input v-model="user.account" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="名称" prop="name">
            <el-input v-model="user.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="user.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPass">
            <el-input type="password" v-model="user.checkPass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
            <el-radio v-model="user.sex" label="男">男</el-radio>
            <el-radio v-model="user.sex" label="女">女</el-radio>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
            <el-input v-model="user.phone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm()">提交</el-button>
            <el-button @click="resetForm('user')">重置</el-button>
        </el-form-item>
    </el-form>
    <a href="/#/login" class="super">去登录</a>
  </div>
</template>

<script>
export default {
data() {
      var validateAccount = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入账号'));
        } else {
          if (value.length !== 8) {
            callback(new Error('请输入8位账号'))
          }
          callback();
        }
      };
      var validateName = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入名称'));
        } else {
          callback();
        }
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.user.checkPass !== '') {
            this.$refs.user.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.user.password) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      var validatePhone = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入电话号码'));
        } else {
          if (value.length!==11) {
            callback(new Error('请输11位电话号码')); 
          }else{
            callback();
          }
        }
      };
       return {
        user: {
            account:'',
            name:'',
            password: '',
            checkPass:'',
            sex:'',
            phone:''
        },
        rules: {
          account: [
            { validator: validateAccount, trigger: 'blur' }
          ],
          name: [
            { validator: validateName, trigger: 'blur' }
          ],
          password: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
          phone: [
            { validator: validatePhone, trigger: 'blur' }
          ],
        }
      };
    },
    methods:{
        submitForm(){
            this.axios.post('/register',this.user).then((res)=>{
                if(!res.data.flag){
                    this.$message.error(res.data.data);
                }
                else{
                    this.$message.success(res.data.data);
                    window.sessionStorage.setItem('account',this.user.account);
                }
            })
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
}
</script>
<style scoped>
h1{
    text-align: center;
}
#box{
    border: 1px solid black;
    width: 30%;
    height: 550px;
    margin: 2% 0 0 60%;
}
.demo-ruleForm{
    margin-right: 10%;
    margin-top: 6%;
}
.el-button{
    width: 90px;
}
.super{
    margin: 0 0 2% 80%;
}
</style>