<template>
    <div>
        <div style="width: 80vw;;
            display: flex;align-items: center;flex-direction: column;">
            <el-steps :active="active" finish-status="success" style="min-width:340px;width: 100%;margin-bottom: 10px;" align-center>
                <el-step title="步骤 1" description="项目基础信息，提交系统审核"></el-step>
                <el-step title="步骤 2" description="项目详细信息，提交平台审核"></el-step>
                <el-step title="步骤 3" description="项目补充信息，审核流程完毕"></el-step>
            </el-steps>

        <!--precheck-->
        <el-card style="width: 80%;margin: 100px 0" v-show="this.checkLevel==='preCheck'">
            <div slot="header" class="clearfix">
                <h2>项目申请信息</h2>
            </div>
            <div >
                <el-form label-position="top" label-width="80px" :model="projectInfo">
                    <el-form-item label="项目名">
                        <el-input v-model="projectInfo.name"></el-input>
                    </el-form-item>


                    <!--选择提示词-->
                    <el-form-item label="项目类型">
                        <el-select v-model="projectInfo.typeLevel" placeholder="项目类型" style="margin-right: 20px">
                            <el-option label="自由项目" value="free"></el-option>
                            <el-option label="非自由项目" value="unfree"></el-option>
                        </el-select>
                        <el-select v-model="projectInfo.type" placeholder="项目方向">
                            <el-option label="创新创业" value="cs"></el-option>
                            <!--TODO 后端渲染,根据自由项目和非自由项目来决定项目类型-->
                        </el-select>
                    </el-form-item>


                    <!--TODO 输入提示词-->
                    <el-form-item label="学校">
                        <el-input v-model="projectInfo.school"></el-input>
                    </el-form-item>

                    <!--TODO 输入提示词-->
                    <el-form-item label="学院">
                        <el-input v-model="projectInfo.academy"></el-input>
                    </el-form-item>
                </el-form>

                <div style="width: 100%;display: flex;justify-content: center;">
                    <el-button @click="checkToCheck01()" type="primary">提交审核</el-button>
                </div>
            </div>

        </el-card>
            <!--check01-->
            <el-card style="width: 80%;margin: 100px 0" v-show="this.checkLevel==='check01'">
                <div slot="header" class="clearfix">
                    <h2>项目审核信息</h2>
                </div>
                <div>
                    <el-form label-position="top" label-width="80px" :model="projectInfo">
                        <!--TODO 树状选择+模糊搜索-->
                        <el-form-item label="项目学科">
                            <el-input v-model="projectInfo.subject"></el-input>
                        </el-form-item>


                        <!--TODO 字数限制-->
                        <el-form-item label="项目描述">
                            <el-input type="textarea" v-model="projectInfo.detail"></el-input>
                        </el-form-item>

                        <!--选择提示词-->
                        <el-form-item label="项目开放状态">
                            <el-select v-model="projectInfo.openLevel" placeholder="...点击选择">
                                <el-option label="公开" value="public"></el-option>
                                <el-option label="校级" value="school"></el-option>
                                <el-option label="院级" value="academy"></el-option>
                                <el-option label="私有" value="private"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-form>
                    <div style="width: 100%;display: flex;justify-content: center;">
                        <el-button @click="checkToPreCheck()" type="primary">上一步</el-button>
                        <el-button @click="submitCheck01()" type="primary">提交审核</el-button>
                    </div>
                </div>
            </el-card>


            <!--check02-->
            <el-card style="width: 80%;margin: 100px 0" v-show="this.checkLevel==='check02'">
                <div slot="header" class="clearfix">
                    <h2>项目审核信息</h2>
                </div>
                <div>
                  信息提交完成，正在等待审核中...
                </div>
            </el-card>
        </div>


    </div>
</template>

<script>
import {getUserInfo} from "@/api/project/projectCreatedStudent";
import {stdout} from "process";

export default {
    name: "CreatedGroup",
    data() {
        return {
            active: 0,
            projectInfo:{
                name:"",
                type:"",
                typeLevel:"",
                school:"",
                academy:"",
                // 100 - 300字
                detail:"",
                subject:"",
                openLevel:""
            },
            checkLevel:"preCheck"
        }
    },
    methods: {
        next() {
            if (this.active++ > 2) this.active = 0;
        },
        checkToPreCheck(){
            this.active = 0;
          this.checkLevel = "preCheck";
        },
        checkToCheck01(){
            // TODO 检查项目名是否重复
            this.active = 1;
            this.checkLevel = "check01";
        },
        submitCheck01(){
            //TODO 提交项目审核信息

            getUserInfo(this.projectInfo).then(res=>{
                this.active = 2;
                this.checkLevel="check02";
                this.$message.success("提交成功，等待平台审核")
            }).catch(e=>{
                this.$message.error("提交异常")
            })

        }
    },
    mounted() {
        // 发起请求
        //TODO 检查当前用户是否可以创建项目

    }
}
</script>

<style scoped>
div {
    /*border: 1px dashed plum;*/
}

</style>
