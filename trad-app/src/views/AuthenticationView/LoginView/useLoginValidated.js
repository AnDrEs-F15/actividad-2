import * as yup from "yup";

export const useLoginValidated = () => {
    const fieldLogin = [
        {
            name: "email",
            label: "Correo Electronico",
            type: "email",
            fullWidth: "span 2",
            autoFocus:true
        },
        {
            name: "password",
            label: "Contraseña",
            type: "password"
        },
    ]

    const schema = yup.object().shape({
        email: yup
            .string()
            .email('El correo no es valido')
            .min(4,"Almenos 4 caracteres")
            .required('El campo es requerido'),
        password: yup
            .string()
            .min(6,"Minimo 6 caracteres")
            .required('Campo requerido')
        })

    return {
        fieldLogin,
        schema
    }
}