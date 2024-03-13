<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="组织名" prop="orgName">
        <el-input
          v-model="queryParams.orgName"
          placeholder="请输入组织名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="成立时间" prop="orgStartTime">
        <el-date-picker clearable
          v-model="queryParams.orgStartTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择成立时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="上属 组织" prop="orgParentId">
        <el-input
          v-model="queryParams.orgParentId"
          placeholder="请输入上属 组织"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属地区" prop="orgArea">
        <el-input
          v-model="queryParams.orgArea"
          placeholder="请输入所属地区"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收录时间" prop="created">
        <el-date-picker clearable
          v-model="queryParams.created"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择收录时间">
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
          v-hasPermi="['cmsmanage:orgdict:add']"
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
          v-hasPermi="['cmsmanage:orgdict:edit']"
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
          v-hasPermi="['cmsmanage:orgdict:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['cmsmanage:orgdict:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orgdictList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="组织id" align="center" prop="orgId" />
      <el-table-column label="组织名" align="center" prop="orgName" />
      <el-table-column label="成立时间" align="center" prop="orgStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.orgStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="上属 组织" align="center" prop="orgParentId" />
      <el-table-column label="所属地区" align="center" prop="orgArea" />
      <el-table-column label="收录时间" align="center" prop="created" width="180">
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
            v-hasPermi="['cmsmanage:orgdict:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['cmsmanage:orgdict:remove']"
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

    <!-- 添加或修改组织字典对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="组织名" prop="orgName">
          <el-input v-model="form.orgName" placeholder="请输入组织名" />
        </el-form-item>
        <el-form-item label="成立时间" prop="orgStartTime">
          <el-date-picker clearable
            v-model="form.orgStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择成立时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="上属 组织" prop="orgParentId">
          <el-input v-model="form.orgParentId" placeholder="请输入上属 组织" />
        </el-form-item>
        <el-form-item label="所属地区" prop="orgArea">
          <el-input v-model="form.orgArea" placeholder="请输入所属地区" />
        </el-form-item>
        <el-form-item label="收录时间" prop="created">
          <el-date-picker clearable
            v-model="form.created"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择收录时间">
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
import { listOrgdict, getOrgdict, delOrgdict, addOrgdict, updateOrgdict } from "@/api/cmsmanage/orgdict";

export default {
  name: "Orgdict",
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
      // 组织字典表格数据
      orgdictList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orgName: null,
        orgStartTime: null,
        orgParentId: null,
        orgArea: null,
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
    /** 查询组织字典列表 */
    getList() {
      this.loading = true;
      listOrgdict(this.queryParams).then(response => {
        this.orgdictList = response.rows;
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
        orgId: null,
        orgName: null,
        orgStartTime: null,
        orgParentId: null,
        orgArea: null,
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
      this.ids = selection.map(item => item.orgId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加组织字典";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const orgId = row.orgId || this.ids
      getOrgdict(orgId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改组织字典";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.orgId != null) {
            updateOrgdict(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrgdict(this.form).then(response => {
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
      const orgIds = row.orgId || this.ids;
      this.$modal.confirm('是否确认删除组织字典编号为"' + orgIds + '"的数据项？').then(function() {
        return delOrgdict(orgIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('cmsmanage/orgdict/export', {
        ...this.queryParams
      }, `orgdict_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
