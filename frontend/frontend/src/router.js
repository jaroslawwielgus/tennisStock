import Vue from 'vue'
import Router from 'vue-router'

import racketsCatalog from "@/components/racketCatalog/racketCatalog"
import racketPanel from "@/components/racketPanel/racketPanel"

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: "/",
            name: "rackets",
            component: racketsCatalog,
        },
        {
            path: "/racket/:id",
            name: "racket",
            component: racketPanel,
        },
        // {
        //     path: "/ball-catalog",
        //     name: "ballCatalog",
        //     component: ballCatalog,
        // },
        // {
        //     path: "/ball/:id",
        //     name: "ball",
        //     component: ballPanel,
        // },
        // {
        //     path: "/string-catalog",
        //     name: "stringCatalog",
        //     component: stringCatalog,
        // },
        // {
        //     path: "/string/:id",
        //     name: "string",
        //     component: stringPanel,
        // },
    ]
});
export default router;

