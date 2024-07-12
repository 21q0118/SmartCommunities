<template>
  <div class="pc">
    <svg t="1688052242101" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1626" width="200" height="200"><path d="M512 96c229.76 0 416 186.24 416 416s-186.24 416-416 416S96 741.76 96 512 282.24 96 512 96z m0 64C317.6 160 160 317.6 160 512s157.6 352 352 352 352-157.6 352-352S706.4 160 512 160z m32 480v96h-64v-96h64z m0-352v288h-64V288h64z" fill="#383F4A" p-id="1627"></path></svg>
  </div>
  <div class="wenzi">
    <label>您当前尚未加入任何家庭</label>
  </div>
  <div class="drwaerBtn">
    <el-button type="primary" @click="drawer = true">
      点此创建
    </el-button>
  </div>

  <el-drawer v-model="drawer" title="创建家庭" :with-header="true" direction="btt" size="500">
    <el-form :model="form" label-width="120px" label-position="left">
      <el-form-item label="家庭名称">
        <el-input v-model="form.name" placeholder="输入家庭名称"/>
      </el-form-item>
      <el-form-item label="家庭编号">
        <el-input v-model="form.id" placeholder="无需输入创建完毕后自动显示" disabled/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </el-drawer>
</template>
<style scoped>
.pc{
  display: flex;
  justify-content: center;
  align-items: center;
}
.wenzi{
  display: flex;
  justify-content: center;
  align-items: center;
}
.drwaerBtn{
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 50px;
}
</style>
<script setup>
import { reactive } from 'vue'
import { ref } from 'vue'
const drawer = ref(false)
const form = reactive({
  name: '',
  id:''
})

const onSubmit = () => {
  console.log('submit!')
}
</script>

