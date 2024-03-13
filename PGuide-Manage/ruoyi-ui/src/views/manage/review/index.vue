<template>
  <div>
    <div style="width: 100%;height: 20%;padding: 10px">
      <el-form :model="queryParams" size="small" :inline="true" >
        <el-form-item label="项目名称" prop="projectName">
          <el-input
            placeholder="请输入名称"
            clearable
            v-model="queryParams.projectName"
          />
        </el-form-item>

        <el-form-item label="注册时间大于" prop="created">
          <el-date-picker clearable
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择注册时间"
                          v-model="queryParams.startTime"
          >
          </el-date-picker>
        </el-form-item>

        <el-form-item label="注册时间小于" prop="created">
          <el-date-picker clearable
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择注册时间"
                          v-model="queryParams.endTime"
          >
          </el-date-picker>
        </el-form-item>

        <el-form-item label="审核状态" prop="projectName">
          <el-select v-model="queryParams.projectStatus" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <!--TODO -->

        <el-form-item label="创建人" prop="projectName">
          <el-autocomplete
            class="inline-input"
            v-model="queryParams.state1"
            :fetch-suggestions="querySearch"
            placeholder="请输入内容"
            @select="handleSelect"
          ></el-autocomplete>
        </el-form-item>

        <!--TODO -->
        <el-form-item label="学校" prop="projectName">
          <el-input
            placeholder="请输入名称"
            clearable
          />
        </el-form-item>
        <!--TODO -->

        <el-form-item label="学院" prop="projectName">
          <el-input
            placeholder="请输入名称"
            clearable
          />
        </el-form-item>
        <el-button type="primary" plain @click="formSearch()">搜索</el-button>
      </el-form>
    </div>
    <hr>
    <div style="width: 100%;height: 100%;">
      <div style="display: flex;justify-content: center;align-items: center;flex-direction: column;margin: 0 10px">
        <h1>当前项目</h1>
        <div style="display: flex;justify-content: center;margin:10px;flex-wrap: wrap">
          <template v-for="i in projectList" id="objs">
            <ReviewCard class="rc" style="width: 300px;height: 380px" :book-info="i"></ReviewCard>
          </template>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ReviewCard from "@/components/Pguide/Card/ReviewCard.vue";
import {listPublishVo} from "@/api/manage/publish";

export default {
  name: "manageReview",
  components: {ReviewCard},
  data(){
    return {
      restaurants: [],
      options:[
        {label:"系统未检查",value:"1"},
        {label:"系统已检查",value:"2"},
        {label:"已发布",value:"4"},
        {label:"停止发布",value:"5"},
        {label:"检查未通过",value:"6"},
      ],
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectName: null,
        projectSubjectType: null,
        projectOpenLevel: null,
        projectStatus:"",
        projectSchool:"",
        projectAcademy:"",
        projectClass:"",
        projectAdmin:"",
        startTime:"",
        endTime:""
      },
      projectList:[]
    }
  },
  methods:{
    formSearch(){
      this.projectList = null;
      listPublishVo(this.queryParams).then(res=>{
        this.projectList = res.rows
      }).catch(e=>{
        this.$message.error("后端接口响应超时")
      })
    },
    refresh() {
      this.$router.go(0)
    },
    querySearch(queryString, cb) {
      var restaurants = this.restaurants;
      var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter(queryString) {
      return (restaurant) => {
        return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
      };
    },
    loadAll() {
      return [
        { "value": "三全鲜食（北新泾店）", "address": "长宁区新渔路144号" },
        { "value": "Hot honey 首尔炸鸡（仙霞路）", "address": "上海市长宁区淞虹路661号" },
        { "value": "新旺角茶餐厅", "address": "上海市普陀区真北路988号创邑金沙谷6号楼113" },
        { "value": "泷千家(天山西路店)", "address": "天山西路438号" },
        { "value": "胖仙女纸杯蛋糕（上海凌空店）", "address": "上海市长宁区金钟路968号1幢18号楼一层商铺18-101" },
        { "value": "贡茶", "address": "上海市长宁区金钟路633号" },
        { "value": "豪大大香鸡排超级奶爸", "address": "上海市嘉定区曹安公路曹安路1685号" },
        { "value": "茶芝兰（奶茶，手抓饼）", "address": "上海市普陀区同普路1435号" },
        { "value": "十二泷町", "address": "上海市北翟路1444弄81号B幢-107" },
        { "value": "星移浓缩咖啡", "address": "上海市嘉定区新郁路817号" },
        { "value": "阿姨奶茶/豪大大", "address": "嘉定区曹安路1611号" },
      ];
    },
    handleSelect(item) {
      console.log(item);
    }
  },
  mounted() {
    this.restaurants = this.loadAll();
    listPublishVo().then(res=>{
      this.projectList = res.rows
      console.log(this.projectList)
    }).catch(e=>{
      this.$message.error("后端接口响应超时")
    })
  }
}
</script>

<style scoped>
.rc{
  margin: 20px
}
</style>
