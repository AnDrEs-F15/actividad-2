import * as yup from "yup";
export const useSigningValidated = () => {
    const fieldSignin = [
        {
            name: "email",
            label: "Correo Electronico",
            type: "email",
            fullWidth: "span 2",
            autoFocus:true
        },
        {
            name: "name",
            label: "Nombre",
            type: "text",
        },
        {
            name: "phone",
            label: "Ceular",
            type: "number"
        },
        {
            name: "password",
            label: "Contraseña",
            type: "password"
        },
        {
            name: "validatedPassword",
            label: "Confirmar Contraseña",
            type: "password"
        }
    ]
    const schema = yup.object().shape({
        email: yup
            .string()
            .email('El correo no es valido')
            .min(4,"Almenos 4 caracteres")
            .required('El campo es requerido'),
        name: yup
            .string()
            .min(4,"Almenos 4 caracteres")
            .required('El campo es requerido'),
        phone: yup
            .number()
            .typeError('Debe ser un número')
            .integer('Debe ser un número entero')
            .min(100000, 'El número debe tener al menos 6 dígitos')
            .required('Campo requerido'),
        password: yup
            .string()
            .min(6,"Minimo 6 caracteres")
            .required('Campo requerido'),
        validatedPassword: yup
            .string()
            .oneOf([yup.ref("password") , null ], "No coincide con la contraseña")   
    })
    return {
        fieldSignin,
        schema
    }
}