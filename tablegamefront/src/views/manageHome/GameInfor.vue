<template>
<div>
      <el-table
    :data="games"
    style="width: 100%"
    max-height="530">
    <el-table-column
      fixed
      prop="id"
      label="游戏ID"
      width="80">
    </el-table-column>
    <el-table-column
      prop="name"
      label="游戏名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="time"
      label="时长"
      width="80">
    </el-table-column>
    <el-table-column
      prop="price"
      label="价格"
      width="80">
    </el-table-column>
    <el-table-column
      prop="min"
      label="最小容纳人数"
      width="120">
    </el-table-column>
    <el-table-column
      prop="max"
      label="最大容纳人数"
      width="120">
    </el-table-column>
    <el-table-column
      prop="text"
      label="简介"
      width="450">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button
          @click.native.prevent="updateRow(scope.$index, games)"
          type="text"
          size="small">
          修改
        </el-button>
         <el-button
          @click.native.prevent="deleteRow(scope.$index, games)"
          type="text"
          size="small">
          删除
        </el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-dialog title="修改游戏信息" :visible.sync="dialogFormVisible">
    <el-form :model="game">
      <el-form-item label="游戏名">
        <el-input v-model="game.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="时长">
        <el-input v-model="game.time" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="价格">
        <el-input v-model="game.price" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="最小参加人数">
        <el-input v-model="game.min" autocomplete="off"></el-input>
      </el-form-item>
       <el-form-item label="最大参加人数">
        <el-input v-model="game.max" autocomplete="off"></el-input>
      </el-form-item>
       <el-form-item label="简介">
        <el-input v-model="game.text" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="updateGame()">确 定</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
export default {
    data(){
        this.$nextTick(()=>{
            this.getGame();
        })
        return{
            dialogFormVisible:false,
            games:[],
            game:{
              id:'',
              name:'',
              time:'',
              price:'',
              min:'',
              max:'',
              text:''
            }
        }
    },
    methods:{
        getGame(){
            this.axios.get('/manageHome/game').then((res)=>{
                if(res.data.flag){
                    this.games = res.data.data;
                }
            })
        },
        updateRow(index,games){
          this.game = games[index];
          this.dialogFormVisible = true;
        },
        updateGame(){
          this.axios.put('/manageHome/game',this.game).then((res)=>{
             if(res.data.flag){
              this.$message.success(res.data.data);
            }
            else{
              this.$message.error(res.data.data);
            }
          })
          this.getGame();
          this.dialogFormVisible = false;
        },
        deleteRow(index, games){
          this.axios.delete('/manageHome/game/'+games[index].id).then((res)=>{
            if(res.data.flag){
              this.$message.success(res.data.data);
            }
            else{
              this.$message.error(res.data.data);
            }
          })
          this.getGame();
        }
    }
}
</script>

<style>

</style>