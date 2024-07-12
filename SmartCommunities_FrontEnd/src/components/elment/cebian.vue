<style scoped>
#el_header {
  text-align: left;
  font-size: 32px;
  background-color: rgb(157, 149, 209);
  padding-top: 10px;
  padding-right: 12px
}

#xiangxiajiantou {
  font-size: 32px;
  margin-left: 8px;
  float: right;
  margin-top: 4px
}

#username {
  padding-left: 12px;
  float: right;
  font-size: 20px;
  margin-right: 10px;
  margin-top: 4px
}

#lingdang {
  font-size: 32px;
  margin-left: 8px;
  float: right;
  margin-top: 4px
}

#setting {
  font-size: 28px;
  margin-right: 10px;
  margin-top: 4px;
  float: right
}

#home {
  font-size: 25px;
  margin-top: 6px;
  margin-right: 6px
}

#family {
  font-size: 25px;
  margin-top: 6px;
  margin-right: 6px
}

#cheliang {
  font-size: 25px;
  margin-top: 6px;
  margin-right: 6px
}

#wenjuan {
  font-size: 25px;
  margin-top: 6px;
  margin-right: 6px
}

#toupiao {
  font-size: 25px;
  margin-top: 6px;
  margin-right: 6px
}
</style>


<template xmlns="">
  <div>
    <el-container style="height: 700px">
      <!--                    *****以下是头部*****         —-->
      <el-header id="el_header"><!--调整文字上边距-->
        <el-icon style="margin-right: 16px; margin-top: 4px;float: left">
          <img alt="图片描述" src="../icons/xiaohui.png" width="12000">
          <setting/>
        </el-icon>
        <span>XXX社区智能管理平台</span><!--调整文字左边距-->

        <i id="xiangxiajiantou" class="iconfont icon-xiangxiajiantou"></i>

        <span id="username">用户名</span><!--调整文字左边距-->
        <i id="lingdang" class="iconfont icon-lingdang"></i>

        <el-icon id="setting">
          <setting/>
        </el-icon>
      </el-header>
      <!--                    *****以上是头部*****         —-->

      <el-container><!--侧栏-->


        <!--                    *****以下是侧边栏*****         —-->
        <el-aside width="400px">
          <el-row>
            <el-col :span="11">
              <el-menu
                  background-color="#EEF2FE"
                  class="el-menu-vertical-demo"
                  default-active="1"
                  @close="handleClose"
                  @open="handleOpen"
              >
                <el-menu-item index="1" style="height: 90px">
                  <template #title><!--首页-->
                    <i id="home" class="iconfont icon-home"></i>
                    <span style="font-size: 22px;margin-top: 6px">首页</span>
                  </template>
                </el-menu-item>
                <el-menu-item index="2" style="margin-top: 30px;height: 90px"><!--家庭-->
                  <i id="family" class="iconfont icon-family"></i>

                  <span style="font-size: 22px;margin-top: 6px">家庭管理</span>
                </el-menu-item>
                <el-menu-item index="3" style="margin-top: 30px;height: 90px"><!--车辆-->
                  <i id="cheliang" class="iconfont icon-cheliang"></i>
                  <span style="font-size: 22px;margin-top: 6px">车辆管理</span>
                </el-menu-item>
                <el-menu-item index="4" style="margin-top: 30px;height: 90px"><!--问题-->
                  <i id="wenjuan" class="iconfont icon-wenjuan"></i>
                  <span style="font-size: 22px;margin-top: 6px">问题上报</span>
                </el-menu-item>
                <el-menu-item index="5" style="margin-top: 30px;height: 90px"><!--投票-->
                  <i id="toupiao" class="iconfont icon-navicon-tp"></i>
                  <span style="font-size: 22px;margin-top: 6px">社区投票</span>
                </el-menu-item>
              </el-menu>
            </el-col>
          </el-row>
        </el-aside>
        <!--                    *****以上是侧边栏*****         —-->


        <el-main>Main</el-main>
      </el-container>
    </el-container>
  </div>
</template>


<script lang="ts" setup>
import {Setting} from '@element-plus/icons-vue'
import {onMounted} from "vue/dist/vue";
import axios from "axios/index";
// onMounted(async () => {
//   try {
//     // const response = await axios.post('api/secure/refresh', null,{
//     //   headers: {
//     //     authorization: store.state.token
//     //   }
//     // });
//     await axios.post('api/secure/refresh',
//         JSON.stringify(data), {
//           headers: {
//             Authorization: store.state.token,//令牌
//             'Content-Type': 'application/json'
//           }
//         })
//         .then(response => {
//           console.log(response.data);
//           console.log("headers:", response.headers);
//
//         })
//         .catch(error => {
//           console.error('请求出错', error);
//           console.error(store.state.token);
//           console.error(store.state.token);
//         });
//     // console.log(response.data);
//   } catch (error) {
//     console.error(error);
//   }
// });
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>