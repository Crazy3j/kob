import {createStore} from 'vuex'
import ModuleUser from '@/store/modules/user'
import ModulePk from '@/store/modules/pk'

const store = createStore({
    state: {},
    getters: {},
    mutations: {},
    actions: {},
    modules: {
        user: ModuleUser,
        pk: ModulePk,
    }

})
export default store;
