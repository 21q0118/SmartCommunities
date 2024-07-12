<template>
  <div class="table">
    <el-table :data="tableData" max-height="600px" style="width: 1200px" :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ 'text-align': 'center' }">
      <el-table-column label="车牌号" prop="carid" width="200%"/>
      <el-table-column label="车位号" prop="parkingid" width="200%"/>
      <el-table-column label="房屋号" prop="houseid" width="200%"/>
      <el-table-column label="车位操作" prop="carhandle" width="300%">
      <template v-slot="scope">
        <el-button type="success" size="small">增加</el-button>
        <el-button type="danger" size="small">删除</el-button>
      </template>
        </el-table-column>
      <el-table-column label="房屋操作" prop="househanlde" width="300%">
        <template v-slot="scope">
          <el-button type="success" size="small">增加</el-button>
          <el-button type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped>
.table {
  margin-top: 50px;
}
</style>

<script lang="ts" setup>
import {ref} from 'vue'

const input = ref('')

const tableData = [
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
  {
    carid:"鲁K·7X698",
    parkingid:"B16",
    houseid:"北413"
  },
]
</script>
<script lang="ts">
export default {
  methods: {
  },
  data() {
    return {}
  }
}
</script>
