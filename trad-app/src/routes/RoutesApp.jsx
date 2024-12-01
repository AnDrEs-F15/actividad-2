import React from 'react'
import { Routes,Route, Outlet } from 'react-router-dom'
import Login from '../views/AuthenticationView/LoginView/Login'
import Signin from '../views/AuthenticationView/SigninView/Signin'
import VerifyAccount from '../views/AuthenticationView/VerifyAccountView/VerifyAccount'
import ManagerPublicRoutes from './ManagerPublicRoutes'
import ManagerRoutes from './ManagerRoutes'
import ProtectedRoute from './ProtectedRoute'
import PublicRoutes from './PublicRoutes'
import LayoutMain from '../../layout/LayoutMain'

const RoutesApp = () => {
  return (
    <>
        <Routes >
            <Route path='/' element={<ProtectedRoute><Outlet /></ProtectedRoute>}  >
                {ManagerRoutes()}
            </Route>
            <Route element={ <PublicRoutes><Outlet /></PublicRoutes> }>
                {ManagerPublicRoutes()}
            </Route>
            <Route path='*' element={"404"}  />
              

        </Routes>
    </>
  )
}

export default RoutesApp