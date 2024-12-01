import { createSlice } from '@reduxjs/toolkit'

const initialState = {
    jwt:null,
    expirated:null,
    session:null
}

export const authenticationSlice = createSlice({
    name:"authentication",
    initialState,
    reducers:{
        setTokenJwt: (state,action) => {
            state.jwt = action.payload,
            state.session = "Authenticated"
        },
        logout:(state) => {
            state.jwt = "",
            state.session = "Logout"
        }
    }
})

export const {setTokenJwt , logout} = authenticationSlice.actions;
export const getTokenJwt = (state) => state.authentication.jwt;
export default authenticationSlice.reducer;