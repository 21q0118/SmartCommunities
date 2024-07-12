<template>
  <el-button text @click="dialogVisible = true">
    打开对话框
  </el-button>

  <el-dialog
      v-model="dialogVisible"
      title="您有新的家庭邀请"
      width="30%"
      :before-close="handleClose"
      :center="true"
      :align-center="true"
  >
        <el-table :data="tableData"
                  :cell-style="{ textAlign: 'center' }"
                  :header-cell-style="{ 'text-align': 'center' }"
                  max-height="250" style="width: 120px;margin: 0 auto"
        >
          <el-table-column prop="name" label="家庭成员姓名" width="120px" />
        </el-table>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">拒绝并关闭</el-button>
        <el-button type="primary" @click="dialogVisible = false">
          接受
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped>

.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>

<script lang="ts" setup>
import { reactive } from 'vue'

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
import { ref } from 'vue'
import { ElMessageBox } from 'element-plus'

const dialogVisible = ref(false)

const handleClose = (done: () => void) => {
  ElMessageBox.confirm('确定关闭该对话框？')
      .then(() => {
        done()
      })
      .catch(() => {
        // catch error
      })
}

const tableData = [
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },{
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
  {
    name:"qkx"
  },
]
</script>

