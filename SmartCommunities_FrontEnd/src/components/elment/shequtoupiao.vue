<template>
  <div class="search">
    <el-input v-model="input" placeholder="输入查询投票"/>
    <div class="search-button">
      <el-button :icon="Search" circle/>
    </div>
  </div>
    <el-table :data="tableData" max-height="600px" style="width: 780px;margin-left: 600px" :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ 'text-align': 'center' }">
      <el-table-column label="项目名称" prop="id" width="100"/>
      <el-table-column label="结束时间" prop="time" width="500"/>
      <el-table-column label="操作" prop="handle" width="170">
        <el-button-group style="margin-left: -10px">
          <el-button type="success" size="small">赞成</el-button>
          <el-button type="danger" size="small">反对</el-button>
          <el-button type="warning" size="small">弃权</el-button>
        </el-button-group>
      </el-table-column>
    </el-table>
</template>
<style scoped>
.search {
  margin-left: 600px;
  margin-top: 30px;
  width: 730px;
}

.search-button {
  margin-left: 740px;
  margin-top: -32px;
}
</style>
<script setup>
import {Search} from "@element-plus/icons-vue";
const tableData=[
  {
    id:"广场建设",
    time:"2023-9-01 0:00"
  },
  {
    id:"广场建设",
    time:"2023-9-01 0:00"
  },
  {
    id:"广场建设",
    time:"2023-9-01 0:00"
  },
  {
    id:"广场建设",
    time:"2023-9-01 0:00"
  },
  {
    id:"广场建设",
    time:"2023-9-01 0:00"
  },
  {
    id:"广场建设",
    time:"2023-9-01 0:00"
  },
  {
    id:"广场建设",
    time:"2023-9-01 0:00"
  },
  {
    id:"广场建设",
    time:"2023-9-01 0:00"
  },
  {
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },{
    id:"广场建设",
    time:"2023-9-01 0:00"
  },
]
</script>