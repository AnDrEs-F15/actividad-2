import React from 'react'
import { Route } from 'react-router-dom'
import Login from '../views/AuthenticationView/LoginView/Login'
import Signin from '../views/AuthenticationView/SigninView/Signin'
import VerifyAccount from '../views/AuthenticationView/VerifyAccountView/VerifyAccount'

const ManagerPublicRoutes = () => {
    return (
        <>
            <Route index path='/login' element={<Login />} />
            <Route path='/signin' element={<Signin />} />
            <Route path='/verifyAccount' element={<VerifyAccount />} />
        </>
    )
}

export default ManagerPublicRoutes