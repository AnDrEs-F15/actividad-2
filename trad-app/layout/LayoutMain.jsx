import React from 'react'
import MainDrawer from './components/MainDrawer'
import { Box, Grid } from '@mui/material'
import { useTheme } from '@emotion/react'


const LayoutMain = ({children}) => {
    const theme = useTheme();
    console.log(theme);
    return (
        <>
            <Box display={"flex"}  flexDirection={{sm:"row-reverse", md:"row-reverse",xs:"column"}}  sx={{ height:"100%" ,  backgroundColor:theme.palette.back.main }} py={2}  >
                <Box  component={"nav"} flexBasis={{sm:"35%" , md:"25%", lg:"18%" , xs:"5%" }} flexShrink={0} sx={{backgroundColor:"" , width:"100%" , height:"100vh" }}  >
                    <MainDrawer />
                </Box>
                <Box  component={"main"}   display={"flex"} justifyContent={"center"} alignContent={"center"} height={"100%"} width={"100%"}   sx={{ backgroundColor:theme.palette.back.main  }} >
                    <Box bgcolor={"white"} width={"95%"}  p={1} >
                        {children}
                    </Box>
                </Box>
            </Box>

        </>
    )
}

/* 
<Grid container  direction={{sm:"row", md:"row",xs:"column"}}  sx={{ height:"100vh" ,  backgroundColor:theme.palette.back.main }}   >
<Grid item xs={1} md={3} sm={4}  sx={{backgroundColor:"blue" , width:"100%" }}  >
    <MainDrawer />
</Grid>
<Grid item xs={11} md={9} sm={8} component={"main"} py={2} height={"100vh"} width={"100%"}  margin={"auto"} sx={{ backgroundColor: "red"}} >
    <Box bgcolor={"white"} paddingY={4} paddingX={2} width={"90%"} margin={"auto"} >
        {children}
    </Box>
</Grid>
</Grid> */

export default LayoutMain
