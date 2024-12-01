import React from 'react'
import TextField from '@mui/material/TextField';
import { Box } from '@mui/system'
import Button from '@mui/material/Button';
import { useForm } from 'react-hook-form';

import { yupResolver } from '@hookform/resolvers/yup';
import { useVerifyAccountValidated } from './useVerifyAccountValidated';
import { useValidated } from './useValidated';

import { Link } from 'react-router-dom';
const VerifyAccountForm = () => {
    const { schema, fieldForm } = useVerifyAccountValidated()
    const { handleFetchData } = useValidated()
    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(schema)
    })


    return (
        <>
            <Box
                component={"form"}
                display="flex"
                flexDirection={"column"}
                gap={2}
                width={"80%"}
                onSubmit={handleSubmit(handleFetchData)}
            >
                {
                    fieldForm
                        ?
                        fieldForm.map(item => (
                            <TextField
                                key={item.name}
                                id={item.name}
                                label={item.label}
                                name={item.name}
                                fullWidth
                                error={errors[item.name]?.type ? true : false}
                                helperText={errors[item.name]?.message}
                                {...register(item.name)}
                            />
                        ))
                        : ""
                }
                <Button
                    variant='contained'
                    type='submit'
                >
                    Validar cuenta
                </Button>

                <Link to={"/login"}>Iniciar Sesion</Link>

            </Box>
        </>
    )
}

export default VerifyAccountForm
