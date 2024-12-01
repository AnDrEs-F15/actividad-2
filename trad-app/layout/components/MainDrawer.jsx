import { Box, Button, Drawer, IconButton, Tooltip, useMediaQuery } from '@mui/material'
import React, { useState } from 'react'
import MainListDrawer from './MainListDrawer'
import logo from "../../src/assets/img/tradlogo.png"
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import MainMobileMenu from './MainMobileMenu';
import { useTheme } from '@emotion/react';

const MainDrawer = () => {
    const [isOpen, setIsOpen] = useState(false);
    const screem = useMediaQuery("(max-width:600px)");
    const theme = useTheme();

    return (
        <>
            <MainMobileMenu setIsOpen={setIsOpen} />
            <Drawer
                anchor='right'
                variant={screem ? "temporary" : "permanent"}
                open={isOpen}
                onClose={() => setIsOpen(false)}
                PaperProps={{
                    sx:{
                        backgroundColor:theme.palette.primary.main,
                        boxShadow: "2px 2px 12px rgba(0, 0, 0, 0.5)",
                        display:"flex",
                        flexShrink:1
                    }
                }}
                
            >
                <Box marginX={"auto"} marginTop={6} paddingX={2} marginBottom={2}  >
                    <img src={logo} width={180} />
                </Box>
                <Box  width={"90%"} sx={{ display: { sm: "none", md: "none", xs: "flex" } }}  >
                    <IconButton onClick={() => setIsOpen(false)} >
                        <Tooltip title="Cerrar" >
                            <ArrowBackIcon sx={{color:"white"}} />
                        </Tooltip>
                    </IconButton>
                </Box>
                <MainListDrawer />
            </Drawer>
        </>
    )
}

export default MainDrawer
