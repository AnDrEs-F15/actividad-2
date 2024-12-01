import { Button, Card, CardActions, CardContent, CardHeader, Grid, Typography } from '@mui/material'
import { Box } from '@mui/system'
import React from 'react'
import FullscreenIcon from '@mui/icons-material/Fullscreen';
import VisibilityIcon from '@mui/icons-material/Visibility';
const BudgetCard = () => {
  return (
    <>
      <Box>
        <Card sx={{maxWidth:320 , maxHeight:300 , color:"gray" }} elevation={4}  >
            <CardHeader title={ <Typography variant='h6'>04/05/2024</Typography> } ></CardHeader>
            <CardContent>
                <Typography> Commodi excepturi deserunt sunt unde possimus beatae consequuntur?</Typography>
                <Typography>Presupuesto: 3.500.000</Typography>
            </CardContent>
            <CardActions sx={{display:"flex" , justifyContent:"end"  }} >
                <Button variant='contained' size='small'  endIcon={<FullscreenIcon />} >Ver</Button>
            </CardActions>
        </Card>
      </Box>
    </>
  )
}

export default BudgetCard
