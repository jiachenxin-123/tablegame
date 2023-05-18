<template>
    <el-table
    :data="users"
    style="width: 100%"
    max-height="530">
    <el-table-column
      fixed
      prop="account"
      label="账号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="password"
      label="密码"
      width="180">
    </el-table-column>
    <el-table-column
      prop="sex"
      label="性别"
      width="180">
    </el-table-column>
    <el-table-column
      prop="phone"
      label="电话"
      width="220">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button
          @click.native.prevent="deleteRow(scope.$index, users)"
          type="text"
          size="small">
          移除
        </el-button>
      </template>
    </el-table-column>
  </el-table>

</template>

<script>
export default {
    data(){
        this.$nextTick(()=>{
            this.getUser();
        })
        return{
            users:[]
        }
    },
    methods:{
        getUser(){
            this.axios.get('/manageHome/user').then((res)=>{
                if(res.data.flag){
                    this.users = res.data.data;
                }
            })
        },
        deleteRow(index, user){
          this.axios.delete('/manageHome/user/'+user[index].account).then((res)=>{
            if(res.data.flag){
              this.$message.success(res.data.data);
            }
            else{
              this.$message.error(res.data.data);
            }
          })
          this.getUser();
        }
    }
}
</script>

<style>

</style>