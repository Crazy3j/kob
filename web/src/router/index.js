import {createRouter, createWebHistory} from 'vue-router'
import PKIndexView from "@/views/pk/PKIndexView.vue";
import RankListIndex from "@/views/ranklist/RankListIndex.vue";
import RecordIndex from "@/views/record/RecordIndex.vue";
import UserBotIndex from "@/views/user/bot/UserBotIndex.vue";
import NotFound from "@/views/error/NotFound.vue";
import UserAccountLoginView from "@/views/user/account/UserAccountLoginView.vue";
import UserAccountRegisterView from "@/views/user/account/UserAccountRegisterView.vue";
import store from "@/store/index";

const routes = [
    {
        path: "/",
        name: "home",
        redirect: "/pk/",
        meta: {
            requestAuth: true,
        }
    },
    {
        path: "/pk/",
        name: "pk_index",
        component: PKIndexView,
        meta: {
            requestAuth: true,
        }
    },
    {
        path: "/ranklist/",
        name: "ranklist_index",
        component: RankListIndex,
        meta: {
            requestAuth: true,
        }
    },
    {
        path: "/record/",
        name: "record_index",
        component: RecordIndex,
        meta: {
            requestAuth: true,
        }
    },
    {
        path: "/user/bot/",
        name: "user_bot_index",
        component: UserBotIndex,
        meta: {
            requestAuth: true,
        }
    },
    {
        path: "/user/account/login/",
        name: "user_account_login",
        component: UserAccountLoginView,
        meta: {
            requestAuth: false,
        }
    },
    {
        path: "/user/account/register/",
        name: "user_account_register",
        component: UserAccountRegisterView,
        meta: {
            requestAuth: false,
        }
    },

    {
        path: "/404/",
        name: "404",
        component: NotFound,
        meta: {
            requestAuth: false,
        }
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
router.beforeEach((to, from, next) => {
    if(to.meta.requeestAuth && !store.state.user.is_login){
        next({name:"user_account_login"});
    }else{
        next();
    }

})
export default router
