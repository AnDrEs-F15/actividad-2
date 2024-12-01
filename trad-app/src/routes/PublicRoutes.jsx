import React from 'react'
import { Navigate, Route } from 'react-router-dom';
import {useSelector} from "react-redux";

const PublicRoutes = ({children}) => {
    const getSession = useSelector(state => state.persistedReducer.authentication )
    if (getSession.session == "Authenticated") return (<Navigate to={"/"} />)
    else return (children)

}

export default PublicRoutes