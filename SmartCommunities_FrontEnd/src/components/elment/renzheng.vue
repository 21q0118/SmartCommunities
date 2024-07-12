<style scoped>
#body {
  background: rgb(47, 25, 108);
  height: 100vh; /* 设置为视口的100%高度 */
  margin: 0; /* 去除默认的外边距 */;
  display: flex;
  justify-content: center;
  align-items: center;
}

#dier_zhuxing {
  width: 900px;
  height: 550px;
  background-color: rgb(157, 149, 209);
  border-radius: 10px
}

#dayan {
//position: absolute; /* 将图片设置为绝对定位 */ //top: 310px; /* 设置图片相对于父级顶部的偏移量为 12 像素 */ //left: 400px; /* 设置图片相对于父级左侧的偏移量为 0 */; width: 360px; position: relative; left: 120px; top: 120px;
}

#disan_juxing {
  width: 354px;
  height: 452px;
  background-color: rgb(209, 205, 232);
  border-radius: 10px;
//position: absolute; //top: 220px; //left: 788px; position: relative; left: 500px; top: -260px;
}

#Log_in {
  font-size: 24px;
  position: absolute;
  top: 40px;
  left: 32px
}

#denglu {
  font-size: 32px;
  position: absolute;
  top: 80px;
  left: 32px
}

#zhuce {
  text-decoration: none;
  font-size: 17px;
  position: absolute;
  top: 48px;
  left: 290px
}

#el_form {
  margin-top: 180px;
  position: absolute;
  left: -65px
}

.button {
  margin-top: 10px;
  width: 100px;
  margin-left: 22px;
  color: white;
  background-color: #333333;
}

.chage:hover {
  background-color: #9D95D1;
}

.button_shangchuan {
  background-color: #333333;
  color: white;
  position: absolute;
  top: 130px;
  left: 80px
}

</style>
<template>
  <body id="body">

  <div id="dier_zhuxing">
    <img id="dayan" alt="dayan"
         src="../icons/dayan.png">
    <div id="disan_juxing">
      <div id="Log_in">Authentication</div>
      <div id="denglu">实名认证</div>
      <!--认证-->
      <el-upload
          action="/your-upload-url"
          :before-upload="beforeUpload"
          :on-success="handleSuccess"
          :file-list="fileList"
          :limit="10"
          :on-change="hello"
          :auto-upload="false"
          :show-file-list="false"
      >
        <el-button class="button_shangchuan chage">
          上传身份证照片
        </el-button>
      </el-upload>


      <!--认证-->


      <a id="zhuce" href="返回地址" style="color: #1E98D7;margin-left: 12px">返回</a>
      <!--以下是登录表单-->
      <!--此处错误可忽略-->
      <el-form
          id="el_form"
          ref="ruleFormRef"
          :model="ruleForm"
          :rules="rules"
          :size="formSize"
          class="demo-ruleForm"
          label-width="120px"
          status-icon
      >
        <el-form-item label="姓名" prop="name" style="margin-left: 24px">
          <el-input v-model="ruleForm.name" placeholder="请输入姓名" style="width: 265px;height: 39px"/>
        </el-form-item>

        <el-form-item label="性别" prop="sex" style="margin-top: 35px;margin-left: 24px">
          <el-select v-model="ruleForm.sex" placeholder="选择性别" style="width: 265px">
            <el-option label="男" value="1"/>
            <el-option label="女" value="2"/>
          </el-select>
        </el-form-item>
        <el-form-item label="身份证号" prop="id" style="margin-top: 35px;margin-left: 24px">
          <el-input v-model="ruleForm.id"
                    placeholder="请输入身份证号"
                    style="width: 265px;height: 39px" />
        </el-form-item>
        <el-form-item>
          <el-button class="button chage" @click="submitForm(ruleFormRef)">
            认证
          </el-button>
        </el-form-item>
      </el-form>
      <!--以上是登录表单-->
    </div>
  </div>
  </body>
</template>
<script lang="ts" setup>
// const data_null = {
//   pname: null,
//   sex: null,
//   idnum: null
// };
// onMounted(() => {
//   console.log('组件已经挂载到 DOM');
//    axios.post('api/secure/real',
//       JSON.stringify(data_null), {
//         headers: {
//           // Authorization: store.state.token,//令牌
//           Authorization:store.state.token,
//           'Content-Type': 'application/json'
//         }
//       })
//       .then(response => {
//         console.log("data:",data)
//         console.log(response.data); // 输出经过响应拦截器处理后的数据
//       })
//       .catch(error => {
//         console.error('请求出错', error);
//       });
// });
//传输数据------------------------------------------
// import axios from "axios";
import {useRouter} from "vue-router";

const router = useRouter();
import { useStore } from 'vuex';
const store = useStore();
const authentication = async () => {
  try {
    // 请求拦截器：在请求发送之前拦截并处理请求数据
    axios.interceptors.request.use(
        config => {
          console.log('正在请求拦截');
          // 在请求拦截器中添加元数据或其他逻辑
          // config.headers['Authorization'] = 'Bearer token123'; // 添加令牌等元数据
          return config;
        },
        error => {
          console.error('请求拦截error！', error);
          return Promise.reject(error);
        }
    );
    //响应拦截器
    axios.interceptors.response.use(
        response => {
          if (response.data.code == 1) {
            console.log("认证成功！")
            open1();
            router.push('/');

            // store.dispatch('car_re', response);
            // console.log("token",store.state.token)

          }
          if (response.data.code == 2) {
            open3()
            console.log("认证失败！")
          }
          console.log(response.data)
          return response;
        },
        error => {
          // if (error.response.status === 401)
          console.error('error', error);
          return Promise.reject(error);
        }
    );
    // 发送POST请求
    const data = {
      pname: ruleForm.name,
      sex: ruleForm.sex,
      idnum: ruleForm.id
    };
    // 发送请求
    await axios.post('api/secure/real',
        JSON.stringify(data), {
          headers: {
            // Authorization: store.state.token,//令牌
            Authorization:store.state.token,
            'Content-Type': 'application/json'
          }
        })
        .then(response => {
          console.log("data:",data)
          console.log(response.data); // 输出经过响应拦截器处理后的数据
        })
        .catch(error => {
          console.error('请求出错', error);
        });
  } catch (error) {
    // 处理请求错误逻辑
    console.error(error);
  }
};
//传输数据-----------------------------------------
//认证接口------------------------------------
const open1 = () => {
  ElMessage({
    showClose: true,
    message: '认证成功！',
    type: 'success',
    duration:1500
  })
}
const open3 = () => {
  ElMessage({
    showClose: true,
    message: '认证失败，请重试！',
    type: 'error',
  })
}
import {ref, onMounted} from 'vue';
import {ElMessage, ElUpload} from 'element-plus';
import axios from "axios";

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
  let fileResult: string | ArrayBuffer = "";
  reader.readAsDataURL(file.raw);
  reader.onload = function () {
    // fileResult = reader.result;
    fileResult = reader.result;
    console.log(fileResult)
    axios.post('https://aip.baidubce.com/rest/2.0/ocr/v1/idcard?access_token=24.1748e49c22132a4bbadbc57f860913ca.2592000.1690715362.282335-35514765',
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
      ruleForm.name = res.data.words_result['姓名'].words;
      ruleForm.sex = res.data.words_result['性别'].words;
      ruleForm.id = res.data.words_result['公民身份号码'].words
    });
  }
  onMounted(() => {
    // 组件挂载后的操作
  });


}

//认证接口---------------------------------------
import {reactive} from 'vue'
import type {FormInstance, FormRules} from 'element-plus'
import {sha256} from "js-sha256";

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
  name: '',
  sex: '',
  id: '',
})

const checkName = (rule: any, value: any, callback: any) => {
  if (!value) {
    return callback(new Error('请输入姓名'))
  }
  if (Number.isInteger(parseInt(value))) {
    callback(new Error('禁止输入数字'))
  } else {
    callback()
  }

}

const checkSex = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('请选择性别'))
  } else {
    if (ruleForm.sex !== '') {
      if (!ruleFormRef.value) return
      ruleFormRef.value.validateField('sex', () => null)
    }
    callback()
  }
}
const checkId = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('请输入身份证号'))
  } else {
    if (ruleForm.id !== '') {
      if (!ruleFormRef.value) return
      ruleFormRef.value.validateField('id', () => null)
    }
    callback()
  }
}

const rules = reactive<FormRules<typeof ruleForm>>({
  name: [{required: true, validator: checkName, trigger: 'change'}],
  sex: [{required: true, validator: checkSex, trigger: 'change'}],
  id: [{required: true, validator: checkId, trigger: 'change'}],
})
const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      authentication()
      console.log('submit!')
    } else {
      console.log('error submit!', fields)
    }
  })
}
</script>
