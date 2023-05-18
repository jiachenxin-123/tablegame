<template>
  <el-drawer
  title="历史订单"
  :visible.sync="tableshow"
  direction="rtl"
  :before-close='truestate'
  size="46%">
  
   <el-table :data="log">
      <el-table-column property="gamename" label="游戏名" width="70"></el-table-column>
      <el-table-column property="roomname" label="房间名" width="70"></el-table-column>
      <el-table-column property="duration" label="时长"></el-table-column>
      <el-table-column property="start" label="开始时间" width="250"></el-table-column>
      <el-table-column property="money" label="价格" width="70"></el-table-column>
    </el-table>
 </el-drawer>
</template>

<script>
export default {
    props:{
        table:{
            type:Boolean,
            default(){}
        }
    },
    data(){
        return{
            tableshow:this.table,
            log:[]
        }
    },
    methods:{
        getLog(){
            this.axios.get('/userHome/log/'+sessionStorage.getItem('account')).then((res)=>{
                if(res.data.flag){
                    this.log = res.data.data;
                }else{
                    this.$message.error(res.data.data);
                }
            })
        },
        truestate(){
            this.$emit('turntable',false);
        }
    },
    mounted(){
        this.getLog();
    },
}
</script>

<style>

</style>