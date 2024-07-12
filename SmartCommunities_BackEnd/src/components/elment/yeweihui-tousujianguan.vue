<template>
  <div class="search">
    <el-input v-model="input" placeholder="输入查询投诉"/>
    <div class="search-button">
      <el-button :icon="Search" circle/>
    </div>
  </div>
  <div class="table">
    <el-table :data="tableData" height="600px" style="width: 2000px" :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ 'text-align': 'center' }">
      <el-table-column label="投诉名称" prop="name" width="600"/>
      <el-table-column label="诉求内容" prop="description" width="600"/>
      <el-table-column label="操作" prop="handle" width="200">
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
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },
  {
    name: "物业监管",
    description: "物业处置不到位",
  },


]
</script>
<script lang="ts">
export default {
  methods: {
    remind() {
      console.log("提醒")
    }
  },
  data() {
    return {}
  }
}
</script>
