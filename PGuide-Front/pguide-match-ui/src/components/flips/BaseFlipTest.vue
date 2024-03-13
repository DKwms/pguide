<template>
    <div class="item-group">
        <div class="square xyz-in"></div>
        <div class="square xyz-in"></div>
        <div class="square xyz-in"></div>
    </div>
</template>

<script>
export default {
    name: "BaseFlipTest"
}
</script>

<style>
.item-group {
    --xyz-rotate-x: 90deg;
    --xyz-rotate-z: -180deg;
    --xyz-origin: -200%;
    --xyz-stagger: 0.1s;
    --xyz-duration: 0.75s;
    --xyz-perspective: 100px;
    --xyz-translate-z: 100px;
    --xyz-translate-y: 10vh;
}

.square{
    width: 100px;
    height: 100px;
    background-color: #42b983;
}
</style>

