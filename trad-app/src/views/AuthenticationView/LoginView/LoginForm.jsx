import { Button } from '@mui/material'
import { Box } from '@mui/system'
import React, { useEffect } from 'react'
import { useLoginValidated } from './useLoginValidated'
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import TextField from '@mui/material/TextField';
import { Link } from 'react-router-dom';
import {useSelector} from "react-redux";
import { instanceAxios } from '../../../../config/configAxios';
import {useHandleSetToken} from "./useHandleSetToken"
const LoginForm = () => {
  const {fieldLogin,schema} = useLoginValidated();
  const {register, handleSubmit, formState:{errors}  } = useForm({
    resolver: yupResolver(schema)
  })
  const onSubmit = () => console.log(register);
  const auth = useSelector((state)=> state.authentication )
  const trad = useSelector((state)=> state.tradStatus )
  console.log(auth);
  const {handleLoginSubmit} = useHandleSetToken()

  return (
    <>
      <Box 
        component={"form"}
        display = "flex"
        flexDirection={"column"}
        gap={2}
        width={"80%"}
        onSubmit={handleSubmit(handleLoginSubmit)}
      >
      {
        fieldLogin.map((field) => (
            <TextField
                key={field.name}
                autoFocus={field.autoFocus}
                id= {field.name}
                label={field.label}
                name={field.name}
                type={field.type}
                fullWidth
                error={errors[field.name]?.type ? true : false}
                helperText={errors[field.name]?.message}
                {...register(field.name, field?.validation )}
            />
          ))
        }
        <Button 
          variant='contained' 
          type='submit'
        >
          Iniciar sesion</Button>
        <Link to={"/signin"} >Registrar</Link>
      </Box>
    </>
  )
}

export default LoginForm