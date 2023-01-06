import { api } from "@/services/api";

export default {
    fetchRacket(racketId) {
        return api.get(`racket/${racketId}`).then((response) => response.data);
    },
    postRacket(data) {
        return api.post("racket", data).then((response) => response.data);
    },
    patchRacket(update) {
        return api.patch(`racket/${update.id}`, update.payload).then((response) => response.data);
    },
    deleteRacket(racketId) {
        return api.delete(`racket/${racketId}`).then((response) => response.data);
    },
    fetchRackets() {
        return api.get("rackets").then((response) => response.data);
    },
};