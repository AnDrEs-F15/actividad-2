
import "../public/css/styleSignin.css"
import logo from "../src/assets/img/tradlogo.png"
import { Box } from '@mui/system'
import Grid from '@mui/material/Grid';

const LayoutAuth = ({children}) => {
    return (
        <>
            <Grid
                container
                display={"grid"}
                gridTemplateColumns={{ sm: "2.5fr 1fr", xs: "1fr", md: "1fr 1.5fr" }}
                width={{ md: "100%" }}
                style={{ minHeight: '100vh' }}
                justifyContent={{ sm: "center", xs: "center", md: "center" }}
                alignItems="center"
            >
                <Box
                    justifyContent="center"
                    display={"flex"}
                    flexDirection="column"
                    alignContent={"center"}
                    alignItems={"center"}
                    gap={2}
                >
                    <img src={logo} width="200" />
                    {children}
                </Box>
                <Box
                    display={{ xs: "none", sm: "block", md: "block" }}
                    width={"100%"}
                >
                    <img className='imgportada' src='https://images.unsplash.com/photo-1504868584819-f8e8b4b6d7e3?q=80&w=1476&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D' />
                </Box>
            </Grid>
        </>
    )
}

export default LayoutAuth
