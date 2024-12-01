import { Box, List, ListItem, ListItemButton, ListItemIcon, ListItemText } from '@mui/material'
import React from 'react'
import InboxIcon from '@mui/icons-material/MoveToInbox';
import BalanceIcon from '@mui/icons-material/Balance';
import BlindsIcon from '@mui/icons-material/Blinds';
import FileCopyIcon from '@mui/icons-material/FileCopy';
import LogoutIcon from '@mui/icons-material/Logout';
import { useTheme } from '@emotion/react';
const MainListDrawer = () => {
    const listItems = [
        {
            text: "Presupuestos",
            icon: <BalanceIcon />
        },
        {
            text: "Ahorros",
            icon: <BlindsIcon />
        },
        {
            text: "Inversiones",
            icon: <FileCopyIcon />
        },
        {
            text: "Reportes",
            icon: <InboxIcon />
        },{
            text:"Cerrar sesion",
            icon: <LogoutIcon />
        }
    ]

    const theme = useTheme();
    return (
        <>
                <List>
                    {
                        listItems?.map(item => (
                            <ListItem key={item.text} disablePadding  style={{color:theme.palette.back.main  }}
                                sx={{
                                    '&:hover': {
                                        backgroundColor: theme.palette.primary.light,
                                      },
                                }}
                            >
                                <ListItemButton >
                                    <ListItemIcon style={{color:theme.palette.back.main }}  >
                                        {item.icon}
                                    </ListItemIcon>
                                    <ListItemText primary={item.text} />
                                </ListItemButton>
                            </ListItem>
                        ))
                    }
                </List>
        </>
    )
}

export default MainListDrawer
