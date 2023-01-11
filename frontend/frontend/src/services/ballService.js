import { api } from "@/services/api";

export default {
    fetchBall(ballId) {
        return api.get(`balls/${ballId}`).then((response) => response.data);
    },
    postBall(data) {
        return api.post("ball", data).then((response) => response.data);
    },
    patchBall(update) {
        return api.patch(`ball/${update.id}`, update.payload).then((response) => response.data);
    },
    deleteBall(ballId) {
        return api.delete(`ball/${ballId}`).then((response) => response.data);
    },
    fetchBalls() {
        return api.get("balls").then((response) => response.data);
    },
};