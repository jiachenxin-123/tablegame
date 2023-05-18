<template>
<div>
    <el-table
    :data="rooms"
    style="width: 100%"
    max-height="530">
    <el-table-column
      fixed
      prop="id"
      label="房间ID"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="房间名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="min"
      label="最小参加人数"
      width="180">
    </el-table-column>
    <el-table-column
      prop="max"
      label="最大参加人数"
      width="180">
    </el-table-column>
    <el-table-column
      prop="state"
      label="状态"
      width="180">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
        <el-button
          @click.native.prevent="updateRow(scope.$index, rooms)"
          type="text"
          size="small">
          修改
        </el-button>
         <el-button
          @click.native.prevent="deleteRow(scope.$index, rooms)"
          type="text"
          size="small">
          删除
        </el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-dialog title="修改房间信息" :visible.sync="dialogFormVisible">
    <el-form :model="room">
      <el-form-item label="房间名">
        <el-input v-model="room.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="最小参加人数">
        <el-input v-model="room.min" autocomplete="off"></el-input>
      </el-form-item>
       <el-form-item label="最大参加人数">
        <el-input v-model="room.max" autocomplete="off"></el-input>
      </el-form-item>
       <el-form-item label="状态">
          <el-radio v-model="room.state" label="0">可选</el-radio>
          <el-radio v-model="room.state" label="1">不可选</el-radio>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="updateRoom()">确 定</el-button>
    </div>
  </el-dialog>
  </div>
</template>

<script>
export default {
    data(){
        this.$nextTick(()=>{
            this.getRoom();
        })
        return{
          dialogFormVisible:false,
            rooms:[],
            room:{
              id:'',
              name:'',
              min:'',
              max:'',
              state:''
            }
        }
    },
    methods:{
        getRoom(){
            this.axios.get('/manageHome/room').then((res)=>{
                if(res.data.flag){
                    this.rooms = res.data.data;
                }
            })
        },
        updateRow(index,rooms){
          this.room = rooms[index];
          this.dialogFormVisible = true;
        },
        updateRoom(){
          this.axios.put('/manageHome/room',this.room).then((res)=>{
             if(res.data.flag){
              this.$message.success(res.data.data);
            }
            else{
              this.$message.error(res.data.data);
            }
          })
          this.getRoom();
          this.dialogFormVisible = false;
        },
        deleteRow(index, rooms){
          this.axios.delete('/manageHome/room/'+rooms[index].id).then((res)=>{
            if(res.data.flag){
              this.$message.success(res.data.data);
            }
            else{
              this.$message.error(res.data.data);
            }
          })
          this.getRoom();
        }
    }
}
</script>

<style>

</style>