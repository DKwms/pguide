<template>
  <div class="home" style="text-align: center">
      主要功能展示区
      <hr color="black">

      <div>
          <div class="btnBox">
              <div>
                  <div class="btn shadow-drop-center" style="float: left;overflow: hidden">主页展示</div>
              </div>
              <div>
                  <div class="btn shadow-drop-center" style="float: left">功能页展示</div>
              </div>
          </div>
      </div>

      <button v-model:="demo01" @click="demo01=!demo01">{{demo01}}</button>
      <div v-if="demo01">
          <div class="swing-bottom-fwd">
              <div class="btnBox">
                  <div>
                      <div class="btn shadow-drop-center"></div>
                  </div>
                  <div>
                      <div class="btn shadow-drop-center"></div>
                  </div>
              </div>
          </div>

          <div class="swing-top-fwd">
              <div class="btnBox">
                  <div>
                      <div class="btn shadow-drop-center"></div>
                  </div>
                  <div>
                      <div class="btn shadow-drop-center"></div>
                  </div>
              </div>
          </div>
      </div>

  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'HomeView',
    data(){
      return {
          demo01:false
      }
    }
  // components: {
  //   HelloWorld
  // }
}
</script>

<style>

.btnBox {
    display: inline-block;
    width: 90%;
    -webkit-animation: shadow-inset-center 0.1s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
    animation: shadow-inset-center 0.1s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
}

/*=====================================跳转按钮*/

.btn {
    user-select:none;
    width: 80px;
    height: 80px;
    margin: 20px;
    line-height: 80px;
}

.btn:hover {
    -webkit-animation: shadow-inset-center 0.1s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
    animation: shadow-inset-center 0.1s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
}


/*================================== 外部阴影 =========================================*/

.shadow-drop-center {
    -webkit-animation: shadow-drop-center 0.2s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
    animation: shadow-drop-center 0.2s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
}

@-webkit-keyframes shadow-drop-center {
    0% {
        -webkit-box-shadow: 0 0 0 0 rgba(0, 0, 0, 0);
        box-shadow: 0 0 0 0 rgba(0, 0, 0, 0);
    }
    100% {
        -webkit-box-shadow: 0 0 20px 0px rgba(0, 0, 0, 0.35);
        box-shadow: 0 0 20px 0px rgba(0, 0, 0, 0.35);
    }
}
@keyframes shadow-drop-center {
    0% {
        -webkit-box-shadow: 0 0 0 0 rgba(0, 0, 0, 0);
        box-shadow: 0 0 0 0 rgba(0, 0, 0, 0);
    }
    100% {
        -webkit-box-shadow: 0 0 20px 0px rgba(0, 0, 0, 0.35);
        box-shadow: 0 0 20px 0px rgba(0, 0, 0, 0.35);
    }
}

/*================================== 内部阴影 ==========================================*/
.shadow-inset-center {
    -webkit-animation: shadow-inset-center 0.4s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
    animation: shadow-inset-center 0.4s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
}

@-webkit-keyframes shadow-inset-center {
    0% {
        -webkit-box-shadow: inset 0 0 0 0 rgba(0, 0, 0, 0);
        box-shadow: inset 0 0 0 0 rgba(0, 0, 0, 0);
    }
    100% {
        -webkit-box-shadow: inset 0 0 14px 0px rgba(0, 0, 0, 0.5);
        box-shadow: inset 0 0 14px 0px rgba(0, 0, 0, 0.5);
    }
}
@keyframes shadow-inset-center {
    0% {
        -webkit-box-shadow: inset 0 0 0 0 rgba(0, 0, 0, 0);
        box-shadow: inset 0 0 0 0 rgba(0, 0, 0, 0);
    }
    100% {
        -webkit-box-shadow: inset 0 0 14px 0px rgba(0, 0, 0, 0.5);
        box-shadow: inset 0 0 14px 0px rgba(0, 0, 0, 0.5);
    }
}

/*=================================登场动画=============================*/
.swing-bottom-fwd {
    -webkit-animation: swing-bottom-fwd 2s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
    animation: swing-bottom-fwd 2s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
}
/**
 * ----------------------------------------
 * animation swing-bottom-fwd
 * ----------------------------------------
 */
@-webkit-keyframes swing-bottom-fwd {
    0% {
        -webkit-transform: rotateX(0);
        transform: rotateX(0);
        -webkit-transform-origin: bottom;
        transform-origin: bottom;
    }
    100% {
        -webkit-transform: rotateX(-180deg);
        transform: rotateX(-180deg);
        -webkit-transform-origin: bottom;
        transform-origin: bottom;
    }
}
@keyframes swing-bottom-fwd {
    0% {
        -webkit-transform: rotateX(0);
        transform: rotateX(0);
        -webkit-transform-origin: bottom;
        transform-origin: bottom;
    }
    100% {
        -webkit-transform: rotateX(-180deg);
        transform: rotateX(-180deg);
        -webkit-transform-origin: bottom;
        transform-origin: bottom;
    }
}


.swing-top-fwd {
    -webkit-animation: swing-top-fwd 2s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
    animation: swing-top-fwd 2s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
}

/**
 * ----------------------------------------
 * animation swing-top-fwd
 * ----------------------------------------
 */
@-webkit-keyframes swing-top-fwd {
    0% {
        -webkit-transform: rotateX(0);
        transform: rotateX(0);
        -webkit-transform-origin: top;
        transform-origin: top;
    }
    100% {
        -webkit-transform: rotateX(180deg);
        transform: rotateX(180deg);
        -webkit-transform-origin: top;
        transform-origin: top;
    }
}
@keyframes swing-top-fwd {
    0% {
        -webkit-transform: rotateX(0);
        transform: rotateX(0);
        -webkit-transform-origin: top;
        transform-origin: top;
    }
    100% {
        -webkit-transform: rotateX(180deg);
        transform: rotateX(180deg);
        -webkit-transform-origin: top;
        transform-origin: top;
    }
}

</style>
