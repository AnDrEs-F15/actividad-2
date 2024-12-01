import axios from "axios";
import Swal from "sweetalert2";
import { getTokenJwt } from "../src/redux/slices/authenticationSlice";
import { setHandleError, setLoading, setTradStatus } from "../src/redux/slices/tradStatusSlice";
import { store } from "../src/redux/store";

export const instanceAxios = axios.create({
    baseURL:import.meta.env.VITE_API_PATH,
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
    },
})

instanceAxios.interceptors.request.use( request => {
    store.dispatch(setLoading({isLoading:true}))
/*     const token = getTokenJwt(store.getState())?.jwt
    if(token != null){
        request.headers.Authorization = "Bearer " + token; 
    } */
    return request;
})

instanceAxios.interceptors.response.use(
    response => {
        store.dispatch(setLoading({isLoading:false}))
        return response;
}, 
    error => {
        console.log(error);

        store.dispatch(setLoading({isLoading:false}))
        Swal.fire(error.message)
        return Promise.reject(error)
})