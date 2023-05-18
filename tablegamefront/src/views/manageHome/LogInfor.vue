<template>
    <el-table
    :data="logs"
    style="width: 100%"
    max-height="530">
    <el-table-column
      fixed
      prop="id"
      label="ID"
      width="80">
    </el-table-column>
    <el-table-column
      prop="account"
      label="账号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="gamename"
      label="游戏名"
      width="150">
    </el-table-column>
    <el-table-column
      prop="roomname"
      label="房间名"
      width="130">
    </el-table-column>
    <el-table-column
      prop="duration"
      label="时长"
      width="80">
    </el-table-column>
    <el-table-column
      prop="start"
      label="开始时间"
      width="230">
    </el-table-column>
    <el-table-column
      prop="money"
      label="价格"
      width="70">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
         <el-button
          @click.native.prevent="deleteRow(scope.$index, logs)"
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
            this.getlog();
        })
        return{
            logs:[]
        }
    },
    methods:{
        getlog(){
            this.axios.get('/manageHome/log').then((res)=>{
                if(res.data.flag){
                    this.logs = res.data.data;
                }
            })
        },
        deleteRow(index, logs){
          this.axios.delete('/manageHome/log/'+logs[index].id).then((res)=>{
            if(res.data.flag){
              this.$message.success(res.data.data);
            }
            else{
              this.$message.error(res.data.data);
            }
          })
          this.getlog();
        }
    }
}
</script>

<style>

</style>