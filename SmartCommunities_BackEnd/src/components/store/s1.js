import { createStore } from 'vuex';
import createPersistedState from "vuex-persistedstate"
const store = createStore({
    state() {
        return {
            token: null,
        };
    },
    mutations: {
        setToken(state, token) {
            state.token = token;
        },
    },
    actions: {
        // car_re({ commit }, credentials) {
        //     // 发送登录请求并获取新的令牌
        //     return axios.post('/car_rquest', credentials)
        //         .then(response => {
        //             const { token} = response.data;
        //             // 更新令牌和用户信息到 store
        //             commit('setToken', token);
        //         });
        // }
        car_re({ commit }, resp) {
            const { token} = resp.headers;
            commit('setToken', token);
        }

    },
    plugins: [createPersistedState({storage:sessionStorage})]//保持会话
});
export default store