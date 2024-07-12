<style scoped>
.body {
  background: rgb(47, 25, 108);
  height: 100vh; /* 设置为视口的100%高度 */
  margin: 0; /* 去除默认的外边距 */;
  display: flex;
  justify-content: center;
  align-items: center;
}

.rectangle_1 {
  width: 900px;
  height: 550px;
  background-color: rgb(157, 149, 209);
  border-radius: 10px
}

.img {
//position: absolute; /* 将图片设置为绝对定位 */ //top: 310px; /* 设置图片相对于父级顶部的偏移量为 12 像素 */ //left: 400px; /* 设置图片相对于父级左侧的偏移量为 0 */; width: 360px; position: relative; left: 120px; top: 120px;
}

.rectangle_2 {
  width: 354px;
  height: 428px;
  background-color: rgb(209, 205, 232);
  border-radius: 10px;
//position: absolute; //top: 220px; //left: 788px; position: relative; left: 500px; top: -260px;
}

.log_in {
  font-size: 24px;
  position: absolute;
  top: 40px;
  left: 32px
}

.login {
  font-size: 32px;
  position: absolute;
  top: 80px;
  left: 32px
}

.sign_up {
  text-decoration: none;
  font-size: 17px;
  position: absolute;
  top: 48px;
  left: 290px;
  color: rgb(30, 152, 215)
}

#el_form {
  margin-top: 180px;
  position: absolute;
  left: -65px
}

.button {
  margin-top: 20px;
  margin-left: 2px;
  width: 100px;
  color: white;
  background-color: #333333;
}

.chage:hover {
  background-color: #9D95D1;
}
</style>
<template>
  <div class="body">
    <div class="rectangle_1 ">
      <img class="img" alt="登录图片"
           src="../icons/login.png">


      <div class="rectangle_2">
        <div class="log_in">Log in to the system</div>
        <div class="login">登录</div>
        <router-link class="sign_up" to="/register">注册</router-link>
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
          <el-form-item label="账号" prop="PHnum">
            <el-input v-model="ruleForm.PHnum" placeholder="请输入账号" style="width: 290px;height: 39px"/>
          </el-form-item>
          <el-form-item label="密码" prop="Ppword" style="margin-top: 35px">
            <el-input v-model="ruleForm.Ppword"
                      placeholder="请输入密码"
                      show-password
                      style="width: 290px;height: 39px" type="password"/>
          </el-form-item>
          <el-form-item>


            <el-button class="button chage" @click="submitForm(ruleFormRef)">

              登录
            </el-button>

            <!--      <el-button @click="resetForm(ruleFormRef)">重置</el-button>-->
<!--            <a href="忘记密码的链接地址" style="color: rgb(30,152,215);margin-left: 80px">忘记密码？</a>-->

          </el-form-item>
        </el-form
        >
        <!--以上是登录表单-->
      </div>
    </div>
  </div>
</template>


<script lang="ts" setup>
onMounted(() => {
  console.log('清除缓存！');
  localStorage.clear();//每次清楚token缓存

});
//加密

import {sha256} from 'js-sha256';
//加密
//使用仓库------------------
import { useStore } from 'vuex';
const store = useStore();
//使用仓库--------------
//传输数据------------------------------------------
import axios from "axios";
import {useRouter} from "vue-router";
const router = useRouter();

const login = async () => {
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
          if(response.data.code==1){
            console.log("登录成功！")
            store.dispatch('car_re', response);
            router.push('/cebian');
            open1();
            console.log("token-->",store.state.token)

          }
          if(response.data.code==2){
            // store.dispatch('car_re', response);
            open3()
            console.log("未注册！")
          }
          if(response.data.code==3){
            store.dispatch('car_re', response);
            open2()
            console.log("未实名！")
            router.push('/tishi');
          }
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
      phnum:ruleForm.PHnum,
      ppword:ruleForm.Ppword
    };
    // 发送请求
    await axios.post('api/login',
        JSON.stringify(data),{headers: {
            // Authorization: `Bearer ${store.state.token}`,//令牌
            'Content-Type': 'application/json'
          }})
        .then(response => {
          // console.log("data:",response.data); // 输出经过响应拦截器处理后的数据
          // console.log("发送的数据：",data); // 输出经过响应拦截器处理后的数据
          // console.log("headers:",response.headers); // 输出经过响应拦截器处理后的数据
          console.log("仓库获取的token(then):",store.state.token); // 输出经过响应拦截器处理后的数据
        })
        .catch(error => {
          console.log("仓库获取的token(error):",store.state.token); // 输出经过响应拦截器处理后的数据
          console.error('请求出错', error);
        });
  } catch (error) {
    // 处理请求错误逻辑
    console.error(error);
  }
};
//传输数据-----------------------------------------
//提示框-------------------
import { ElMessage } from 'element-plus'
const open1 = () => {
  ElMessage({
    showClose: true,
    message: '登录成功',
    type: 'success',
    duration:1500
  })
}
const open2 = () => {
  ElMessage({
    showClose: true,
    message: '未实名',
    type: 'warning',
  })
}
const open3 = () => {
  ElMessage({
    showClose: true,
    message: '未注册',
    type: 'error',
  })
}
//提示框-----------------------------

import {onMounted, reactive, ref} from 'vue'
import type {FormInstance, FormRules} from 'element-plus'

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
  PHnum: '',
  Ppword: ''
})


const checkPHnum = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('请输入手机号'))
  } else {
    if (ruleForm.Ppword !== '') {
      if (!ruleFormRef.value) return
      ruleFormRef.value.validateField('PHnum', () => null)
    }
    callback()
  }
}
const validatePass = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('请输入密码'))
  } else {
    if (ruleForm.Ppword !== '') {
      if (!ruleFormRef.value) return
      ruleFormRef.value.validateField('Ppword', () => null)
    }
    callback()
  }
}
const rules = reactive<FormRules<typeof ruleForm>>({

  PHnum: [{required: true, validator: checkPHnum, trigger: 'blur'}],
  Ppword: [{required: true, validator: validatePass, trigger: 'blur'}]
})


const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      login();
    } else {
      console.log('error submit!', fields)
    }
  })
}
</script>
