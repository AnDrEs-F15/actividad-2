import React from 'react'
import { Route } from 'react-router-dom';
import Home from '../views/Budget/Home';
const ManagerRoutes = () => {
    let availableRoutes = [];
    if(true){
      availableRoutes.push( <Route path='/' element={<Home />} key={"HOME"} /> )
      availableRoutes.push(<Route path='/example' element={<Home />} key={"EXAMPLE"}  />)
    }
  return (
    <>
        {availableRoutes}
    </>
  )
}

export default ManagerRoutes