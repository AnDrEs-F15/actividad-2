import { TradAlert } from "../../../components/TradAlert";
import { validatedAccountAuth } from "../../../services/authenticationServices";
import { useNavigate } from 'react-router-dom';

export const useValidated = () => {
    const navigate = useNavigate()
    const handleFetchData = (data) => {
        validatedAccountAuth(data)
            .then(response => {
                if(response.status==200) {
                    console.log(response);
                    TradAlert("Se valido la cuenta correctamente", "","success")
                    navigate("/login")
                }
            })

    }; 
    return {
        handleFetchData
    }
}