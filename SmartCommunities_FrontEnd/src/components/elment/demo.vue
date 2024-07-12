<template>
  <div>
    <el-upload
        action="/your-upload-url"
        :before-upload="beforeUpload"
        :on-success="handleSuccess"
        :file-list="fileList"
        :limit="1"
        :on-change="hello"
        :auto-upload="false"
        :show-file-list="false"
    >
      <el-button type="primary">点击上传图片</el-button>
    </el-upload>
  </div>
</template>

<script>
import {ref, onMounted} from 'vue';
import {ElUpload} from 'element-plus';
// import 'element-plus/lib/theme-chalk/index.css';
// import toBase64 from './sd.js'
import axios from "axios";

export default {
  // components: {
  //   ElUpload,
  // },
  setup() {

    const fileList = ref([]);

    const beforeUpload = (file) => {
      // 可以在这里对文件进行一些校验，例如文件类型、大小等
      // 返回 false 可以阻止文件上传
      // console.log('上传前的文件:', file);
    };

    const handleSuccess = (response, file) => {
      const imageUrl = response.data.imageUrl;
      console.log('图片 URL:', imageUrl);

    };
    const hello = (file) => {
      let reader = new FileReader();
      let fileResult = "";
      reader.readAsDataURL(file.raw);
      reader.onload = function () {
        fileResult = reader.result;
        console.log(fileResult)
        axios.post('https://aip.baidubce.com/rest/2.0/ocr/v1/idcard?access_token=24.4c4ca5b5013d5918c0e416c0a3efe623.2592000.1690710894.282335-35514765',
            {
              'image': fileResult,
              'id_card_side': 'front'
            },
            {
              headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
              }
            }
        ).then(res => {
          console.log(res)
          res.data.image_status
          console.log(res.data.image_status
          )
          console.log('姓名:', res.data.words_result['姓名'].words);
          console.log('性别:', res.data.words_result['性别'].words
          );
          console.log('身份证号:', res.data.words_result['公民身份号码'].words
          );
        });
      }
      onMounted(() => {
        // 组件挂载后的操作
      });


    }
    return {
      fileList,
      AddSubmenuData: '',
      beforeUpload,
      handleSuccess,
      hello,
    };
  }
}
</script>
