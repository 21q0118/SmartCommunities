<template>
  <div class="lunbo">
    <el-carousel height="600px" indicator-position="outside" style="border-radius: 10px">
      <el-carousel-item v-for="item in 4" :key="item" style="border-radius: 10px">
        <img alt="无法显示" class="pc" src="../icons/neiye/u111.png">
      </el-carousel-item>
    </el-carousel>
  </div>
  <div class="bt">
    <h3>欢迎使用</h3>
  </div>
  <div class="ba">
    <h3>社区数字化智能管理平台</h3>
  </div>
  <div class="house">
    <el-carousel height="400px" indicator-position="outside" style="border-radius: 10px">
      <el-carousel-item v-for="item in 4" :key="item" style="border-radius: 10px">
        <div class="pc_1">
          <img alt="无法显示" src="../icons/neiye/u141.png">
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
  <div class="homeinfo">
    <el-carousel height="400px" indicator-position="outside" style="border-radius: 10px">
      <el-carousel-item v-for="item in 4" :key="item" style="border-radius: 10px">
        <div class="pc_2">
          <img alt="无法显示" src="../icons/neiye/u146.png">
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
  <div class="car">
    <el-carousel height="400px" indicator-position="outside" style="border-radius: 10px">
      <el-carousel-item v-for="item in 4" :key="item" style="border-radius: 10px">
        <div class="pc_3">
          <img alt="无法显示" src="../icons/neiye/u146.png">
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<style scoped>
.el-carousel__item h3 {
  display: flex;
  color: #475669;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
  border-radius: 10px;
}

.el-carousel__item:nth-child(2n) {
  background-color: rgba(210, 210, 255, 0.94);
  border-radius: 10px;
  top: 0;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d2cdf0;
  border-radius: 10px;
}

.lunbo {
  position: relative;
  margin-top: 50px;
  margin-left: 300px;
  margin-right: 10px;
  border-radius: 50px;
}

.house {
  position: relative;
  margin-left: 300px;
  margin-right: 1400px;
  border-radius: 50px;
}

.homeinfo {
  position: relative;
  margin-left: 900px;
  margin-right: 600px;
  border-radius: 50px;
  margin-top: -430px;
}

.car {
  position: relative;
  margin-top: -430px;
  margin-left: 1690px;
  margin-right: 10px;
  border-radius: 50px;
}

.pc {
  margin-top: -280px;
  margin-left: -460px;
  margin-right: 10px;
  transform: scale(0.7);
  border-radius: 10px;
}

.pc_1 {
  transform: scale(0.7);
  position: relative;
  margin-left: -50px;
  border-radius: 10px;
}

.pc_2 {
  transform: scale(0.7);
  position: relative;
  margin-left: -50px;
  border-radius: 10px;
}

.pc_3 {
  transform: scale(0.7);
  position: relative;
  margin-left: -50px;
  border-radius: 10px;
}

.bt {
  font-size: 50px;
  margin-left: 1160px;
  margin-top: -220px;
  top: 0;
  position: relative;
  font-family: "JetBrains Mono ExtraBold";
}

.ba {
  font-size: 30px;
  top: 0;
  position: relative;
  margin-left: 1080px;
  margin-top: -60px;
  font-family: "JetBrains Mono ExtraBold";
}
</style>
<script lang="ts">
</script>
