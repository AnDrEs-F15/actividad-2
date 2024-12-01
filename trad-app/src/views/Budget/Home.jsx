import { useTheme } from '@emotion/react'
import { Button, Typography } from '@mui/material'
import { Box } from '@mui/system'
import React from 'react'
import BudgetCard from './components/BudgetCard'
import ContainerBudgetCards from './components/ContainerBudgetCards'
import ActionsHeaderBudget from './components/ActionsHeaderBudget'

const Home = () => {
  const theme = useTheme()
  return (
    <>
       <Box bgcolor={theme.palette.back.main } p={1} color={theme.palette.primary.main } display={"flex"} justifyContent={"space-between"} flexDirection={{sm:"row", md:"row",xs:"column"}} gap={1} >
          <Box><Typography variant='h5' >Modulo Presupuestos</Typography></Box>
          <Box>
              <ActionsHeaderBudget />
          </Box>
       </Box>
       <Box py={2} >
          <ContainerBudgetCards />
       </Box>
    </>
  )
}

export default Home