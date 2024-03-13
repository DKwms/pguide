<template>
    <div  v-loading="isPageLoading"
          element-loading-text="拼命加载中"
          element-loading-spinner="el-icon-loading"
          element-loading-background="rgba(0, 0, 0, 0.8)"
          v-loading.fullscreen="true">
        <main>
            <NavTop class="navTop" >

            </NavTop>
            <p>
                这是分类 {{ detailTag }} 详情页
            </p>
            <el-button @click="backToIndex()">
                返回按钮
            </el-button>

            <div class="mainUl">
                <template v-for="info in infoCardItems">
                    <div @click="intoDetails(info.infoCardId)" style="width: 100%;">
                        <transition name="el-zoom-in-bottom" >
                            <InfoCard style="width: 100%;height: 120px;margin: 10px 0;" class="transition-box" v-show="ifShowInfoCard" ref="infos" ></InfoCard>
                        </transition>
                    </div>

                </template>
            </div>


            <!--      page Healper-->
            <el-pagination
                style="border: 1px solid aqua"
                background
                layout="prev, pager, next"
                :total="totalNum"
                @current-change="currentPageChange"
            >
            </el-pagination>
        </main>
    </div>
</template>

<script>
import NavTop from "@/views/frame/NavTop.vue";
import {getSubjectTree} from "@/api/SearchBoxApi";
import InfoCard from "@/components/card/InfoCard.vue";

export default {
    name: "DetailPage",
    components: {InfoCard, NavTop},
    data(){
        return {
            detailTag:"",
            isPageLoading:true,
            totalNum: 100,
            infoCardItems:[
                {
                    infoCardId:1,
                    InfoCardSchool:"cqmu"
                },
                {
                    infoCardId:2,
                    InfoCardSchool:"cqmu"
                },{
                    infoCardId:3,
                    InfoCardSchool:"cqmu"
                },{
                    infoCardId:4,
                    InfoCardSchool:"cqmu"
                },{
                    infoCardId:5,
                    InfoCardSchool:"cqmu"
                },{
                    infoCardId:5,
                    InfoCardSchool:"cqmu"
                },{
                    infoCardId:5,
                    InfoCardSchool:"cqmu"
                },{
                    infoCardId:5,
                    InfoCardSchool:"cqmu"
                },{
                    infoCardId:5,
                    InfoCardSchool:"cqmu"
                },{
                    infoCardId:5,
                    InfoCardSchool:"cqmu"
                }
            ]
        }
    },
    methods:{
        backToIndex(){
            location.href = process.env.VUE_APP_SELF_PATH
        },
        async fetchData() {
            // 获取当前页面的URL
            var prehref = window.location.href;

            // 在开发模式下去除 '#/'
            var href = prehref.split('#/');

            // 创建 URL 对象
            var url = new URL(href);

            // 获取 'detailTags' 参数
            this.detailTag = url.searchParams.get('detailTags');

            // 后续代码可以放在这里
        }
    },
    mounted() {
        // 基础页面数据加载
        this.fetchData();

        getSubjectTree().then(r=>{
            this.allSearchBoxItems = r.data
            this.searchBoxItems = [];
            // console.log(r.data)
            for (const first of  r.data[0]) {
                // 放置顶层信息
                this.searchBoxItems.push(first)
            }

            this.isPageLoading = false;
        }).catch(e=>{
            this.$message.error("searchBox接口数据请求失败")
            console.log(e)
        })
    }
}
</script>

<style scoped>

main{
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
}

.mainUl li {
    border: 1px solid #f68f8f;
    width: 100%;
    margin: 10px 0;
}

.mainUl {
    width: 80vw;
    list-style-type: none;
    display: flex;
    justify-content: left;
    flex-direction: column;
    align-items: center;
    min-width: 350px;
}


</style>
