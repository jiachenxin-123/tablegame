<template>
  <el-drawer
  title="当前订单"
  :before-close="handleClose"
  :visible.sync="dialog"
  direction="ltr"
  custom-class="demo-drawer"
  ref="drawer"
  >
    <div class="demo-drawer__content">
        <el-form :model="log">
        <el-form-item label="账号" :label-width="formLabelWidth">
            {{log.account}}
        </el-form-item>
        <el-form-item label="游戏名" :label-width="formLabelWidth">
            {{log.gamename}}
        </el-form-item>
        <el-form-item label="房间名" :label-width="formLabelWidth">
            {{log.roomname}}
        </el-form-item>
        <el-form-item label="时长" :label-width="formLabelWidth">
            {{log.duration}}
        </el-form-item>
        <el-form-item label="开始时间" :label-width="formLabelWidth">
            {{log.start}}
        </el-form-item>
        <el-form-item label="金额" :label-width="formLabelWidth">
            {{log.money}}
        </el-form-item>
        </el-form>
        <div class="demo-drawer__footer">
        <el-button @click="handleClose">取 消</el-button>
        <el-button type="primary" @click='addLog()'>确定</el-button>
        </div>
    </div>
    </el-drawer>
</template>

<script>
export default {
    props:{
        dialogshow:{
            type:Boolean,
            default(){}
        }
    },
    data(){
        return{
            formLabelWidth: '80px',
            dialog:this.dialogshow,
            log:{
                account:'',
                gamename:'',
                roomname:'',
                duration:'',
                start:'',
                money:''
            },
            nowtime:''
        }   
    },
    mounted(){
        this.getInfor();
    },
    methods:{
        handleClose(){
            this.dialog = false;
            this.$emit('turndialog',false);
        },
        addLog(){
            this.axios.post('/userHome/log',this.log).then((res)=>{
                if(res.data.flag){
                    this.$message.success(res.data.data);
                }else{
                    this.$message.error(res.data.data);
                }
            })
            this.handleClose();
        },
        getInfor(){
            this.log.account = sessionStorage.getItem('account');
            this.log.gamename = sessionStorage.getItem('gamename');
            this.log.roomname = sessionStorage.getItem('roomname');
            this.log.duration = sessionStorage.getItem('duration');
            this.getNowDate();
            this.log.start = this.nowtime;
            this.log.money = sessionStorage.getItem('money');
        },
        getNowDate() {
           var date = new Date();
           var sign2 = ":";
           var year = date.getFullYear() // 年
           var month = date.getMonth() + 1; // 月
           var day = date.getDate(); // 日
           var hour = date.getHours(); // 时
           var minutes = date.getMinutes(); // 分
           var seconds = date.getSeconds() //秒
           var weekArr = ['星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期天'];
           var week = weekArr[date.getDay()];
            // 给一位数的数据前面加 “0”
           if (month >= 1 && month <= 9) {
                month = "0" + month;
           }
            if (day >= 0 && day <= 9) {
                day = "0" + day;
            }
            if (hour >= 0 && hour <= 9) {
             hour = "0" + hour;
             }
           if (minutes >= 0 && minutes <= 9) {
              minutes = "0" + minutes;
            }
           if (seconds >= 0 && seconds <= 9) {
              seconds = "0" + seconds;
          }
        this.nowtime =  year + "-" + month + "-" + day + " " + hour + sign2 + minutes + sign2 + seconds;
        }
    }
}
</script>

<style>

</style>