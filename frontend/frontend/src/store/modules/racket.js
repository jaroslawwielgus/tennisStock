import racketService from "@/services/racketService";

const state = {
    racket: {},
    rackets: [],
};

const getters = {
    rackets: (state) => {
        return state.rackets;
    },
    racket: (state) => {
        return state.racket;
    }
};

const actions = {
    addRacket({ commit }, racket) {
        return new Promise((resolve, reject) => {
            racketService.postRacket(racket).then((response) => {
                commit("addRacket", racket);
                resolve(response);
            }).catch((err) => reject(err));
        });
    },
    getRacket({ commit }, params) {
        return new Promise((resolve, reject) => {
            racketService.fetchRacket(params).then((response) => {
                commit("setRacket", response);
                resolve(response);
            }).catch((err) => {
                reject(err);
            });
        });
    },
    updateRacket({ dispatch }, params) {
        return new Promise((resolve, reject) => {
            racketService.patchRacket(params).then((response) => {
                dispatch("getRackets");
                resolve(response);
            }).catch((err) => {
                reject(err);
            });
        });
    },
    removeRacket({ dispatch }, racketId) {
        return new Promise((resolve, reject) => {
            racketService.deleteRacket(racketId).then(() => {
                dispatch("getRackets");
                resolve();
            }).catch((err) => {
                reject(err);
            });
        });
    },
    getRackets({ commit }) {
        return new Promise((resolve, reject) => {
            racketService.fetchRackets().then((response) => {
                commit("setRackets", response);
                resolve(response);
            }).catch((err) => reject(err));
        });
    },
};

const mutations = {
    setRackets(state, data) {
        state.rackets = data;
    },
    addRacket(state, racket) {
        state.rackets.push(racket);
    },
    setRacket(state, data) {
        state.racket = data;
    },
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};