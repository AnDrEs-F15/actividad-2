import { Button, Dialog, DialogActions, DialogContent, DialogTitle } from '@mui/material'
import React from 'react'

const AppModal = ({
    handleOpen,
    setOpen,
    title,
    children
}) => {
  return (
    <>
      <Dialog
        open={handleOpen}
        onClose={()=> setOpen(false) }
        fullWidth
        maxWidth={"sm"}
      >
        <DialogTitle>{title}</DialogTitle>
        <DialogContent>
            {children}
        </DialogContent>
        <DialogActions>
            <Button  onClick={()=> setOpen(false) } >Cerrar</Button>
        </DialogActions>
      </Dialog>
    </>
  )
}

export default AppModal
