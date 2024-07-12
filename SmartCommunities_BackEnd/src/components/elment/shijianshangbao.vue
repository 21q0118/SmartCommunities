<template>
  <div class="things">
    <el-form :model="form" label-width="120px" label-position="left" @submit.prevent>
      <el-form-item label="事件描述">
        <el-input v-model="form.desc" type="textarea" autosize="true"/>
      </el-form-item>
      <el-form-item label="视频图片上传">
        <el-upload
            class="upload-demo"
            drag
            action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
            multiple
        >
          <el-icon class="el-icon--upload"><upload-filled /></el-icon>
          <div class="el-upload__text">
            拖拽至此或者 <em>点击上传</em>
          </div>
          <template #tip>
            <div class="el-upload__tip">
              jpg/png/mp4文件小于500kb
            </div>
          </template>
        </el-upload>
      </el-form-item>
      <el-form-item style="margin: 0 auto">
        <div class="button">
          <el-button type="primary" @click="onSubmit">提交</el-button>
          <el-button>取消</el-button>
        </div>
      </el-form-item>
    </el-form>
  </div>

</template>

<style scoped>
.things{
  margin-left: 200px;
  margin-top: 50px;
}
</style>

<script lang="ts" setup>
import { reactive } from 'vue'
import { UploadFilled } from '@element-plus/icons-vue'

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