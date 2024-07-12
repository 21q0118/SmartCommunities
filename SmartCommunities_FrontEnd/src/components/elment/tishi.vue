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

#tishi {
  position: relative; /* 将图片设置为绝对定位 */
  top: 160px; /* 设置图片相对于父级顶部的偏移量为 12 像素 */
  left: 140px; /* 设置图片相对于父级左侧的偏移量为 0 */;
  width: 360px
}

#disan_juxing {
  width: 354px;
  height: 428px;
  background-color: rgb(209, 205, 232);
  border-radius: 10px;
  position: relative;
  top: -250px;
  left: 520px;
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

#fanhui {
  text-decoration: none;
  font-size: 17px;
  position: absolute;
  top: 48px;
  left: 280px;
  color: rgb(30, 152, 215);

}

.button {
  margin-top: 300px;
  margin-left: 140px;
  width: 100px;
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
    <img id="tishi" alt="aixin"
         src="../icons/jinya.png">


    <div id="disan_juxing">
      <div id="Log_in">OOPS!!!</div>
      <div id="denglu" style="position: absolute;top: 140px;left: 120px">您的账户</div>
      <div id="denglu" style="position: absolute;top: 180px;left: 60px">还未通过实名认证！</div>
      <router-link to="./renzheng">
        <el-button class="button chage">实名认证</el-button>
      </router-link>
      <a id="fanhui" href="注册地址">返回登录</a>

      <!--以下是登录表单-->
      <!--此处错误可忽略-->

      <!--以上是登录表单-->
    </div>
  </div>
  </body>
</template>


<script lang="ts" setup>
import {reactive, ref} from 'vue'
import type {FormInstance, FormRules} from 'element-plus'

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
  zhanghao: '',
  password: ''
})
const checkName = (rule: any, value: any, callback: any) => {
  if (!value) {
    return callback(new Error('请输入姓名'))
  }
  setTimeout(() => {
    if (Number.isInteger(parseInt(value))) {
      callback(new Error('禁止输入数字'))
    } else {
      callback()
    }
  }, 1000)
}

const validatePass = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('请输入密码'))
  } else {
    if (ruleForm.password !== '') {
      if (!ruleFormRef.value) return
      ruleFormRef.value.validateField('password', () => null)
    }
    callback()
  }
}
const rules = reactive<FormRules<typeof ruleForm>>({
  password: [{required: true, validator: validatePass, trigger: 'blur'}],
  zhanghao: [{required: true, validator: checkName, trigger: 'blur'}]
})


const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      console.log('submit!')
    } else {
      console.log('error submit!', fields)
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}
</script>
