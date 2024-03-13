<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="任务名" prop="taskName">
        <el-input
          v-model="queryParams.taskName"
          placeholder="请输入任务名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务详情" prop="taskDetail">
        <el-input
          v-model="queryParams.taskDetail"
          placeholder="请输入任务详情"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="起始时间" prop="taskStartTime">
        <el-date-picker clearable
          v-model="queryParams.taskStartTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择任务起始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="截至时间" prop="taskEndTime">
        <el-date-picker clearable
          v-model="queryParams.taskEndTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择任务截至时间">
        </el-date-picker>
      </el-form-item>
<!--       0关闭 1显示-->
      <el-form-item label="任务状态" prop="taskShow">
        <el-input
          v-model="queryParams.taskShow"
          placeholder="请输入任务显示状态 0关闭 1显示"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发布者" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入冗余字段，对应用户表中用户名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="金币数" prop="reward">
        <el-input
          v-model="queryParams.reward"
          placeholder="请输入完成奖励金币数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发布时间" prop="created">
        <el-date-picker clearable
          v-model="queryParams.created"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择发布时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['project:task:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['project:task:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['project:task:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['project:task:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="taskList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="taskId" />
      <el-table-column label="任务名" align="center" prop="taskName" />
      <el-table-column label="任务详情" align="center" prop="taskDetail" />
      <el-table-column label="任务起始时间" align="center" prop="taskStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.taskStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="任务截至时间" align="center" prop="taskEndTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.taskEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
<!--      0关闭 1显示-->
      <el-table-column label="显示状态 " align="center" prop="taskShow" />
<!--      0未开始 1进行中 2已完成 3暂停 4废除-->
      <el-table-column label="任务状态 " align="center" prop="taskStateType" />
      <el-table-column label="金币数" align="center" prop="reward" />
      <el-table-column label="发布时间" align="center" prop="created" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.created, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['project:task:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['project:task:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改【对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="任务名" prop="taskName">
          <el-input v-model="form.taskName" placeholder="请输入任务名" />
        </el-form-item>
        <el-form-item label="任务详情" prop="taskDetail">
          <textarea style="width: 100%;height: 10vh" v-model="form.taskDetail" placeholder="请输入任务详情" />
        </el-form-item>
        <el-form-item label="起始时间" prop="taskStartTime">
          <el-date-picker clearable
            v-model="form.taskStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择任务起始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="截至时间" prop="taskEndTime">
          <el-date-picker clearable
            v-model="form.taskEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择任务截至时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="任务状态" prop="taskShow">
          <el-select v-model="form.taskShow" placeholder="请选择">
            <el-option
              v-for="item in optionResultTaskStatus"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="角色范围">
          <el-select v-model="form.optionResult" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="金币数" prop="reward">
          <el-input v-model="form.reward" placeholder="请输入完成奖励金币数" />
        </el-form-item>
        <el-form-item label="发布时间" prop="created">
          <el-date-picker clearable
            v-model="form.created"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发布时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listTask, getTask, delTask, addTask, updateTask, addTaskByRole} from "@/api/project/task";
import {listRole} from "@/api/system/role";

export default {
  name: "Task",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 【请填写功能名称】表格数据
      taskList: [],
      // 弹出层标题
      title: "新增任务",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        taskName: null,
        taskDetail: null,
        taskStartTime: null,
        taskEndTime: null,
        taskShow: null,
        taskStateType: null,
        userId: null,
        userName: null,
        reward: null,
        created: null,
        update: null
      },
      // 表单参数
      form: {
        taskShow:1,
        optionResult:null,
      },
      // 表单校验
      rules: {
      },
      // TODO rabc 角色选项
      options: [],
      optionResult:null,
      // 任务显示状态
      optionResultTaskStatus:[
        {
          value: 1,
          label: "显示"
        },
        {
          value: 0,
          label: "关闭"
        },
      ]
    };
  },
  mounted() {
    listRole().then(r=>{
      var newOptions = []
      for (const rElement of r.rows) {
        newOptions.push({
          value: rElement.roleId,
          label: rElement.roleName
        })
      }
      this.options = newOptions
    })
  },
  created() {
    this.getList();
    this.form.taskShow = 1;
  },
  methods: {
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listTask(this.queryParams).then(response => {
        this.taskList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        taskId: null,
        taskName: null,
        taskDetail: null,
        taskStartTime: null,
        taskEndTime: null,
        taskShow: null,
        taskStateType: null,
        userId: null,
        userName: null,
        reward: null,
        created: null,
        update: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.taskId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "新增任务";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const taskId = row.taskId || this.ids
      getTask(taskId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改任务";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.taskId != null) {
            updateTask(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            // addTask(this.form).then(response => {
            //   this.$modal.msgSuccess("新增成功");
            //   this.open = false;
            //   this.getList();
            // });
            //TODO addTaskWithRole
            addTaskByRole(this.form).then(r=>{
              // 刷新
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            })
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const taskIds = row.taskId || this.ids;
      this.$modal.confirm('是否确认删除编号为"' + taskIds + '"的数据项？').then(function() {
        return delTask(taskIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('project/task/export', {
        ...this.queryParams
      }, `task_${new Date().getTime()}.xlsx`)
    },
    taskShowButton(){
      if(this.form.taskShow == 0 ){
        this.form.taskShow = 1;
      }else{
        this.form.taskShow = 0;
      }
    }
  }
};
</script>
