
import { instanceAxios } from "../../config/configAxios"
import { TradAlert } from "../components/TradAlert"

export const postAuthAndGetToken = (credentials) => {
  return instanceAxios.post("/authentication/login" , credentials )
        .then(response =>  response )
        .catch(err => TradAlert(err.response.data.tokenJwt ,err.message , "error") )
}

export const postSignInAccount = (data) => {
    return instanceAxios
              .post("/authentication/register" , data )
                .then (response => response )
                .catch(err=> TradAlert(err.response.data?.message, err.message, "error"))
}
export const validatedAccountAuth = (data) => {
    return instanceAxios
              .post("/authentication/validAccount" , data )
                .then(response => response)
                .catch(err=> TradAlert(err.response?.data,"", "error"))
}