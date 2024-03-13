<template>
    <div class="box"
         style="background-color:#ffffff;color:black;;border: 1px solid #7db1da;width: 100%;height: 100%;display: flex;justify-content: space-between;flex-direction:column;text-align: center">

        <!--        成员构成-->
        <div class="mainDiv">
            <div class="header"
                 style="display: flex;justify-content: space-between;flex-direction: column;width: 100%;">
                <div style="font-size: 18px;width:100%;height: 40px;display: flex;justify-content: center;flex-direction: column;align-items: center;background-color: #c8e7ff">
                    项导--项目导航
                </div>

            </div>
        </div>

        <div class="body"
             style="width: 100%;height: 100%;display: flex;justify-content: space-between;flex-direction: column;align-items: center;">
            <!--    项目内容主体-->
            <div style="width: 100%;height: 50%;position: relative;overflow: hidden">
                <div class="talk">
                    <el-button style="background-color: #7400B8;color: #80FFDB;border: 1px solid #80FFDB;margin-top:53px">立即交流
                    </el-button>
                </div>

                <hr color="#d0d1ff">
                <div style="font-size: 14px;">
                    <!--TODO hover的时候替换学校名字为学院名字-->
                    名字长的大学
                </div>
                <div class="tags" style="font-size: 14px;display: flex;justify-content: left;">
                    <!--TODO 加一点色彩-->
                    <div class="tag" style="height: 10%;border: 1px solid #7400B8">竞赛偏好最多11个字字字</div>
                    <!--<div class="tag" style="height: 10%">项目类型最多11个字字字</div>-->
                    <!--<div class="tag" style="height: 10%">竞赛偏好</div>-->
                    <div class="tag" style="height: 10%;border: 1px solid #5E60CE">项目类型</div>
                </div>
            </div>

            <div style="width: 100%;height: 50%;overflow: hidden">
                <div class="intro">
                    <p>
                        一些简介
                    </p>
                </div>

                <div style="width: 100%;height: 100%;background-color: #ff0054">
                    <el-button style="background-color: #7400B8;color: #80FFDB;border: 1px solid #80FFDB">投递简历
                    </el-button>
                </div>
            </div>
            <div class="bottom"
                 style="height: 10%;width: 100%;display: flex;justify-content: end;;border-top: 2px solid #deaaff;background-color: #c8e7ff">
                <div>
                    指导老师：xxx
                </div>
            </div>
        </div>
    </div>
</template>


<script>
import VanillaTilt from "vanilla-tilt";

export default {
    name: "InfoCard",
    props: {},
    mounted() {
        VanillaTilt.init(document.querySelectorAll(".box"), {
            reverse: true,
            max: 10,  //最大倾斜度数
            speed: 100,  //倾斜转换的速度
            // glare: true,  //是否开启眩光效果
            "max-glare": 1  //最大眩光的不透明度
        })
    }
}
</script>
<style scoped>

* {
    font-size: 14px;
}

div {
    /*border: 1px dashed plum;*/

}

.mainDiv {
    height: 50px;
    width: 100%;
}

.box:hover {
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.4);

}

.intro {
    width: 100%;
    height: 100%;
    transition: height 1s;
}

.box:hover .intro {
    height: 0%;
    transition: height 0.6s;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.4);
}

.box:hover .talk {
    top:0;
    transition: top 0.6s;
}

.talk {

    width: 100%;
    height: 100%;
    background-color: #ff0054;
    top:-100%;
    position: absolute;
    transition: top 1s;
}

/*.box:hover p{*/
/*    display: none;*/
/*}*/

.tag {
    margin: 3px;
}
</style>
