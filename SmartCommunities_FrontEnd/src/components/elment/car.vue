<script setup>

import {onMounted} from "vue";

// const haha = async () => {
//   try {
//     // 请求拦截器：在请求发送之前拦截并处理请求数据
//     axios.interceptors.request.use(
//         config => {
//           console.log('正在请求拦截');
//           // 在请求拦截器中添加元数据或其他逻辑
//           // config.headers['Authorization'] = 'Bearer token123'; // 添加令牌等元数据
//           return config;
//         },
//         error => {
//           console.error('请求拦截error！', error);
//           return Promise.reject(error);
//         }
//     );
//     //响应拦截器
//     axios.interceptors.response.use(
//         response => {
//           // if(response.data.code==1){
//           //   console.log("登录成功！")
//           //   router.push('/cebian');
//           //   open1();
//           //   store.dispatch('car_re', response);
//           //   console.log("token-->",store.state.token)
//           //
//           // }
//           // if(response.data.code==2){
//           //   open3()
//           //   console.log("未注册！")
//           // }
//           // if(response.data.code==3){
//           //   open2()
//           //   console.log("未实名！")
//           //   router.push('/tishi');
//           // }
//           return response;
//         },
//         error => {
//           // if (error.response.status === 401)
//           console.error('error', error);
//           return Promise.reject(error);
//         }
//     );
//     // 发送POST请求
//     const data = {
//       phnum:1,
//       ppword: 1
//     };
//     // 发送请求
//     await axios.post('api/secure/refresh',
//         JSON.stringify(data),{headers: {
//             // Authorization: `Bearer ${store.state.token}`,//令牌
//             'Content-Type': 'application/json'
//           }})
//         .then(response => {
//           console.log(response.data); // 输出经过响应拦截器处理后的数据
//           console.log("headers:",response.headers); // 输出经过响应拦截器处理后的数据
//         })
//         .catch(error => {
//           console.error('请求出错', error);
//         });
//   } catch (error) {
//     // 处理请求错误逻辑
//     console.error(error);
//   }
// };
import axios from "axios";
// import {onMounted, ref} from 'vue';
import {useRouter} from "vue-router";

const router = useRouter();

// 响应拦截
axios.interceptors.response.use(
    // console.log("正在响应拦截")
    response => {
      if (response.data.status === 401) {
        console.log('令牌已过期');
        // 执行重新登录操作...
        try {
          router.push('/register');
        } catch (error) {
          console.error('重新登录失败');
          // 处理重新登录失败的情况，例如跳转到登录页面等
        }
      }
      // 处理正常的响应
      return response;
    },
    error => {
      // 检查响应是否为 401
      // if (error.response.status === 401) {
      //   console.log('令牌已过期');
      //   // 执行重新登录操作...
      //   try {
      //     router.push('/');
      //   } catch (error) {
      //     console.error('重新登录失败');
      //     // 处理重新登录失败的情况，例如跳转到登录页面等
      //   }
      // }
      // 其他错误处理逻辑
      console.error('响应拦截器出错', error);
      throw error;
    }
);


import {useStore} from 'vuex';

const store = useStore();
const data = {
  phnum: 1,
  ppword: 1
};
onMounted(async () => {
  try {
    // const response = await axios.post('api/secure/refresh', null,{
    //   headers: {
    //     authorization: store.state.token
    //   }
    // });
    await axios.post('api/secure/refresh',
        JSON.stringify(data), {
          headers: {
            Authorization: store.state.token,//令牌
            'Content-Type': 'application/json'
          }
        })
        .then(response => {
          console.log(response.data);
          console.log("headers:", response.headers);

        })
        .catch(error => {
          console.error('请求出错', error);
          console.error(store.state.token);
          console.error(store.state.token);
        });
    // console.log(response.data);
  } catch (error) {
    console.error(error);
  }
});

</script>

<template>
  <button>测试页面</button>
</template>

<style scoped>

</style>