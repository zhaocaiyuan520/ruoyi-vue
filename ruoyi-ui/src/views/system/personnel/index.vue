<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="头像id，文件表存储地址和名称" prop="fileId">
        <el-input
          v-model="queryParams.fileId"
          placeholder="请输入头像id，文件表存储地址和名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名中文" prop="personnelName">
        <el-input
          v-model="queryParams.personnelName"
          placeholder="请输入姓名中文"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名英文" prop="personnelNameen">
        <el-input
          v-model="queryParams.personnelNameen"
          placeholder="请输入姓名英文"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Tel号码" prop="telNumber">
        <el-input
          v-model="queryParams.telNumber"
          placeholder="请输入Tel号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Fax号码" prop="faxNumber">
        <el-input
          v-model="queryParams.faxNumber"
          placeholder="请输入Fax号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="推特" prop="twitter">
        <el-input
          v-model="queryParams.twitter"
          placeholder="请输入推特"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="linked" prop="linkedin">
        <el-input
          v-model="queryParams.linkedin"
          placeholder="请输入linked"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="人员日期" prop="personnelDate">
        <el-input
          v-model="queryParams.personnelDate"
          placeholder="请输入人员日期"
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
          v-hasPermi="['system:personnel:add']"
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
          v-hasPermi="['system:personnel:edit']"
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
          v-hasPermi="['system:personnel:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:personnel:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="personnelList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="人员id" align="center" prop="personnelId" />
      <el-table-column label="0:博导、1:博士、2:研究生" align="center" prop="personnelType" />
      <el-table-column label="头像id，文件表存储地址和名称" align="center" prop="fileId" />
      <el-table-column label="姓名中文" align="center" prop="personnelName" />
      <el-table-column label="姓名英文" align="center" prop="personnelNameen" />
      <el-table-column label="简介中文" align="center" prop="personnelIntroduce" />
      <el-table-column label="简介英文" align="center" prop="personnelIntroduceen" />
      <el-table-column label="地址中文" align="center" prop="personnelAddress" />
      <el-table-column label="地址中文" align="center" prop="personnelAddressen" />
      <el-table-column label="Tel号码" align="center" prop="telNumber" />
      <el-table-column label="Fax号码" align="center" prop="faxNumber" />
      <el-table-column label="邮箱" align="center" prop="email" />
      <el-table-column label="推特" align="center" prop="twitter" />
      <el-table-column label="linked" align="center" prop="linkedin" />
      <el-table-column label="人员日期" align="center" prop="personnelDate" />
      <el-table-column label="当前位置" align="center" prop="currentPosition" />
      <el-table-column label="当前位置" align="center" prop="currentPositionen" />
      <el-table-column label="0:在读，1：已毕业" align="center" prop="graduateType" />
      <el-table-column label="contact中文" align="center" prop="personnelContact" />
      <el-table-column label="contact英文" align="center" prop="personnelContacten" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:personnel:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:personnel:remove']"
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

    <!-- 添加或修改人员详情对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="头像id，文件表存储地址和名称" prop="fileId">
          <el-input v-model="form.fileId" placeholder="请输入头像id，文件表存储地址和名称" />
        </el-form-item>
        <el-form-item label="姓名中文" prop="personnelName">
          <el-input v-model="form.personnelName" placeholder="请输入姓名中文" />
        </el-form-item>
        <el-form-item label="姓名英文" prop="personnelNameen">
          <el-input v-model="form.personnelNameen" placeholder="请输入姓名英文" />
        </el-form-item>
        <el-form-item label="简介中文" prop="personnelIntroduce">
          <el-input v-model="form.personnelIntroduce" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="简介英文" prop="personnelIntroduceen">
          <el-input v-model="form.personnelIntroduceen" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="地址中文" prop="personnelAddress">
          <el-input v-model="form.personnelAddress" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="地址中文" prop="personnelAddressen">
          <el-input v-model="form.personnelAddressen" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="Tel号码" prop="telNumber">
          <el-input v-model="form.telNumber" placeholder="请输入Tel号码" />
        </el-form-item>
        <el-form-item label="Fax号码" prop="faxNumber">
          <el-input v-model="form.faxNumber" placeholder="请输入Fax号码" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="推特" prop="twitter">
          <el-input v-model="form.twitter" placeholder="请输入推特" />
        </el-form-item>
        <el-form-item label="linked" prop="linkedin">
          <el-input v-model="form.linkedin" placeholder="请输入linked" />
        </el-form-item>
        <el-form-item label="人员日期" prop="personnelDate">
          <el-input v-model="form.personnelDate" placeholder="请输入人员日期" />
        </el-form-item>
        <el-form-item label="当前位置" prop="currentPosition">
          <el-input v-model="form.currentPosition" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="当前位置" prop="currentPositionen">
          <el-input v-model="form.currentPositionen" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="contact中文" prop="personnelContact">
          <el-input v-model="form.personnelContact" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="contact英文" prop="personnelContacten">
          <el-input v-model="form.personnelContacten" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
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
import { listPersonnel, getPersonnel, delPersonnel, addPersonnel, updatePersonnel } from "@/api/system/personnel";

export default {
  name: "Personnel",
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
      // 人员详情表格数据
      personnelList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        personnelType: null,
        fileId: null,
        personnelName: null,
        personnelNameen: null,
        personnelIntroduce: null,
        personnelIntroduceen: null,
        personnelAddress: null,
        personnelAddressen: null,
        telNumber: null,
        faxNumber: null,
        email: null,
        twitter: null,
        linkedin: null,
        personnelDate: null,
        currentPosition: null,
        currentPositionen: null,
        graduateType: null,
        personnelContact: null,
        personnelContacten: null,
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
    /** 查询人员详情列表 */
    getList() {
      this.loading = true;
      listPersonnel(this.queryParams).then(response => {
        this.personnelList = response.rows;
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
        personnelId: null,
        personnelType: null,
        fileId: null,
        personnelName: null,
        personnelNameen: null,
        personnelIntroduce: null,
        personnelIntroduceen: null,
        personnelAddress: null,
        personnelAddressen: null,
        telNumber: null,
        faxNumber: null,
        email: null,
        twitter: null,
        linkedin: null,
        personnelDate: null,
        currentPosition: null,
        currentPositionen: null,
        graduateType: null,
        personnelContact: null,
        personnelContacten: null,
        createTime: null,
        createBy: null,
        updateBy: null,
        updateTime: null,
        delFlag: null
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
      this.ids = selection.map(item => item.personnelId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加人员详情";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const personnelId = row.personnelId || this.ids
      getPersonnel(personnelId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改人员详情";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.personnelId != null) {
            updatePersonnel(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPersonnel(this.form).then(response => {
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
      const personnelIds = row.personnelId || this.ids;
      this.$modal.confirm('是否确认删除人员详情编号为"' + personnelIds + '"的数据项？').then(function() {
        return delPersonnel(personnelIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/personnel/export', {
        ...this.queryParams
      }, `personnel_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
