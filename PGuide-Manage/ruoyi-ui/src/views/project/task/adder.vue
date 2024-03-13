<template>
  <div>
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
      <el-form-item label="任务名称" prop="taskName">
        <el-input v-model="formData.taskName" placeholder="请输入任务名称" clearable :style="{width: '100%'}">
        </el-input>
      </el-form-item>
      <el-form-item label="任务详情" prop="taskDetail">
        <el-input v-model="formData.taskDetail" type="textarea" placeholder="请输入任务详情"
                  :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="日期范围" prop="field107">
        <el-date-picker type="daterange" v-model="formData.field107" format="yyyy-MM-dd"
                        value-format="yyyy-MM-dd" :style="{width: '100%'}" start-placeholder="开始日期" end-placeholder="结束日期"
                        range-separator="至" clearable></el-date-picker>
      </el-form-item>
      <el-form-item label="可见部门" prop="field109">
        <el-select v-model="formData.field109" placeholder="请选择可见部门" clearable :style="{width: '100%'}">
          <el-option v-for="(item, index) in field109Options" :key="adder" :label="item.label"
                     :value="item.value" :disabled="item.disabled"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="可见人员" prop="field110">
        <el-select v-model="formData.field110" placeholder="请选择可见人员" clearable :style="{width: '100%'}">
          <el-option v-for="(item, index) in field110Options" :key="adder" :label="item.label"
                     :value="item.value" :disabled="item.disabled"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item size="large">
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        taskName: undefined,
        taskDetail: '',
        field107: null,
        field109: undefined,
        field110: undefined,
      },
      rules: {
        taskName: [{
          required: true,
          message: '请输入任务名称',
          trigger: 'blur'
        }],
        taskDetail: [{
          required: true,
          message: '请输入任务详情',
          trigger: 'blur'
        }],
        field107: [{
          required: true,
          message: '日期范围不能为空',
          trigger: 'change'
        }],
        field109: [{
          required: true,
          message: '请选择可见部门',
          trigger: 'change'
        }],
        field110: [{
          required: true,
          message: '请选择可见人员',
          trigger: 'change'
        }],
      },
      field109Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field110Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
  }
}

</script>
<style>
</style>
