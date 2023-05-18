<template>
  <el-dialog title="修改信息" :visible.sync="dialogFormVisible" :show-close='false'>
    <el-form :model="user">
        <el-form-item label="名称" :label-width="formLabelWidth">
            <el-input v-model="user.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
            <el-input v-model="user.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="电话" :label-width="formLabelWidth">
            <el-input v-model="user.phone" autocomplete="off"></el-input>
        </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
        <el-button @click="change()">取 消</el-button>
        <el-button type="primary" @click="changeUser()">确 定</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
    props:{
          dialog:{
            type:Boolean,
            default(){}
          },
          user:{
            type:Object,
            default(){
                return{
                    account:'',
                    name:'',
                    password:'',
                    sex:'',
                    phone:''
                    }
            }
          }  
        },
    data(){   
        return{
            formLabelWidth: '100px',
            dialogFormVisible: this.dialog,
        }
    },
    methods:{
        change(){
            this.dialogFormVisible = false;
            this.$emit('turnVisible',this.dialogFormVisible);
        },
        changeUser(){
            this.axios.put("/userHome",this.user).then((res)=>{
                if(res.data.flag){
                    this.$message.success(res.data.data);
                    this.change();
                }
                else{
                    this.$message.error(res.data.data);
                }
            })
        }
    }
    
}
</script>

<style scoped>
</style>