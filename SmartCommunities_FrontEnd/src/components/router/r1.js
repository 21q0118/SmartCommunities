import {createRouter, createWebHashHistory} from "vue-router";
import zhuce from "@/components/elment/zhuce.vue";
import denglu from "@/components/elment/denglu.vue";
import cebian from "@/components/elment/cebian.vue";
import tishi from "@/components/elment/tishi.vue";
import renzheng from "@/components/elment/renzheng.vue";
import {ElMessage} from "element-plus";
import car from '@/components/elment/car.vue'
import axios from "axios";
// import {useStore} from 'vuex';
import {ref} from "vue";
import store from "@/components/store/s1";
// import { useStore } from 'vuex';
// const store = useStore();
// import {useStore} from 'vuex';
//
// const store = useStore();


const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/',
            name: 'denglu',
            component: denglu
        },
        {
            path: '/register',
            name: 'register',
            component: zhuce
        },
        {
            path: '/cebian',
            name: 'cebian',
            component: cebian
        },
        {
            path: '/tishi',
            name: 'tishi',
            component: tishi
        }, {
            path: '/renzheng',
            name: 'renzheng',
            component: renzheng
        },
        {
            path: '/car',
            name: 'car',
            component: car
        }
    ]
})
// 全局前置守卫
router.beforeEach(async (to, from, next) => {
    // 获取用户登录状态，可以从后端接口或本地存储中获取
    //-----------------------------------------------
    const isAuthenticated = ref(1)//假设用户登录状态有效
    // 响应拦截
    axios.interceptors.response.use(
        response => {
            console.log("r1.js正在响应拦截")
            return response;
        },
        error => {
            isAuthenticated.value = 0;
            // 检查响应是否为 401
            if (error.response.status === 401) {
                console.log('无令牌');
                // 执行重新登录操作...
                try {
                    // router.push('/');
                    isAuthenticated.value = 0;
                } catch (error) {
                    console.error('重新登录失败');
                    // 处理重新登录失败的情况，例如跳转到登录页面等
                }
            }
            if (error.response.status === 402) {
                console.log('令牌不合法');
                // 执行重新登录操作...
                try {
                    // router.push('/');
                    isAuthenticated.value = 0;
                } catch (error) {
                    console.error('重新登录失败');
                    // 处理重新登录失败的情况，例如跳转到登录页面等
                }
            } else {
                console.error('未知错误', error);
            }
            // 其他错误处理逻辑
            throw error;
        }
    );
    const data = {
        phnum: null,
        ppword: null
    };
    await axios.post('api/secure/refresh',
        JSON.stringify(data), {
            headers: {
                Authorization: store.state.token,//令牌
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            // console.log(response.data);
            // console.log("headers:", response.headers);
            console.log("发出去的token(then):",store.state.token)
        })
        .catch(error => {
            console.error('请求产生出错', error);
            console.log("发出去的token:",store.state.token)
            // console.error(store.state.token);
            // console.error(store.state.token);
        });
    //-----------------------------------------------
    // 需要进行登录验证的路由名称
    const authRequiredRoutes = ['cebian']
    // console.log(to.name)
    // console.log(authRequiredRoutes)

    // 如果访问的是需要登录的页面并且用户未登录，则重定向到登录页
    if (authRequiredRoutes.includes(to.name) && !isAuthenticated.value) {
        console.log("发生错误，不能直接跳转！！")
        open2()
        next('/')
    } else {
        console.log("成功跳转！")
        next()
    }
})
export default router
const open2 = () => {
    ElMessage({
        showClose: true,
        message: 'token过期，请先登录！',
        type: 'warning',
    })
}