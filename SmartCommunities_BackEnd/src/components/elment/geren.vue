<style scoped>
#body {
  background: rgb(47, 25, 108);
  height: 100vh; /* 设置为视口的100%高度 */
  margin: 0; /* 去除默认的外边距 */;
  display: flex;
  justify-content: center;
  align-items: center;
}

.button {
  width: 100px;
  color: white;
  background-color: #333333;
}

.chage:hover {
  background-color: #9D95D1;
}

.circle-container {
  width: 200px; /* 设置容器的宽度 */
  height: 200px; /* 设置容器的高度 */
  border-radius: 50%; /* 将容器的边框角设置为圆形 */
  overflow: hidden; /* 隐藏溢出容器的内容 */
  border: 2px solid #9D95D1;
}

#dier_juxin {
  background-color: #F2F2F2;
  position: relative;
  top: -58px;
  width: 684px;
  height: 733px;
  border-radius: 15px
}
</style>
<template>
  <body id="body">
  <div id="dier_juxin">
    <el-button class="button chage" style="margin-left: 24px;margin-top: 28px">
      &lt;返回
    </el-button>
    <div style="font-size: 30px;margin-left: 24px;margin-top: 30px">个人中心</div>


    <el-form
        id="el_form"
        ref="ruleFormRef"
        :model="ruleForm"
        :size="formSize"
        class="demo-ruleForm"
        label-width="120px"
        status-icon
        disabled="true"
    >
      <el-form-item label="姓名" prop="name" disabled="true" style="margin-top: 50px;margin-left: -36px">
        <el-input v-model="ruleForm.name" placeholder="请输入姓名" style="width: 265px;height: 39px"/>
      </el-form-item>
      <el-form-item label="手机号" prop="phone" style="margin-top: 50px;margin-left: -36px">
        <el-input v-model="ruleForm.phone"
                  placeholder="请输入身份证号"
                  style="width: 265px;height: 39px"/>
      </el-form-item>
      <el-form-item label="家庭" prop="family" style="margin-top: 50px;margin-left: -36px">
        <el-input v-model="ruleForm.family" placeholder="请输入姓名" style="width: 265px;height: 39px"/>
      </el-form-item>
      <el-form-item label="身份证号" prop="id" style="margin-top: 50px;margin-left: -36px">
        <el-input v-model="ruleForm.id"
                  placeholder="请输入身份证号"
                  show-password
                  style="width: 265px;height: 39px" type="password"/>
      </el-form-item>
      <el-form-item label="性别" prop="sex" style="margin-top: 50px;margin-left: -36px">
        <el-select v-model="ruleForm.sex" placeholder="性别" style="width: 90px">
          <el-option label="男" value="1"/>
          <el-option label="女" value="2"/>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button class="button chage" style="margin-top: 50px;margin-left: -36px" @click="submitForm(ruleFormRef)">
          更新基本信息
        </el-button>
      </el-form-item>

      <el-button class="button chage" style="position: absolute;top: 320px;left: 475px"
                 @click="submitForm(ruleFormRef)">
        更新头像
      </el-button>
      <el-button class="button chage" style="position: absolute;top: 380px;left: 462px"
                 @click="submitForm(ruleFormRef)">
        密码
      </el-button>


    </el-form>


    <img alt="我的图片" class="circle-container" src="../icons/heshui.jpg"
         style="width:200px;position:absolute;left: 420px;top: 105px">
  </div>

  </body>
</template>


<script lang="ts" setup>
// import {onMounted} from "vue/dist/vue";
const data_null = {
  pname: null,
  sex: null,
  idnum: null
};
onMounted(() => {
  axios.post('api/secure/perInfo',
      JSON.stringify(data_null), {
        headers: {
          Authorization:store.state.token,
          'Content-Type': 'application/json'
        }
      })
      .then(response => {
        ruleForm.name=response.data.PName;
        ruleForm.sex=response.data.Sex;
        ruleForm.family=response.data.FID;
        ruleForm.phone=response.data.PHnum;;
        ruleForm.id=response.data.IDnum;;
      })
      .catch(error => {
        console.error('请求出错', error);
      });
});
//--------------------------
import axios from "axios";
import {useRouter} from "vue-router";
import { useStore } from 'vuex';
const store = useStore();
const router = useRouter();
import {onMounted, reactive, ref} from 'vue'
import type {FormInstance, FormRules} from 'element-plus'
import {sha256} from "js-sha256";

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
  name: '',
  sex: '',
  id: '',
  phone: '',
  family: ''
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

</script>
