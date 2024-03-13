import Vue from 'vue'
import Vuex from 'vuex'
import user from "@/store/moudules/user";
import getters from './getters'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    user
  },
  getters
})
