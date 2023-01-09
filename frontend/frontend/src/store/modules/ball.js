import ballService from "@/services/ballService";

const state = {
    ball: {},
    balls: [],
};

const getters = {
    balls: (state) => {
        return state.balls;
    },
    ball: (state) => {
        return state.ball;
    }
};

const actions = {
    addBall({ commit }, ball) {
        return new Promise((resolve, reject) => {
            ballService.postBall(ball).then((response) => {
                commit("addBall", ball);
                resolve(response);
            }).catch((err) => reject(err));
        });
    },
    getBall({ commit }, params) {
        return new Promise((resolve, reject) => {
            ballService.fetchBall(params).then((response) => {
                commit("setBall", response);
                resolve(response);
            }).catch((err) => {
                reject(err);
            });
        });
    },
    updateBall({ dispatch }, params) {
        return new Promise((resolve, reject) => {
            ballService.patchBall(params).then((response) => {
                dispatch("getBalls");
                resolve(response);
            }).catch((err) => {
                reject(err);
            });
        });
    },
    removeBall({ dispatch }, ballId) {
        return new Promise((resolve, reject) => {
            ballService.deleteBall(ballId).then(() => {
                dispatch("getBalls");
                resolve();
            }).catch((err) => {
                reject(err);
            });
        });
    },
    getBalls({ commit }) {
        return new Promise((resolve, reject) => {
            ballService.fetchBalls().then((response) => {
                commit("setBalls", response);
                resolve(response);
            }).catch((err) => reject(err));
        });
    },
};

const mutations = {
    setBalls(state, data) {
        state.balls = data;
    },
    addBall(state, ball) {
        state.balls.push(ball);
    },
    setBall(state, data) {
        state.ball = data;
    },
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};