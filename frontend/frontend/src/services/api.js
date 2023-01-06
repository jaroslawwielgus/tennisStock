import axios from "axios";
import Cookies from "js-cookie";

const api = axios.create({
    baseURL: "http://localhost:8080/",
    timeout: 5000,
    headers: {
        "Content-Type": "application/json",
        "X-CSRFToken": Cookies.get("csrftoken"),
    },
});


let pendingRequests = 0;

api.interceptors.request.use(
    function (config) {
        pendingRequests++;
        return config;
    },
    function (error) {
        return Promise.reject(error);
    }
);

api.interceptors.response.use(
    function (response) {
        pendingRequests--;
        return response;
    },
    function (error) {
        pendingRequests--;
        return Promise.reject(error);
    }
);

export { api, pendingRequests };