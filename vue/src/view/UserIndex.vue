<template>
<div class="m-container">
    <Header></Header>
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
        <el-main>
          <el-table :data="tableData">
            <el-table-column prop="createdate" label="日期" width="140"></el-table-column>
            <el-table-column prop="name" label="姓名" width="120"></el-table-column>
            <el-table-column prop="address" label="地址"></el-table-column>
            <el-table-column fixed="right" label="操作" width="100">
              <template slot-scope="scope">
                <el-button @click="handleClick(e, scope)" type="text" size="small">查看</el-button>
                <el-button @click="handleClick(e, scope)" type="text" size="small">编辑</el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-pagination class="mpage"
            background
            layout="prev, pager, next"
            :current-page=pageNum
            :page-size=pageSize
            @current-change=page
            :total="total">
          </el-pagination>
        </el-main>
      </el-container>
    </el-container>
</div>
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
import Header from '../components/Header'
export default {
  name: 'UserIndex',
  components: {Header},
  data () {
    return {
      tableData: [],
      pageNum: 1,
      total: 0,
      pageSize: 5
    }
  },
  mounted () {
    this.page(1)
  },
  methods: {
    page (pageNum) {
      const _this = this
      this.$axios.get('/user/list?pageNum=' + pageNum).then((res) => {
        _this.tableData = res.data.data.list
        _this.pageNum = res.data.data.pageNum
        _this.total = res.data.data.total
        _this.pageSize = res.data.data.pageSize
      })
    },
    handleClick (e, scope) {
      this.$router.push({ path: '/userDetail', query: { id: scope.row.id } })
    }
  }
}
</script>
