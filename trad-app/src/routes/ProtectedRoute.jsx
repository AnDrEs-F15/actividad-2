import React from 'react'
import { Navigate } from 'react-router-dom';
import {useSelector} from "react-redux";
import LayoutMain from '../../layout/LayoutMain';


const ProtectedRoute = ({children}) => {
  const getSession = useSelector(state => state.persistedReducer.authentication )
  if (getSession.session == "Authenticated") {
    return (
      <LayoutMain>
        {children}
      </LayoutMain>
    )
  }else{
    return (<Navigate to={"/login"} />)
  }
}

export default ProtectedRoute
