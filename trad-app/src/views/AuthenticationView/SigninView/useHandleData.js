import { TradAlert } from "../../../components/TradAlert"
import { postSignInAccount } from "../../../services/authenticationServices"
import { useNavigate } from 'react-router-dom';

export const useHandleData = () => {
    const navigate = useNavigate()
    const handleSignInSubmit = (data) => {
        postSignInAccount(data)
            .then (response => {
                if (response.status == 201) {
                    TradAlert("Cuenta creada" , "Revisa el correo electronico para validar la cuenta", "success"  )
                    navigate("/verifyAccount")
                }
            } )
    }
    return {
        handleSignInSubmit,
    }
}