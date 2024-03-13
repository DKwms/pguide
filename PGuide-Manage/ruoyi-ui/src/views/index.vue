<template>
  <div class="container">
    <div class="box1">
      <!-- 第一个大盒子 -->
    </div>
    <div class="box2">
      <!-- 第二个大盒子 -->
    </div>
  </div>
</template>

<style>
.container {
  display: flex;
}

.box1 {
  width: 65%;
  height: 100%; /* 占据父容器高度 */
  margin-right: 10px; /* 与父容器有一定小距离，可以根据需要调整 */
  background-color: #ccc; /* 可以根据需要设置背景颜色 */
}

.box2 {
  width: 35%;
  height: 100%; /* 与第一个大盒子高度相同 */
  background-color: #ddd; /* 可以根据需要设置背景颜色 */
}
</style>
