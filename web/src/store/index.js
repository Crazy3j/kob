import {createStore} from 'vuex'
import ModuleUser from '@/store/modules/user'
import ModulePk from '@/store/modules/pk'
import ModuleRecord from '@/store/modules/record'

const store = createStore({
    state: {},
    getters: {},
    mutations: {},
    actions: {},
    modules: {
        user: ModuleUser,
        pk: ModulePk,
        record: ModuleRecord,
    }

})
export default store;
