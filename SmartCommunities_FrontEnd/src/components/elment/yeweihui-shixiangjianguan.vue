<template>
  <div class="search">
    <el-input v-model="input" placeholder="输入查询事项"/>
    <div class="search-button">
      <el-button :icon="Search" circle/>
    </div>
  </div>
  <div class="table">
    <el-table :data="tableData" max-height="1100px" style="width: 1100px" :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ 'text-align': 'center' }">
      <el-table-column label="问题编号" prop="id" width="100"/>
      <el-table-column label="类型" prop="type" width="150"/>
      <el-table-column label="上报时间" prop="time" width="180"/>
      <el-table-column label="上报对象" prop="target" width="180"/>
      <el-table-column label="问题描述" prop="description" width="200"/>
      <el-table-column label="处理状态" prop="state" width="180"/>
      <el-table-column label="操作" prop="handle" width="100">
        <template v-slot="scope">
          <el-button :icon="Check" circle="false" type="success" @click="remind"/>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped>
.search {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-left: 150px;
  margin-top: 30px;
}

.search-button {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-left: 5px;
}

.table {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-left: 150px;
  margin-top: 50px;
}
</style>

<script lang="ts" setup>
import {ref} from 'vue'
import {Check, Search,} from '@element-plus/icons-vue'

const input = ref('')

const tableData = [
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  }, {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
  {
    id: "2021215139",
    type: "水电",
    time: "6-23",
    target: "物业管理",
    description: "水压不够",
    state: "未处理",
  },
]
</script>
<script lang="ts">
export default {
  methods: {
    remind() {
      console.log("查询")
    }
  },
  data() {
    return {}
  }
}
</script>
