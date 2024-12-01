import React from 'react'
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Button from '@mui/material/Button';
import { useForm } from 'react-hook-form';

import { yupResolver } from '@hookform/resolvers/yup';
import { useSigningValidated } from './useSigninValidated';
import { Link } from 'react-router-dom';
import { useHandleData } from './useHandleData';

const SigninForm = () => {

    const {fieldSignin,schema} = useSigningValidated();
    const {handleSignInSubmit} = useHandleData()

    const {register , handleSubmit , formState:{errors}  } = useForm({
        resolver: yupResolver(schema)
    })


    return (
        <>
            <Grid 
                component={"form"} 
                container 
                display="grid" 
                gridTemplateColumns={{sm:"1fr", sx:"1fr" , md:"1fr 1fr"  }}
                gap={1}
                onSubmit={handleSubmit(handleSignInSubmit)}
                width={{sm:"90%" , xs:"90%" , md:"80%" }}
            >
                {
                    fieldSignin.map((field) => (
                        <Grid  
                            /* item xs={12}  */
                            key={field.name} 
                            style={{ gridColumn:  field?.fullWidth  }} 
                            /* sm={12} */
                        >
                            <TextField
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
                        </Grid>
                    ))
                }
                <Grid style={{gridColumn:"span 2"}} >
                    <Button 
                        variant='contained' 
                        fullWidth
                        type='submit'
                    >
                        Registrar
                    </Button>
                    
                </Grid>
                <Link to={"/login"} >Iniciar Sesion</Link>
            </Grid>
        </>
    )
}

export default SigninForm
