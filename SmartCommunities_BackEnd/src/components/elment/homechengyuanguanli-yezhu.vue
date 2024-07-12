<template>
  <el-form :model="form" label-width="120px" label-position="left" @submit.prevent>
    <el-table :data="tableData"
              :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ 'text-align': 'center' }"
              max-height="600" style="width: 860px;"
    >
      <el-table-column prop="name" label="姓名" width="120px" />
      <el-table-column prop="phNumber" label="手机号码" width="220px" />
      <el-table-column prop="id" label="身份证号码" width="320px" />
      <el-table-column prop="birth" label="生日" width="120px" />
      <el-table-column prop="sex" label="性别" width="80px" />
    </el-table>
    <el-form-item>
      <el-button-group style="margin-left: 560px">
        <el-button type="success">邀请</el-button>
        <el-button type="warning">修改</el-button>
        <el-button type="danger">解散</el-button>
      </el-button-group>
    </el-form-item>
  </el-form>
</template>
<script setup>
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
const tableData=[
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },

  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },{
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },
  {
    name:"大哥大",
    phNumber:"15165889564",
    id:"985666322874415968",
    birth:"2003-01-18",
    sex:"男"
  },

]
</script>