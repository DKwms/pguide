<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目id" prop="projectId">
        <el-input
          v-model="queryParams.projectId"
          placeholder="请输入项目id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="招募标题" prop="recruitName">
        <el-input
          v-model="queryParams.recruitName"
          placeholder="请输入招募标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="需求类型" prop="needTypeId">
        <el-input
          v-model="queryParams.needTypeId"
          placeholder="请输入需求类型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开始时间" prop="recruitStartTime">
        <el-date-picker clearable
          v-model="queryParams.recruitStartTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="截止时间" prop="recruitEndTime">
        <el-date-picker clearable
          v-model="queryParams.recruitEndTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择截止时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="发布人id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入发布人id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="奖励数" prop="recruitRw">
        <el-input
          v-model="queryParams.recruitRw"
          placeholder="请输入奖励数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="created">
        <el-date-picker clearable
          v-model="queryParams.created"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="更新时间" prop="updated">
        <el-date-picker clearable
          v-model="queryParams.updated"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择更新时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="逻辑删除" prop="deleted">
        <el-input
          v-model="queryParams.deleted"
          placeholder="请输入逻辑删除"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['manage:recruitinfo:add']"
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
          v-hasPermi="['manage:recruitinfo:edit']"
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
          v-hasPermi="['manage:recruitinfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['manage:recruitinfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="recruitinfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="recruitId" />
      <el-table-column label="项目id" align="center" prop="projectId" />
      <el-table-column label="招募标题" align="center" prop="recruitName" />
      <el-table-column label="需求类型" align="center" prop="needTypeId" />
      <el-table-column label="开始时间" align="center" prop="recruitStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.recruitStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="截止时间" align="center" prop="recruitEndTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.recruitEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="发布人id" align="center" prop="userId" />
      <el-table-column label="奖励数" align="center" prop="recruitRw" />
      <el-table-column label="创建时间" align="center" prop="created" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.created, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新时间" align="center" prop="updated" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updated, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="逻辑删除" align="center" prop="deleted" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['manage:recruitinfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['manage:recruitinfo:remove']"
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

    <!-- 添加或修改项目需求招募信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目id" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目id" />
        </el-form-item>
        <el-form-item label="招募标题" prop="recruitName">
          <el-input v-model="form.recruitName" placeholder="请输入招募标题" />
        </el-form-item>
        <el-form-item label="需求类型" prop="needTypeId">
          <el-input v-model="form.needTypeId" placeholder="请输入需求类型" />
        </el-form-item>
        <el-form-item label="开始时间" prop="recruitStartTime">
          <el-date-picker clearable
            v-model="form.recruitStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="截止时间" prop="recruitEndTime">
          <el-date-picker clearable
            v-model="form.recruitEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择截止时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="发布人id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入发布人id" />
        </el-form-item>
        <el-form-item label="奖励数" prop="recruitRw">
          <el-input v-model="form.recruitRw" placeholder="请输入奖励数" />
        </el-form-item>
        <el-form-item label="创建时间" prop="created">
          <el-date-picker clearable
            v-model="form.created"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="更新时间" prop="updated">
          <el-date-picker clearable
            v-model="form.updated"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择更新时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="逻辑删除" prop="deleted">
          <el-input v-model="form.deleted" placeholder="请输入逻辑删除" />
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
import { listRecruitinfo, getRecruitinfo, delRecruitinfo, addRecruitinfo, updateRecruitinfo } from "@/api/manage/recruitinfo";

export default {
  name: "Recruitinfo",
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
      // 项目需求招募信息表格数据
      recruitinfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectId: null,
        recruitName: null,
        needTypeId: null,
        recruitStartTime: null,
        recruitEndTime: null,
        userId: null,
        recruitRw: null,
        created: null,
        updated: null,
        deleted: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询项目需求招募信息列表 */
    getList() {
      this.loading = true;
      listRecruitinfo(this.queryParams).then(response => {
        this.recruitinfoList = response.rows;
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
        recruitId: null,
        projectId: null,
        recruitName: null,
        needTypeId: null,
        recruitStartTime: null,
        recruitEndTime: null,
        userId: null,
        recruitRw: null,
        created: null,
        updated: null,
        deleted: null
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
      this.ids = selection.map(item => item.recruitId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加项目需求招募信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const recruitId = row.recruitId || this.ids
      getRecruitinfo(recruitId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改项目需求招募信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.recruitId != null) {
            updateRecruitinfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRecruitinfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const recruitIds = row.recruitId || this.ids;
      this.$modal.confirm('是否确认删除项目需求招募信息编号为"' + recruitIds + '"的数据项？').then(function() {
        return delRecruitinfo(recruitIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('manage/recruitinfo/export', {
        ...this.queryParams
      }, `recruitinfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
