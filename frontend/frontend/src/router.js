import Vue from 'vue'
import Router from 'vue-router'

import racketsCatalog from "@/components/racket/racketsCatalog"
import racketPanel from "@/components/racket/racketPanel"
import ballsCatalog from "@/components/ball/ballsCatalog"
import ballPanel from "@/components/ball/ballPanel"
import racketStringsCatalog from "@/components/racketString/racketStringsCatalog"
import racketStringPanel from "@/components/racketString/racketStringPanel"

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
        {
            path: "/balls-catalog",
            name: "ballsCatalog",
            component: ballsCatalog,
        },
        {
            path: "/ball/:id",
            name: "ball",
            component: ballPanel,
        },
        {
            path: "/racket-strings-catalog",
            name: "racketStringsCatalog",
            component: racketStringsCatalog,
        },
        {
            path: "/racket-string/:id",
            name: "racketString",
            component: racketStringPanel,
        },
    ]
});
export default router;

