<template>
<div>
  <el-divider content-position="left">填写留言</el-divider>
  <table class="one"  :v-model="comment">
    <tr>
        <td class="infor">名称：{{comment.username}}</td>
        <td class="infor">账号：{{comment.useraccount}}</td>
        <td class="assess">综合评分</td>
        <td>
            <el-rate
                v-model="comment.star"
                :colors="colors">
            </el-rate>
        </td>
        <td rowspan="2" class="button">
            <button @click="addComment()">提交</button>
            <button @click="resetComment()">重置</button>
        </td>
    </tr>
    <tr>
        <td colspan="4">
            <el-input
            type="textarea"
            placeholder="请输入内容"
            v-model="comment.comment"
            maxlength="50"
            :autosize='{minRows:5}'
            show-word-limit
            style="height: 120px"
            >
            </el-input>
        </td>
    </tr>
  </table>
  <el-divider content-position="left">用户评论</el-divider>
  <table class="two" v-for="comment in commentlist" :key="comment.id">
    <tr>
        <td class="floor b">{{comment.id}}楼</td>
        <td class="forinfor b">名称:{{comment.username}}</td>
        <td class="forinfor b">账号:{{comment.useraccount}}</td>
        <td class="forassess b">综合评分</td>
        <td class="b">
            <el-rate
                disabled
                v-model="comment.star"
                :colors="colors">
            </el-rate>
        </td>
    </tr>
    <tr>
        <td colspan="5" style="height:100px" class="b">{{comment.comment}}</td>
    </tr>
  </table>
</div>
</template>

<script>
export default {
    data() {
        this.$nextTick(()=>{
            this.getname();
            this.getComment();
        })
        return {
            comment:{
                useraccount:'',
                username:'',
                comment:'',
                star:0
            },
            commentlist:[],
            colors: ['#99A9BF', '#F7BA2A', '#FF9900']  // 等同于 { 2: '#99A9BF', 4: { value: '#F7BA2A', excluded: true }, 5: '#FF9900' }
        }
    },
    methods:{
        getname(){
            this.comment.useraccount = sessionStorage.getItem('account');
            this.axios.get('/userHome/'+sessionStorage.getItem('account')).then((res)=>{
                if(res.data.flag){
                    this.comment.username = res.data.data.name;
                }
            })
        },
        getComment(){
            this.axios.get('/userHome/comment').then((res)=>{
                if(res.data.flag){
                    this.commentlist = res.data.data;
                }
                else{
                    this.$message.error('查询失败');
                }
            })
        },
        addComment(){
            this.axios.post('/userHome/comment',this.comment).then((res)=>{
                if(res.data.flag){
                    this.$message.success(res.data.data);
                }else{
                    this.$message.error(res.data.data);
                }
            })
        },
        resetComment(){
            this.comment.comment = '';
            this.comment.star = 0;
        }
    }
}
</script>

<style scoped>
.one{
    width: 100%;
}
.two{
    border: 1px solid black;
    width: 55%;
    margin: 5px 20% 0 20%;
}
.b{
    border: 1px solid black;
}
.floor{
    width: 10%;
}
.forinfor{
    width: 25%;
}
.assess{
    width: 80px;
    text-align: center;
}
.infor{
    width: 20%;
    height: 30px;
}
.text{
    height: 100px;
}
.button{
    width: 20%;
}
.forassess{
    width: 13%;
    text-align: center;
}
button{
    width: 60px;
    height: 30px;
    margin-left: 15%;
}
</style>