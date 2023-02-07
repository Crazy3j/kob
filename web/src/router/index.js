import {createRouter, createWebHistory} from 'vue-router'
import PKIndexView from "../../views/pk/PKIndexView.vue";
import RankListIndex from "../../views/ranklist/RankListIndex.vue";
import RecordIndex from "../../views/record/RecordIndex.vue";
import UserBotIndex from "../../views/user/bot/UserBotIndex.vue";
import NotFound from "../../views/error/NotFound.vue";

const routes = [
    {
        path: "/",
        name: "home",
        redirect: "/pk/",
    },
    {
        path: "/pk/",
        name: "pk_index",
        component: PKIndexView,
    },
    {
        path: "/ranklist/",
        name: "ranklist_index",
        component: RankListIndex,
    },
    {
        path: "/record/",
        name: "record_index",
        component: RecordIndex,
    },
    {
        path: "/user/bot/",
        name: "user_bot_index",
        component: UserBotIndex,
    },
    {
        path: "/404/",
        name: "404",
        component: NotFound,
    },
    {
        path: "/:catchAll(.*)",
        redirect: "/404/",
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
