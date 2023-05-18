<template>
    <el-table
    :data="comments"
    style="width: 100%"
    max-height="530">
    <el-table-column
      fixed
      prop="id"
      label="ID"
      width="150">
    </el-table-column>
    <el-table-column
      prop="useraccount"
      label="用户账号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="username"
      label="用户名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="comment"
      label="评价"
      width="380">
    </el-table-column>
    <el-table-column
      prop="star"
      label="评级"
      width="70">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
         <el-button
          @click.native.prevent="deleteRow(scope.$index, comments)"
          type="text"
          size="small">
          删除
        </el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
    data(){
        this.$nextTick(()=>{
            this.getComment();
        })
        return{
            comments:[]
        }
    },
    methods:{
        getComment(){
            this.axios.get('/manageHome/comment').then((res)=>{
                if(res.data.flag){
                    this.comments = res.data.data;
                }
            })
        },
        deleteRow(index, comments){
          this.axios.delete('/manageHome/comment/'+comments[index].id).then((res)=>{
            if(res.data.flag){
              this.$message.success(res.data.data);
            }
            else{
              this.$message.error(res.data.data);
            }
          })
          this.getComment();
        }
    }
}
</script>

<style>

</style>