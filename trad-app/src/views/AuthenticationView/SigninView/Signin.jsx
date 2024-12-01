import React from 'react'
import SigninForm from './SigninForm'
import Typography from '@mui/material/Typography';
import LayoutAuth from '../../../../layout/LayoutAuth';

const Signin = () => {
    return (
        <>
            <LayoutAuth>
                <SigninForm />
            </LayoutAuth>
        </>
    )
}

export default Signin