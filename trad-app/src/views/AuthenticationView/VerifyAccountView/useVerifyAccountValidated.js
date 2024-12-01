import * as yup from "yup";
export const useVerifyAccountValidated = () => {
  const fieldForm = [
    {
      name: "email",
      label: "Correo electronico",
    },
    {
      name: "codeValidated",
      label: "Ingresar codigo",
    },
  ];
  const schema = yup.object().shape({
    email: yup
      .string()
      .email("El correo no es valido")
      .min(4, "Almenos 4 caracteres")
      .required("El campo es requerido"),
    codeValidated: yup
      .string()
      .matches(/^\d{6}$/, "El código debe ser numérico y tener 6 dígitos")
      .required("El campo es requerido"),
  });

  return {
    schema,
    fieldForm,
  };
};
