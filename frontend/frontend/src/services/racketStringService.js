import { api } from "@/services/api";

export default {
    fetchRacketString(racketStringId) {
        return api.get(`racket-strings/${racketStringId}`).then((response) => response.data);
    },
    postRacketString(data) {
        return api.post("racket-string", data).then((response) => response.data);
    },
    patchRacketString(update) {
        return api.patch(`racket-string/${update.id}`, update.payload).then((response) => response.data);
    },
    deleteRacketString(racketStringId) {
        return api.delete(`racket-string/${racketStringId}`).then((response) => response.data);
    },
    fetchRacketStrings() {
        return api.get("racket-strings").then((response) => response.data);
    },
};