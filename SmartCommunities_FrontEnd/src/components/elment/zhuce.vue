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

#xiaonian {
//position: absolute; /* 将图片设置为绝对定位 */ //top: 310px; /* 设置图片相对于父级顶部的偏移量为 12 像素 */ //left: 400px; /* 设置图片相对于父级左侧的偏移量为 0 */; width: 360px; //justify-content: center; position: relative; left: 120px; top: 120px;

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


</style>
<template>
  <body id="body">

  <div id="dier_zhuxing">
    <img id="xiaonian" alt="xiaonian"
         src="../icons/xiaonian.png">
    <div id="disan_juxing">
      <div id="Log_in">Register to the system</div>
      <div id="denglu">注册</div>
      <!--      <a href="注册地址" id="zhuce" style="color: #1E98D7;margin-left: 12px">登录</a>-->
      <!--      <button @click="goToDenglu" style="color: #1E98D7;margin-left: 12px">登录呀</button>-->
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

        <el-form-item label="账号" prop="PHnum" style="margin-left: 24px">
          <el-input v-model="ruleForm.PHnum" placeholder="请输入手机号" style="width: 265px;height: 39px"/>
        </el-form-item>
        <el-form-item label="密码" prop="Ppword" style="margin-top: 35px;margin-left: 24px">
          <el-input v-model="ruleForm.Ppword"
                    autocomplete="on"
                    placeholder="请输入密码"
                    show-password style="width: 265px;height: 39px;" type="password"/>
        </el-form-item>
        <el-form-item label="确认密码" prop="Ppword_again" style="margin-top: 35px;margin-left: 24px">
          <el-input v-model="ruleForm.Ppword_again"
                    placeholder="请再次输入密码"
                    show-password
                    style="width: 265px;height: 39px" type="password"/>
        </el-form-item>
        <el-form-item>
          <!--            <el-button class="button chage" @click="submitForm(ruleFormRef)">-->
          <el-button class="button chage" @click="submitForm(ruleFormRef)">
            注册
          </el-button>

        </el-form-item>
      </el-form>
      <!--以上是登录表单-->
    </div>
  </div>
  </body>
</template>


<script lang="ts" setup>
import axios from "axios";
import {useRouter} from "vue-router";

const router = useRouter();
////加密
import {sha256} from 'js-sha256';
//加密
//传输数据------------------------------------------

const enroll = async () => {
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
          console.log('正在响应拦截');
          // 在响应拦截器中处理响应数据或其他逻辑
          // response.data.username = '你好'; // 修改响应数据的 username 字段
          if(response.data.code==1){
            console.log("注册成功！")
            open1();
            router.push('/');
          }
          if(response.data.code==2){
            open3()
            console.log("该号码已注册！")
          }
          return response;
        },
        error => {
          // if (error.response.status === 401)
          console.error('登录过期，请重新登录！', error);
          return Promise.reject(error);
        }
    );
    // 发送POST请求
    const data = {
      phnum:ruleForm.PHnum,
      ppword: ruleForm.Ppword
    };
    // 发送请求
    await axios.post('api/enroll',
        JSON.stringify(data),{headers: {
            // Authorization: `Bearer ${store.state.token}`,
            'Content-Type': 'application/json'
          }})
        .then(response => {
          console.log(response.data); // 输出经过响应拦截器处理后的数据
          console.log("num:", data.phnum);
          console.log("password:",data.ppword);
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
//提示框--------------------------------------------
const open1 = () => {
  ElMessage({
    showClose: true,
    message: '注册成功',
    type: 'success',
    duration:1500
  })
}

const open3 = () => {
  ElMessage({
    showClose: true,
    message: '该账号已被注册',
    type: 'error',
  })
}
//提示框--------------------------------------------
import {reactive, ref} from 'vue'
import type {FormInstance, FormRules} from 'element-plus'
import {ElMessage} from "element-plus";


interface RuleForm {
  PHnum: string,
  Ppword: string,
  password_again: string

}

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()

const ruleForm = reactive({
  PHnum: '',//账号（手机号）
  Ppword: '',//密码
  Ppword_again: '',//再次输入的密码
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
const validatePass2 = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('请再次输入密码'))
  } else if (value !== ruleForm.Ppword) {
    callback(new Error("两次输入不一致!"))
  } else {
    callback()
  }
}
const rules = reactive<FormRules<typeof ruleForm>>({
  Ppword: [{required: true, validator: validatePass, trigger: 'blur'}],
  Ppword_again: [{required: true, validator: validatePass2, trigger: 'blur'}],
  PHnum: [{required: true, validator: checkPHnum, trigger: 'blur'}],
})

const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {//检查表单，如果表单输入符合规范
      console.log('submit!')
      enroll();
    } else {//如果表单输入不符合规范
      console.log('error submit!', fields)
    }
  })
}


</script>
