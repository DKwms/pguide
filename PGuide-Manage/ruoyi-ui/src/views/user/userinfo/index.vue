<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学生账户" prop="studentAccount">
        <el-input
          v-model="queryParams.studentAccount"
          placeholder="学生账户"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="studentPassword">
        <el-input
          v-model="queryParams.studentPassword"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学号" prop="workId">
        <el-input
          v-model="queryParams.workId"
          placeholder="请输入学号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户生日" prop="studentBirth">
        <el-date-picker clearable
          v-model="queryParams.studentBirth"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择用户生日">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="用户手机号" prop="studentPhonenumber">
        <el-input
          v-model="queryParams.studentPhonenumber"
          placeholder="请输入用户手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户邮箱号" prop="studentEmail">
        <el-input
          v-model="queryParams.studentEmail"
          placeholder="请输入用户邮箱号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户学校" prop="studentSchool">
        <el-input
          v-model="queryParams.studentSchool"
          placeholder="请输入用户学校"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户学院" prop="studentAcademy">
        <el-input
          v-model="queryParams.studentAcademy"
          placeholder="请输入用户学院"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户年级" prop="studentYear">
        <el-input
          v-model="queryParams.studentYear"
          placeholder="请输入用户年级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户专业" prop="studentProfession">
        <el-input
          v-model="queryParams.studentProfession"
          placeholder="请输入用户专业"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户个人签名" prop="userSign">
        <el-input
          v-model="queryParams.userSign"
          placeholder="请输入用户个人签名"
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
      <el-form-item label="逻辑删除 0删除状态 1没有删除" prop="deleted">
        <el-input
          v-model="queryParams.deleted"
          placeholder="请输入逻辑删除 0删除状态 1没有删除"
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
          v-hasPermi="['project:info:add']"
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
          v-hasPermi="['project:info:edit']"
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
          v-hasPermi="['project:info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['project:info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户id" align="center" prop="studentId" />
      <el-table-column label="${comment}" align="center" prop="studentAccount" />
      <el-table-column label="${comment}" align="center" prop="studentPassword" />
      <el-table-column label="学号" align="center" prop="workId" />
      <el-table-column label="用户性别" align="center" prop="studentSex" />
      <el-table-column label="用户生日" align="center" prop="studentBirth" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.studentBirth, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="用户手机号" align="center" prop="studentPhonenumber" />
      <el-table-column label="用户邮箱号" align="center" prop="studentEmail" />
      <el-table-column label="用户学校" align="center" prop="studentSchool" />
      <el-table-column label="用户学院" align="center" prop="studentAcademy" />
      <el-table-column label="用户年级" align="center" prop="studentYear" />
      <el-table-column label="用户专业" align="center" prop="studentProfession" />
      <el-table-column label="用户个人签名" align="center" prop="userSign" />
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
      <el-table-column label="逻辑删除 0删除状态 1没有删除" align="center" prop="deleted" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['project:info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['project:info:remove']"
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

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="${comment}" prop="studentAccount">
          <el-input v-model="form.studentAccount" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="studentPassword">
          <el-input v-model="form.studentPassword" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="学号" prop="workId">
          <el-input v-model="form.workId" placeholder="请输入学号" />
        </el-form-item>
        <el-form-item label="用户生日" prop="studentBirth">
          <el-date-picker clearable
            v-model="form.studentBirth"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择用户生日">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="用户手机号" prop="studentPhonenumber">
          <el-input v-model="form.studentPhonenumber" placeholder="请输入用户手机号" />
        </el-form-item>
        <el-form-item label="用户邮箱号" prop="studentEmail">
          <el-input v-model="form.studentEmail" placeholder="请输入用户邮箱号" />
        </el-form-item>
        <el-form-item label="用户学校" prop="studentSchool">
          <el-input v-model="form.studentSchool" placeholder="请输入用户学校" />
        </el-form-item>
        <el-form-item label="用户学院" prop="studentAcademy">
          <el-input v-model="form.studentAcademy" placeholder="请输入用户学院" />
        </el-form-item>
        <el-form-item label="用户年级" prop="studentYear">
          <el-input v-model="form.studentYear" placeholder="请输入用户年级" />
        </el-form-item>
        <el-form-item label="用户专业" prop="studentProfession">
          <el-input v-model="form.studentProfession" placeholder="请输入用户专业" />
        </el-form-item>
        <el-form-item label="用户个人签名" prop="userSign">
          <el-input v-model="form.userSign" placeholder="请输入用户个人签名" />
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
        <el-form-item label="逻辑删除 0删除状态 1没有删除" prop="deleted">
          <el-input v-model="form.deleted" placeholder="请输入逻辑删除 0删除状态 1没有删除" />
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
import { listInfo, getInfo, delInfo, addInfo, updateInfo } from "@/api/user/studentInfo";

export default {
  name: "Info",
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
      infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        studentAccount: null,
        studentPassword: null,
        workId: null,
        studentSex: null,
        studentBirth: null,
        studentPhonenumber: null,
        studentEmail: null,
        studentSchool: null,
        studentAcademy: null,
        studentYear: null,
        studentProfession: null,
        userSign: null,
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
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
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
        studentId: null,
        studentAccount: null,
        studentPassword: null,
        workId: null,
        studentSex: null,
        studentBirth: null,
        studentPhonenumber: null,
        studentEmail: null,
        studentSchool: null,
        studentAcademy: null,
        studentYear: null,
        studentProfession: null,
        userSign: null,
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
      this.ids = selection.map(item => item.studentId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加【请填写功能名称】";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const studentId = row.studentId || this.ids
      getInfo(studentId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.studentId != null) {
            updateInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInfo(this.form).then(response => {
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
      const studentIds = row.studentId || this.ids;
      this.$modal.confirm('是否确认删除【请填写功能名称】编号为"' + studentIds + '"的数据项？').then(function() {
        return delInfo(studentIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('project/info/export', {
        ...this.queryParams
      }, `info_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
