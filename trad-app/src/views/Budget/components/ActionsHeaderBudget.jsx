import { Button, TextField } from '@mui/material'
import React, { useState } from 'react'
import AppModal from '../../../components/AppModal';
import FormBudget from './FormBudget';

const ActionsHeaderBudget = () => {
    const [open,setOpen] = useState(false);
    const handleOpen = (isOpen) =>{ 
        setOpen(!open);
        return open;
    }
  return (
    <>
      <Button onClick={handleOpen} size='small' variant='contained'>Crear nuevo</Button>
      <AppModal handleOpen={open} setOpen={setOpen} title={"Crear presupuesto"} >
            <FormBudget /> 
      </AppModal>
    </>
  )
}

export default ActionsHeaderBudget
