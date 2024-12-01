import { Backdrop } from '@mui/material'
import React from 'react'
import { useSelector } from 'react-redux';
import CircularProgress from '@mui/material/CircularProgress';

const TradLoading = () => {
    const isLoading = useSelector((state)=> state.tradStatus.isLoading.isLoading)
  return (
    <>
      <Backdrop
        open={isLoading?true:false}
        sx={{ color: '#fff', zIndex: (theme) => theme.zIndex.drawer + 1 }}
      >
        <CircularProgress  />
      </Backdrop>
    </>
  )
}

export default TradLoading
