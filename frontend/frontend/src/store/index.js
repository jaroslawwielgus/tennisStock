import Vue from "vue";
import Vuex from "vuex";

import racket from "./modules/racket";

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        racket,
    },
});
