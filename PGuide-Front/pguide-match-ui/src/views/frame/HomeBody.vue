<template>
  <!--<div  v-loading="isPageLoading" element-loading-text="拼命加载中"-->
  <!--      element-loading-spinner="el-icon-loading"-->
  <!--      element-loading-background="rgba(0, 0, 0, 0.8)"-->
  <!--      v-loading.fullscreen="true">-->
    <div>
        <div class="bigBox" id="box">
            <!--搜索框-->
            <div class="testBox"
                 style="min-width: 350px;position: sticky;top: 0px;z-index: 9999;background-color: #72EFDD;
                  margin-top: 10px;
                  display: flex;justify-content: center;align-items: center;"
                 v-show="!ifShowSearchDetailData"
            >
                <el-input suffix-icon="search"></el-input>
                <el-button type="success" icon="el-icon-search" style="background-color: #56CFE1">搜索</el-button>
            </div>

            <!--导航栏-->
            <div class="nav"
            >
                <!--TODO 点击定位-->
                <ul style="list-style: none;text-align: center" class="navul">
                    <li>
                        导航栏
                    </li>
                    <li>
                        <a>热门项目</a>
                    </li>
                    <li>
                        <a>需求市场</a>
                    </li>
                    <li>
                        <a></a>
                    </li>
                    <li>
                        <a></a>
                    </li>
                </ul>
            </div>

            <!--右侧导航栏-->
            <div class="rightNav"
            >
                收藏
            </div>

            <!--      search box new（树状）-->
            <div class="treeBox"
                 @mouseleave="leaveSearchBoxParent()">
                <!--                    left-->
                <div style="width: 10%;border: 1px solid #ffe17f;    min-width: 35px;">
                    <ul style="list-style: none;" class="searchBoxLeft">
                        <!--                          一级标题-->
                        <!--                          TODO 动态加载数据
                                                      这里大标题的数量需要提前确定好，方便基础数据展示图的框架勾勒
                        -->
                        <template v-for="item in searchBoxItems">
                            <li @mouseenter="onSearchBoxParent(item.subjectId,item.subjectName,$event.target)"
                                id="treeTop" ref="treeTop">
                                <p>
                                    {{ item.subjectName }}
                                </p>
                                <p>></p>
                            </li>
                        </template>
                    </ul>
                </div>

                <!--                    right-->
                <!--                    searchBox数据展示页-->
                <div style="width: 90%;border: 1px solid #ffe17f;min-width: 315px" v-show="!ifShowSearchDetailData">
                    <!--                        基础数据轮播图-->
                    <div class="block" style="width: 100%;text-align: center;">
                        <el-carousel height="546px">
                            <el-carousel-item v-for="item in 4" :key="item">
                                <h3 class="small" style="margin-top: 200px">{{ item }}</h3>
                            </el-carousel-item>
                        </el-carousel>
                    </div>
                </div>
                <!--                    searchBox数据详情页-->
                <div style="width: 90%;border: 1px solid #ffe17f" v-show="ifShowSearchDetailData">
                    <!--                        top-->
                    <div style="width: 100%;height: 20%;border: 1px solid plum;display: flex;justify-content: center;align-items: center;">
                        <div style="width: 90%;height: 80%;border: 1px solid #a4f6fd;display: flex;justify-content: left;">
                            <!--                                二级标题-->
                            <!--                                <div style="width: 10%;height: 100%;border: 1px solid #1ab394" class="searchBoxSubTitle"></div>-->
                            <template v-for="subItem in searchBoxHover.treeDetailInfo">
                                <div class="searchBoxSubTitle" @mouseenter="onSubItem(subItem.details,$event.target)"
                                     @mouseleave="leaveSubItem()" ref="subItem">{{ subItem.subName }}
                                </div>
                            </template>
                        </div>
                    </div>
                    <!--                        body-->
                    <div style="width: 100%;height: 80%;border: 1px solid plum;display: flex;justify-content: left;padding: 10px;flex-wrap: wrap">
                        <!--                            三级标题-->
                        <!--                            TODO 动态数据加载-->
                        <template v-for="item in treeDetailHover">
                            <!--                                TODO 点击跳转详情页
                            -->
                            <div class="subjectButton" @mousedown="toDetailPages(item.detailName)"
                                 style="height: 15%;border: 1px solid #AF40FF;margin:8px;font-size: 14px">
                                {{ item.detailName }}
                            </div>
                        </template>
                    </div>
                </div>
            </div>

            <!--热门项目-->
            <div class="mainUl" style="min-width: 600px;max-width: 1200px;">
                <div style="width: 100%;height: 100px;display: flex;justify-content: center;">
                    <h1>热门项目</h1>
                </div>
                <template v-for="info in infoCardItems">
                    <div @click="intoDetails(info.infoCardId)">
                        <transition name="el-zoom-in-bottom">
                            <InfoCard style="width: 180px;height: 250px;margin: 20px;" class="transition-box"
                                      v-show="ifShowInfoCard" ref="infos"></InfoCard>
                        </transition>
                    </div>
                </template>
            </div>

            <!--需求市场-->
            <div class="mainUl" style="min-width: 600px;max-width: 1200px">
                <div style="width: 100%;height: 100px;display: flex;justify-content: center;">
                    <h1>需求市场</h1>
                </div>
                <template v-for="info in infoCardItems">
                    <div @click="intoDetails(info.infoCardId)">
                        <transition name="el-zoom-in-bottom">
                            <InfoCard style="width: 180px;height: 250px;margin: 20px;" class="transition-box"
                                      v-show="ifShowInfoCard" ref="infos"></InfoCard>
                        </transition>
                    </div>
                </template>
            </div>


            <!--      page Healper-->
            <!--<el-pagination-->
            <!--        style="border: 1px solid aqua"-->
            <!--        background-->
            <!--        layout="prev, pager, next"-->
            <!--        :total="totalNum"-->
            <!--        @current-change="currentPageChange"-->
            <!--&gt;-->
            <!--</el-pagination>-->

        </div>
        

        <!--      详情信息-->

        <div v-show="showDetail"
             style="width: 100vw;height: 100vh;position: absolute;top:0;border: none;padding: 0;margin: 0;overflow-x: hidden"
             id="detail">

            <el-button type="danger" style="position: absolute;left: 0;top: 0;" @click="goBack()">< 返回</el-button>
            <div class="detailBox">
                <div class="detailBoxHeader"
                     style="width: 100%;height: 40px;background-color: #c8e7ff">
                    header</div>
                <!--
                                    TODO 支持自定义先后顺序
                -->
                <div style="width: 100%;height: 200px;text-align: center">
                    小组信息
                </div>
                <hr>
                <div style="width: 100%;height: 300px;text-align: center;">
                    招募信息
                    <div class="shadow-inset-lr hr">
                        <ul style="padding-top: 20px;padding-left: 80px;display: flex" class="detailTaskCardBox">
                            <template v-for="taskCard in taskCards">
                                <li @click="clickTaskCard(taskCard.taskId)" class="hrCard">
                                    <TaskCard style="position:absolute;height: 210px;display: inline-block;"
                                              :auth="taskCard.userName" :card-name="taskCard.taskName"
                                              :detail="taskCard.taskDetail" :tags="taskCard.tags"
                                              :coin="taskCard.reward"></TaskCard>
                                </li>
                            </template>
                        </ul>
                    </div>

                </div>
                <hr>

                <div style="width: 100%;height: 300px;text-align: center;">
                    项目介绍
                </div>
                <div class="detailBoxBottom"
                     style="width: 100%;height: 30px;background-color: #c8e7ff">
                    bottom</div>

            </div>
        </div>
    </div>
</template>

<script>
import InfoCard from "@/components/card/InfoCard.vue";
import SearchBoxItem from "@/components/SearchBoxItem.vue";
import PGuideDarkCard from "@/components/buttons/PGuideDarkButton.vue";
import BaseFlipTest from "@/components/flips/BaseFlipTest.vue";
import TaskCard from "@/components/card/TaskCard.vue"
import {getSubjectTree} from "@/api/SearchBoxApi";
// import VanillaTilt from "vanilla-tilt";
export default {
    name: "HomeBody",
    components: {TaskCard, BaseFlipTest, PGuideDarkCard, SearchBoxItem, InfoCard},
    data() {
        return {
            totalNum: 100,
            isPageLoading: true,
            ifShowInfoCard: true,
            ifShowSearchDetailData: false,
            showDetail: false,
            // 分页信息
            pageInfo: {},
            // 招聘卡信息
            taskCards: [
                {
                    taskName: "b",
                    taskDetail: "c",
                    reward: "100"
                },
                {
                    taskName: "b",
                    taskDetail: "c",
                    reward: "100"
                },
                {
                    taskName: "b",
                    taskDetail: "c",
                    reward: "100"
                },
                {
                    taskName: "b",
                    taskDetail: "c",
                    reward: "100"
                },
                {
                    taskName: "b",
                    taskDetail: "c",
                    reward: "100"
                },
                {
                    taskName: "b",
                    taskDetail: "c",
                    reward: "100"
                },
                {
                    taskName: "b",
                    taskDetail: "c",
                    reward: "100"
                }
            ],
            // 标头数据
            // 标头信息
            searchBoxItems: [],
            // 全部学科信息
            allSearchBoxItems: {},
            // 当前选中的盒子信息
            searchBoxHover: {
                treeTopId: "",
                treeTopName: "",
                treeDetailInfo: [
                    {
                        subId: "",
                        subName: "",
                        subLevel: "",
                        details: []
                    }
                ],
            },
            treeDetailHover: [],
            infoCardItems: [
                {
                    infoCardId: 1,
                    InfoCardSchool: "cqmu"
                },
                {
                    infoCardId: 2,
                    InfoCardSchool: "cqmu"
                }, {
                    infoCardId: 3,
                    InfoCardSchool: "cqmu"
                }, {
                    infoCardId: 4,
                    InfoCardSchool: "cqmu"
                }, {
                    infoCardId: 5,
                    InfoCardSchool: "cqmu"
                }, {
                    infoCardId: 5,
                    InfoCardSchool: "cqmu"
                }, {
                    infoCardId: 5,
                    InfoCardSchool: "cqmu"
                }, {
                    infoCardId: 5,
                    InfoCardSchool: "cqmu"
                }, {
                    infoCardId: 5,
                    InfoCardSchool: "cqmu"
                }, {
                    infoCardId: 5,
                    InfoCardSchool: "cqmu"
                }
            ]
        }
    },
    methods: {
        //TODO 空缺元素暂无数据处理
        onSearchBoxParent(id, name, self) {
            // 重置顶层标题颜色
            var treeTop = this.$refs.treeTop;
            for (const treeTopElement of treeTop) {
                treeTopElement.style = "background-color:write"
            }

            self.style = "background-color:red"

            // 重置副标题颜色
            var subItems = this.$refs.subItem;
            for (const subItem of subItems) {
                subItem.style = "background-color:1ab394"
            }

            // 进行数据加载，查询头数据
            this.ifShowSearchDetailData = true;
            // 组装详情信息
            this.searchBoxHover = {
                treeTopId: id,
                treeTopName: name,
                treeDetailInfo: []
            };
            // 根据id计算出详细的信息
            var allSearchBoxItems = this.allSearchBoxItems[id];
            // 第二层id计算
            let key = true;
            for (const allSearchBoxItem of allSearchBoxItems) {
                // 第三层计算
                const subAllSearchBoxItems = this.allSearchBoxItems[allSearchBoxItem.subjectId];
                if (subAllSearchBoxItems != null) {
                    const details = []
                    for (const subAllSearchBoxItem of subAllSearchBoxItems) {
                        // console.log(subAllSearchBoxItem)
                        details.push({
                            detailId: subAllSearchBoxItem.subjectId,
                            detailName: subAllSearchBoxItem.subjectName,
                            detailLevel: subAllSearchBoxItem.subjectLevel
                        })
                    }
                    if (key) {
                        this.treeDetailHover = details;
                        key = false;
                    }
                    const tempObj = {
                        subId: allSearchBoxItem.subjectId,
                        subName: allSearchBoxItem.subjectName,
                        subLevel: allSearchBoxItem.subjectLevel,
                        // 装载subTreeTop
                        details: details
                    }
                    // 装载
                    this.searchBoxHover.treeDetailInfo.push(tempObj)
                }
            }

            if (key) {
                this.treeDetailHover = []
            }

            var firstEle = this.$refs.subItem[0];
            firstEle.style = "background-color:red"
            console.log(this.searchBoxHover)
        },
        leaveSearchBoxParent() {
            //TODO 鼠标移开恢复展示页
            this.ifShowSearchDetailData = false;
            var treeTop = this.$refs.treeTop;
            for (const treeTopElement of treeTop) {
                treeTopElement.style = "background-color:write"
            }
        },
        onSubItem(detail, self) {
            var subItems = this.$refs.subItem;
            for (const subItem of subItems) {
                subItem.style = "background-color:1ab394"
            }
            this.treeDetailHover = [];
            this.treeDetailHover = detail;
            self.style = "background-color:red"
        },
        leaveSubItem() {
            // this.treeDetailHover = [];
        },
        // 换页，
        // TODO，传输分页数据
        currentPageChange(p) {
            this.ifShowInfoCard = false;
            setTimeout(() => {
                this.ifShowInfoCard = true
            }, 700)
        },
        goBack() {
            this.ifShowSearchDetailData = false;
            this.showDetail = false;
        },
        // 详情页跳转,携带详情页名字
        toDetailPages(subjectName) {
            /**
             * 跳转流程，点击学科分类进行学科跳转，跳转到详情页进行进一步处理
             *
             */
            window.open("http://localhost:4000/#/" + "details?detailTags=" + subjectName);
        },

        /**
         *
         * @param indexId 页面id
         */
        intoDetails(indexId) {
            this.$message.success(indexId);
            this.ifShowSearchDetailData = true

            // 进入详情页
            //TODO 向后端发送请求，申请详情页数据
            this.showDetail = true
        },
    },
    mounted() {
        var bigBox = document.getElementById("box");
        //TODO 后续使用css来进行控制
        // setInterval(function () {
        //     if (window.outerWidth <= 930) {
        //         bigBox.style = "font-size: 12px"
        //     } else {
        //         bigBox.style = "font-size: 16px"
        //     }
        // }, 1000)

        // 卡片倾斜效果，适配手机端，在检测到移动端时平铺
        if (true) {
            var hrCards = document.getElementsByClassName("hrCard");
            var hrCardCount = 0;
            for (const hrCard of hrCards) {
                if (hrCardCount != 0) {
                    console.log(hrCardCount);
                    hrCard.style = "margin-left: " + (hrCardCount * 120) + "px;" + "z-index:" + (hrCardCount - hrCards);
                } else {
                }
                hrCardCount++;
            }
        } else {
            // TODO  移动端适配
        }


        //     searchBox 数据请求
        getSubjectTree().then(r => {
            this.allSearchBoxItems = r.data
            this.searchBoxItems = [];
            // console.log(r.data)
            for (const first of r.data[0]) {
                // 放置顶层信息
                this.searchBoxItems.push(first)
            }

            this.isPageLoading = false;
        }).catch(e => {
            this.$message.error("searchBox接口数据请求失败")
            console.log(e)
        })


    },
    destroyed() {
        // TODO 如果依然采用interval的方式来控制字体大小，就需要留意删除
        clearInterval()
    }
}
</script>

<style scoped>

* {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}

.bigBox {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column
}

/*searchBox*/
.searchBoxLeft {
    user-select: none;
    min-width: 35px;
}

.searchBoxSubTitle {
    width: 10%;
    height: 100%;
    border: 1px solid #1ab394;
    margin-right: 10px
}

.searchBoxSubTitle:hover {
    background-color: #1ab394;

}

.searchBoxLeft li {
    border: 1px solid rosybrown;
    padding: 10px;
    display: flex;
    min-width: 35px;
    justify-content: space-between;
}

.searchBoxLeft li:hover {
    background-color: #cccccc;
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
    justify-content: center;
    flex-direction: row;
    flex-wrap: wrap;
    align-items: center;
    min-width: 350px;
}


.testBox {
    border: 1px solid red;
    width: 80%;
    height: 60px;
    padding: 20px;

}

/*
详情背景
代实现响应式
*/
#detail {
    background-color: rgba(89, 89, 89, 0.6);
    backdrop-filter: blur(24.5px);
    -webkit-backdrop-filter: blur(24.5px);
    border: 0px solid rgba(255, 255, 255, 0.18);
    box-shadow: rgba(14, 14, 14, 0.19) 0px 6px 15px 0px;
    -webkit-box-shadow: rgba(14, 14, 14, 0.19) 0px 6px 15px 0px;
    border-radius: 0px;
    -webkit-border-radius: 0px;
    color: rgb(128, 128, 128);

    display: flex;
    justify-content: center;

}

.detailBox {
    width: 73%;
    background-color: #FFFFFF;

}

.hr {
    margin: 20px;
    overflow-y: hidden;
    overflow-x: scroll;
    padding-bottom: 10px;
    height: 245px;
    position: relative;
}

.hr::-webkit-scrollbar {
    width: 8px;
    height: 6px;
}

/*滚动条滑块*/
.hr::-webkit-scrollbar-thumb {
    /*border-radius: 3px;*/
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    background: #c7c4c4;
}

/*滚动条里面轨道*/
.hr::-webkit-scrollbar-track {
    box-shadow: 1px 1px 5px rgba(0, 0, 0, 0.2) inset;

}

/*滚动条的小边角*/
.hr::-webkit-scrollbar-corner {
    background: transparent;
}

.detailTaskCardBox {

}

.shadow-inset-lr {
    -webkit-animation: shadow-inset-lr 0.9s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
    animation: shadow-inset-lr 0.5s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
}

.hrCard {

    display: inline;
    position: absolute;
    transform: rotate(0deg);
    transition: transform 0.5s;
}

.hrCard:hover {
    transform: rotate(27deg);
    margin: 0 10px;
    transition: transform 0.5s;
}


@-webkit-keyframes shadow-inset-lr {
    0% {
        -webkit-box-shadow: inset 0 0 0 0 rgba(0, 0, 0, 0), inset 0 0 0 0 rgba(0, 0, 0, 0);
        box-shadow: inset 0 0 0 0 rgba(0, 0, 0, 0), inset 0 0 0 0 rgba(0, 0, 0, 0);
    }
    100% {
        -webkit-box-shadow: inset -6px 0 14px -6px rgba(0, 0, 0, 0.5), inset 6px 0 14px -6px rgba(0, 0, 0, 0.5);
        box-shadow: inset -6px 0 14px -6px rgba(0, 0, 0, 0.5), inset 6px 0 14px -6px rgba(0, 0, 0, 0.5);
    }
}

@keyframes shadow-inset-lr {
    0% {
        -webkit-box-shadow: inset 0 0 0 0 rgba(0, 0, 0, 0), inset 0 0 0 0 rgba(0, 0, 0, 0);
        box-shadow: inset 0 0 0 0 rgba(0, 0, 0, 0), inset 0 0 0 0 rgba(0, 0, 0, 0);
    }
    100% {
        -webkit-box-shadow: inset -6px 0 14px -6px rgba(0, 0, 0, 0.5), inset 6px 0 14px -6px rgba(0, 0, 0, 0.5);
        box-shadow: inset -6px 0 14px -6px rgba(0, 0, 0, 0.5), inset 6px 0 14px -6px rgba(0, 0, 0, 0.5);
    }
}

/*轮播图*/
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    margin: 0;
}

.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
}

.subjectButton:hover {
    background-color: #AF40FF;
}

/*TODO 字体的切换*/
@media (max-width: 600px) and (max-height: 800px){
    .bigBox{
        font-size: 10px!important;
    }
}
/*
屏幕大于1000px
*/
@media (min-width: 1200px) or (min-height: 550px) {
    /*left导航*/
    .nav {
        position: fixed;
        bottom: 300px;
        left: 10px;
        width: 100px;
        height: 200px;
        background-color: #dcf5f3;
    }

    .nav ul li {
        border: 1px dashed #14f597;
        width: 100%;
        height: 40px;
    }

    .nav ul li:hover{
        background-color: #1ab394;
    }

    /*right 导航*/
    .rightNav{
        position: fixed;
        bottom: 100px;
        right: 30px;
        width: 80px;
        height: 80px;
        border-radius: 40px;
        background-color: #dcf5f3;
        text-align: center;
    }

    .treeBox{
        width: 80vw;border: 1px solid #3ec8c6;margin: 10px 0;display: flex;justify-content: left;min-width: 350px;margin-top: 10px
    }
}

@media (max-width: 1200px) or (max-height: 550px) {
    .nav {
        display: none;
    }
    .rightNav {
        display: none;
    }

}


@media (max-width: 880px) {
    .treeBox{
        display: none;
    }
}




</style>
