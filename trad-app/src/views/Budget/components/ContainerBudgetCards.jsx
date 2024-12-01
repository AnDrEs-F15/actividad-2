import { Box } from '@mui/system'
import React from 'react'
import BudgetCard from './BudgetCard'

const ContainerBudgetCards = () => {
  return (
    <>
      <Box display={"flex"} gap={2} flexWrap={"wrap"} justifyContent={"center"} alignContent={"center"} >
        <BudgetCard />
        <BudgetCard />
        <BudgetCard />
        <BudgetCard />
        <BudgetCard />
        <BudgetCard />
        <BudgetCard />
        <BudgetCard />
      </Box>
    </>
  )
}

export default ContainerBudgetCards
