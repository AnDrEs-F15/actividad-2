import { Button, Grid, TextField } from '@mui/material'
import { Box } from '@mui/system'
import React from 'react'
import { useValidatedBudget } from '../hooks/useValidatedBudget'

const FormBudget = () => {
    const { inputField } = useValidatedBudget();
    return (
        <>
            <Grid
                component={"form"}
                container
                display={"grid"}
                gridTemplateColumns={{ sm: "1fr 1fr", xs: "1fr", md: "1fr 1fr", lg: "1fr 1fr" }}
                gap={1}
                my={1}
            >
                {
                    inputField?.map(item => (
                            <TextField
                                key={item?.name} 
                                style={{ gridColumn: item?.fullWidth }}
                                name={item.name}
                                label={item?.label}
                                type={item.type}
                                multiline={item?.multiline}
                                rows={item?.rows}
                                InputLabelProps={{shrink:item?.shrink}}
                            />
                    ))
                }
               
                    <Button 
                        variant='contained' 
                        style={{gridColumn:"span 2"}}
                    >Guardar
                    </Button>


            </Grid>
        </>
    )
}

export default FormBudget
