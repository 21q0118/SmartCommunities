<script setup>
// localStorage.clear();//每次清楚token缓存
import Cebian from "./components/elment/cebian.vue";
import Denglu from "@/components/elment/denglu.vue";
import Zhuce from "@/components/elment/zhuce.vue";
import Tishi from "@/components/elment/tishi.vue";
import Renzheng from "@/components/elment/renzheng.vue";
import Renzheng_fail from "@/components/elment/renzheng_fail.vue";
import Geren from "@/components/elment/geren.vue";
import Home from "@/components/elment/home.vue";
import YeweihuiShixiangjianguan from "@/components/elment/yeweihui-shixiangjianguan.vue";
import YeweihuiToupiaoguanli from "@/components/elment/yeweihui-toupiaoguanli.vue";
import YeweihuiTousujianguan from "@/components/elment/yeweihui-tousujianguan.vue";
// import { useRouter } from 'vue-router';
// const router = useRouter();
// function goToDenglu() {
//   router.push('/zhuce');
// }
import { useStore } from 'vuex';
import {computed} from "vue";
import CarRequest from "@/components/elment/car.vue";
import Cheliangguanli from "@/components/elment/cheliangguanli.vue";
import Shequtoupiao from "@/components/elment/shequtoupiao.vue";
import Shijianshangbao from "@/components/elment/shijianshangbao.vue";
import Demo from "@/components/elment/demo.vue";
import Car from "@/components/elment/car.vue";

const store = useStore();
const plus=()=>{
  store.commit('plus')
}
const doubledCount = computed(() => {
  return store.state.count;
});
</script>

<template>
<!--  <yeweihui-shixiangjianguan></yeweihui-shixiangjianguan>-->
<!--  <yeweihui-tousujianguan></yeweihui-tousujianguan>-->
<!--                                                <yeweihui-toupiaoguanli></yeweihui-toupiaoguanli>-->
<!--  <home></home>-->
  <renzheng></renzheng>
<!--  <renzheng_fail></renzheng_fail>-->
<!--  <shequtoupiao></shequtoupiao>-->
<!--  <shijianshangbao></shijianshangbao>-->
<!--  <tishi></tishi>-->
<!--  <geren></geren>-->
<!--<zhuce></zhuce>-->
<!--  <cebian></cebian>-->
<!--<cheliangguanli></cheliangguanli>-->

<!--<car></car>-->
<!--  <renzheng></renzheng>-->

<!--  <demo></demo>-->
<!--    <router-view />-->

<!--  <car-request></car-request>-->
<!--<div>hahah:{{doubledCount}}</div>-->
<!--  <button @click="plus">点击我</button>-->
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
