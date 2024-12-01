import { useDispatch } from "react-redux"
import { setTokenJwt } from "../../../redux/slices/authenticationSlice";
import { postAuthAndGetToken } from "../../../services/authenticationServices"

export const useHandleSetToken = () => {
    const dispatch = useDispatch();
    const handleLoginSubmit = (credentials) => {
        postAuthAndGetToken({username:credentials.email, password:credentials.password})
            .then(response => {
                 if(response.status == 200) dispatch(setTokenJwt(response.data.tokenJwt)) 
            })
    }
    return {
        handleLoginSubmit,
    }
}