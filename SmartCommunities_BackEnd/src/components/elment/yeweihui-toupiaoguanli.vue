<template>
  <div class="search">
    <el-input v-model="input" placeholder="输入查询投票"/>
    <div class="search-button">
      <el-button :icon="Search" circle/>
    </div>
    <div class="add-button">
      <el-button style="margin-left: 5px" type="primary" @click="drawer = true">
        新增
      </el-button>
    </div>
  </div>
  <div class="table">
    <el-table :data="tableData" height="600px" style="width: 2000px" :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ 'text-align': 'center' }">
      <el-table-column label="投票编号" prop="id" width="400"/>
      <el-table-column label="投票类型" prop="type" width="400"/>
      <el-table-column label="流程状态" prop="state" width="400"/>
      <el-table-column label="投票结果" prop="result" width="400"/>
    </el-table>
  </div>
  <el-drawer v-model="drawer" :with-header="true" title="投票项目创建">
    <el-form :model="form" label-width="120px">
      <el-form-item label="项目名称">
        <el-input v-model="form.name"/>
      </el-form-item>
      <el-form-item label="支出缘由">
        <el-input v-model="form.name"/>
      </el-form-item>
      <el-form-item label="支出费用">
        <el-input v-model="form.name"/>
      </el-form-item>
      <el-form-item label="支出时间">
        <el-col :span="11">
          <el-date-picker
              v-model="form.date1"
              placeholder="选择日期"
              style="width: 100%"
              type="date"
          />
        </el-col>
        <el-col :span="2" class="text-center">
          <span class="text-gray-500">-</span>
        </el-col>
        <el-col :span="11">
          <el-time-picker
              v-model="form.date2"
              placeholder="选择时间"
              style="width: 100%"
          />
        </el-col>
      </el-form-item>
      <el-form-item label="开始时间">
        <el-col :span="11">
          <el-date-picker
              v-model="form.date1"
              placeholder="选择日期"
              style="width: 100%"
              type="date"
          />
        </el-col>
        <el-col :span="2" class="text-center">
          <span class="text-gray-500">-</span>
        </el-col>
        <el-col :span="11">
          <el-time-picker
              v-model="form.date2"
              placeholder="选择时间"
              style="width: 100%"
          />
        </el-col>
      </el-form-item>
      <el-form-item label="投票类型">
        <el-radio-group v-model="form.type">
          <el-radio label="公共器材" name="type"/>
          <el-radio label="水电" name="type"/>
          <el-radio label="道路" name="type"/>
          <el-radio label="建设" name="type"/>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="是否公开">
        <el-radio-group v-model="form.resource">
          <el-radio label="公开"/>
          <el-radio label="私有"/>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="form.desc" type="textarea"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </el-drawer>
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

.add-button {
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
import {reactive, ref} from 'vue'
import {Search,} from '@element-plus/icons-vue'

const input = ref('')
const drawer = ref(false)

const tableData = [
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },
  {
    id: "2021215139",
    type: "公共器材",
    state: "进行中",
    result: "通过",
  },


]

// do not use same name with ref
const form = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: '',
})

const onSubmit = () => {
  console.log('submit!')
}
</script>
<script lang="ts">
export default {
  methods: {
    add() {
      console.log("增加")
    }
  },
  data() {
    return {}
  }
}
</script>
