import { Box, IconButton, Tooltip } from '@mui/material'
import React from 'react'
import MenuIcon from '@mui/icons-material/Menu';

const MainMobileMenu = ({setIsOpen}) => {
    return (
        <>
        <Box sx={{display:{sm:"none"}}} >
        <Tooltip title="Menu" >
                <IconButton onClick={() => setIsOpen(true)} size='large' >
                    <MenuIcon />
                </IconButton>
            </Tooltip>
        </Box>
        </>
    )
}

export default MainMobileMenu
