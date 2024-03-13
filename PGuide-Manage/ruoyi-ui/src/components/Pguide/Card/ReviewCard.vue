<template>
  <div>
    <div class="book" @mouseleave="downAllPage()" @mouseenter="pageInit()">
      <!--cover -->
      <div class="cover" ref="cover">
        <div
          style="height:70%;width:100%;display: flex;justify-content: center;flex-direction: column;align-items: center;">
          <p>{{ bookInfo.projectName }}</p>
          <p>{{ bookInfo.projectSchool }}</p>
          <p>{{ bookInfo.projectAcademy }}</p>
          <p>{{ bookInfo.projectType }}</p>
        </div>
        <div style="height:20%;width: 100%;display: flex;justify-content: end;">
          <p>--{{ bookInfo.projectAdmin }}</p>
        </div>
      </div>
      <!--page1-->
      <div class="page p0"
           ref="p0">
        <div style="height: 70%;width:100%;border: 1px dashed blueviolet">
          <p style="font-size: 14px;overflow-y: scroll;height: 90%">
            {{ bookInfo.projectInfo }}
          </p>
        </div>
        <div style="text-align: center;">

          <el-button type="success" plain @click="checkToPass()" v-show="this.bookInfo.projectStatus!==4 && this.bookInfo.projectStatus!==2">通过</el-button>
          <el-button type="danger" plain @click="checkToReturn()">打回</el-button>
        </div>
      </div>
      <!--page2-->
      <div class="page p1" ref="p1">
        <div style="height: 70%;width:100%;border: 1px dashed burlywood">
          <!--是否发布-->
          <p> 是否直接进行发布</p>
          <div style="height: 20%;width:100%;">
            <el-button type="success" plain @click="publishProject()">发布</el-button>
            <el-button type="danger" plain @click="checkProject()">暂存</el-button>
          </div>
        </div>
        <div style="text-align: center;">
          <el-button type="success" plain @click="backPage(1)">返回</el-button>
        </div>
      </div>
      <!-- page3-->
      <div class="page p2" ref="p2">
        <div style="height: 70%;width:100%;border: 1px solid blueviolet">
          <h2>打回信息填写</h2>

          <input type="text" placeholder="填写拒绝理由" @focus="inInput()" @blur="outInput()" class="inputs"
                 style="width: 100%"></input>
          <div style="margin-top: 20px">
            <h3>通知方式</h3>
            <el-checkbox-group
              v-model="checkedCities">
              <el-checkbox v-for="city in cities" :label="city" :key="city">{{ city }}</el-checkbox>
            </el-checkbox-group>
          </div>
        </div>
        <div style="text-align: center">
          <el-button type="success" plain @click="backPage(2)">返回</el-button>
          <el-button type="success" plain @click="returnProject()">提交</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {checked, publish, unpass} from "@/api/manage/publish";

export default {
  name: "ReviewCard",
  props: {
    bookInfo: {
      projectName: "",
      projectSchool: "",
      projectAcademy: "",
      projectClass: "",
      // 比赛类型
      projectType: "",
      // 简介
      projectInfo: "",
      projectAdmin: "",
      // 项目状态,审核，通过（第三方，系统），未通过
      // 黄色 ， 绿色 ， 红色
      projectStatus: ""
    }
  },
  data() {
    const cityOptions = ['qq', '系统', '短信'];
    return {
      PageList: [],
      ifPrint: false,
      checkedCities: ['qq', '系统', '短信'],
      cities: cityOptions,
      publishVo:{
        projectName:this.bookInfo.projectName
      },

    }
  },

  mounted() {

    //TODO 初始化项目信息

    var elementsByClassName = this.$refs["cover"]

    if(this.bookInfo.projectStatus===1){
      elementsByClassName.className = "cover" + " y"
    }
    else if(this.bookInfo.projectStatus===2){
      elementsByClassName.className = "cover" + " g"
    }
    else if(this.bookInfo.projectStatus===4){
      elementsByClassName.className = "cover" + " b"
    }
    else{
      elementsByClassName.className = "cover" + " r"
    }

  },
  methods: {
    // 刷新页面
    refresh() {
      this.$router.go(0)
    },
    // 发布项目
    publishProject(){
      publish(this.publishVo)
      this.refresh()
    },
    // 检查项目
    checkProject(){
      checked(this.publishVo)
      this.refresh()
    },
    // web Api
    returnProject() {
      // TODO项目被打回
      unpass(this.publishVo)
      this.refresh()
    },
    // 通过页面控制 p1
    checkToPass() {
      this.$refs.p0.id = "nextPage"
      this.PageList.push(this.$refs.p0);
    },
    // 打回 p2
    checkToReturn() {
      this.$refs.p1.id = "nextPage"
      this.$refs.p0.id = "nextPage"
      this.PageList.push(this.$refs.p0);
      this.PageList.push(this.$refs.p1);
    },
    backPage(p) {
      // if(!this.ifPrint) {
      console.log(this.PageList.length)
      for (let i = 0; i < p; i++) {
        const page = this.PageList.pop();
        page.id = "closePage"
        page.style = "transition: all 0.35s;"
      }
      // }
    },
    // 重置初始化翻页时间
    pageInit() {
      console.log("-====")
      console.log(this.ifPrint)
      console.log(this.$refs.cover)

      if (!this.ifPrint) {
        try {
          // 这里有异常，后面处理，先用final吧翻页完成
          var elementsByClassName2 = document.getElementsByClassName("inputs");
          for (const elementsByClassName2Element of elementsByClassName2) {
            elementsByClassName2Element.blur()
          }

          var elementsByClassName1 = document.getElementsByClassName("cover");
          for (const elementsByClassName1Element of elementsByClassName1) {
            elementsByClassName1Element.id = "closePage"
            elementsByClassName1Element.style = "transition: all 0.35s;"
          }

          var elementsByClassName = document.getElementsByClassName("page");
          for (const elementsByClassNameElement of elementsByClassName) {
            elementsByClassNameElement.style = "transition: all 0.35s;"
            elementsByClassNameElement.id = "closePage"
          }
          for (let i = this.PageList.length - 1; i >= 0; i++) {
            const pageLi = this.PageList[i];
            pageLi.id = "closePage";
            pageLi.style = "transition: all 0.35s;"
          }
        } finally {
          this.$refs.cover.id = "nextPage";
          this.$refs.cover.style = "transition: all 0.35s;"
          this.PageList.push(this.$refs.cover);
        }

      }


    },
    // 闭合书本
    downAllPage() {
      if (!this.ifPrint) {
        if (this.PageList.length !== 0) {
          const time = 1;
          const everyTime = time / (this.PageList.length);
          for (let i = this.PageList.length - 1; i >= 0; i++) {
            const pageLi = this.PageList.pop();
            pageLi.id = "closePage";
            pageLi.style = "transition: all " + everyTime * (i + 1) + "s;"
          }
          this.PageList = [];
        }
        this.ifPrint = false;
      }
    },
    inInput() {
      this.ifPrint = true
    },
    outInput() {
      this.ifPrint = false
    }
  }
}
</script>

<style scoped>

.book {
  width: 100%;
  height: 100%;
  position: relative;
  border-radius: 10px;
  background-color: whitesmoke;
  -webkit-transform: preserve-3d;
  -ms-transform: preserve-3d;
  transform: preserve-3d;
  -webkit-perspective: 2000px;
  perspective: 2000px;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  box-shadow: 0px 0px 15px -4px rgba(0, 0, 0, 1);
}

.cover {
  z-index: 2;
  top: 0;
  position: absolute;
  background-color: #ea7373;
  width: 100%;
  height: 100%;
  border-radius: 2px;
  border-bottom-right-radius: 10px;
  border-top-right-radius: 10px;
  cursor: pointer;
  -webkit-transition: all 0.5s;
  transition: all 0.5s;
  -webkit-transform-origin: 0;
  -ms-transform-origin: 0;
  transform-origin: 0;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  flex-direction: column;
  box-shadow: 0px 0px 15px -4px rgba(0, 0, 0, 1);
}

/*.book:hover .cover {*/
/*  -webkit-transition: all 0.29s;*/
/*  transition: all 0.29s;*/
/*  -webkit-transform: rotatey(-85deg);*/
/*  -ms-transform: rotatey(-85deg);*/
/*  transform: rotatey(-85deg);*/
/*}*/

#nextPage {
  background-color: #9b9b9b;
  -webkit-transition: all 0.29s;
  transition: all 0.29s;
  -webkit-transform: rotatey(-85deg);
  -ms-transform: rotatey(-85deg);
  transform: rotatey(-85deg);
}

#closePage {
  -webkit-transition: all 0.29s;
  transition: all 0.29s;
  -webkit-transform: rotatey(0deg);
  -ms-transform: rotatey(0deg);
  transform: rotatey(0deg);
}

.page {
  height: 100%;
  width: 100%;
  display: flex;
  background-color: #dddddd;
  justify-content: center;
  flex-direction: column;

  align-items: center;
  padding: 0 8px;
  font-size: 12px;
  top: 0;
  position: absolute;
  -webkit-transform-origin: 0;
  -ms-transform-origin: 0;
  transform-origin: 0;
}


.r {
  background-color: #d37575;
}

.b {
  background-color: #6262ba;
}

.g {
  background-color: #6ac86a;
}

.y{
  background-color: #b0b05d;
}

.p0 {
  z-index: 1;
}

.p1 {
  z-index: 0;
}

.p2 {
  z-index: -1;
}

/*redio box */


</style>
