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

#jinya {
//position: absolute; /* 将图片设置为绝对定位 */ //top: 310px; /* 设置图片相对于父级顶部的偏移量为 12 像素 */ //left: 400px; /* 设置图片相对于父级左侧的偏移量为 0 */; width: 360px;
  position: relative;
  left: 120px;
  top: 120px;

}

#disan_juxing {
  width: 354px;
  height: 428px;
  background-color: rgb(209, 205, 232);
  border-radius: 10px;
//position: absolute;top: 220px; left: 788px; position: relative;
  left: 500px;
  top: -260px;
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
    <img id="jinya" alt="aixin"
         src="../icons/jinya.png">


    <div id="disan_juxing">
      <div id="Log_in">OOPS!!!</div>
      <div id="denglu" style="position: absolute;top: 140px;left: 120px">认证失败！</div>
      <el-button class="button chage">返回</el-button>


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

</script>
