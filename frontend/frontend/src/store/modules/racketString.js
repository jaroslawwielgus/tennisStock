import racketStringService from "@/services/racketStringService";

const state = {
    racketString: {},
    racketStrings: [],
};

const getters = {
    racketStrings: (state) => {
        return state.racketStrings;
    },
    racketString: (state) => {
        return state.racketString;
    }
};

const actions = {
    addRacketString({ commit }, racketString) {
        return new Promise((resolve, reject) => {
            racketStringService.postRacketString(racketString).then((response) => {
                commit("addRacketString", racketString);
                resolve(response);
            }).catch((err) => reject(err));
        });
    },
    getRacketString({ commit }, params) {
        return new Promise((resolve, reject) => {
            racketStringService.fetchRacketString(params).then((response) => {
                commit("setRacketString", response);
                resolve(response);
            }).catch((err) => {
                reject(err);
            });
        });
    },
    updateRacketString({ dispatch }, params) {
        return new Promise((resolve, reject) => {
            racketStringService.patchRacketString(params).then((response) => {
                dispatch("getRacketStrings");
                resolve(response);
            }).catch((err) => {
                reject(err);
            });
        });
    },
    removeRacketString({ dispatch }, racketStringId) {
        return new Promise((resolve, reject) => {
            racketStringService.deleteRacketString(racketStringId).then(() => {
                dispatch("getRacketStrings");
                resolve();
            }).catch((err) => {
                reject(err);
            });
        });
    },
    getRacketStrings({ commit }) {
        return new Promise((resolve, reject) => {
            racketStringService.fetchRacketStrings().then((response) => {
                commit("setRacketStrings", response);
                resolve(response);
            }).catch((err) => reject(err));
        });
    },
};

const mutations = {
    setRacketStrings(state, data) {
        state.racketStrings = data;
    },
    addRacketString(state, racketString) {
        state.racketStrings.push(racketString);
    },
    setRacketString(state, data) {
        state.racketString = data;
    },
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};