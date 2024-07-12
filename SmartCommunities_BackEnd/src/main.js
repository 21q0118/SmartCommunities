import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
// import './components/font/house/iconfont.css'
import './components/font/car/iconfont.css'
import './components/font/family/iconfont.css'
import './components/font/wenti/iconfont.css'
import './components/font/nav/iconfont.css'
import './components/font/fangzi/iconfont.css'
import './components/font/lingdang/iconfont.css'
import './components/font/jiantou_xia/iconfont.css'
import router from "@/components/router/r1";
import store from "@/components/store/s1";
const app = createApp(App)
app.use(router)
app.use(store)
app.use(ElementPlus)
app.mount('#app')
