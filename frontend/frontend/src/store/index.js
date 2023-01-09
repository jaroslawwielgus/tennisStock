import Vue from "vue";
import Vuex from "vuex";

import racket from "./modules/racket";
import ball from "./modules/ball";
import racketString from "./modules/racketString"

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        racket,
        ball,
        racketString,
    },
});
