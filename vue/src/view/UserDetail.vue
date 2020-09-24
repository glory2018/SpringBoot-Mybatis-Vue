<template>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu :default-openeds="['1', '2']">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-message"></i>用户管理
          </template>
          <router-link :to="'/user'">
            <el-menu-item index="1-1">用户列表</el-menu-item>
          </router-link>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-menu"></i>系统管理
          </template>
        </el-submenu>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>王小虎</span>
      </el-header>
      <el-main>
        <el-form
          :model="user"
          status-icon
          :rules="rules"
          ref="user"
          label-width="100px"
          class="demo-user"
        >
          <el-form-item label="名称">
            <el-input v-model="user.name"></el-input>
          </el-form-item>
          <el-form-item label="账号">
            <el-input v-model="user.username"></el-input>
          </el-form-item>
          <el-form-item label="地址">
            <el-input v-model="user.address"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('user')">提交</el-button>
            <el-button @click="resetForm('user')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-main>
    </el-container>
  </el-container>
</template>
<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}
.el-aside {
  color: #333;
}
</style>
<script>
export default {
  name: 'UserDetail',
  data () {
    return {
      user: {
        id: '',
        name: '',
        username: '',
        email: '',
        address: ''
      }
    }
  },
  methods: {
    getUser () {
      const userId = this.$route.query.id
      const _this = this
      this.$axios.get('/user/detail/' + userId).then((res) => {
        _this.user = res.data.data
      })
    },
    submitForm (formName) {
      const _this = this
      this.$axios.post('/user/update', _this.user).then((res) => {
        if (res.data.code === 200) {
          _this.$alert('操作成功', '提示', {
            confirmButtonText: '确定',
            callback: action => {
              _this.$router.push('/user')
            }
          })
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
  },
  created () {
    this.getUser()
  }
}
</script>
