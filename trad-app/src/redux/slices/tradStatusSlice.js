import { createSlice } from '@reduxjs/toolkit'

const initialState = {
    isLoading: false,
    error: {
        status: null,
        message: null
    }
}

export const tradStatusSlice = createSlice({
    name:"tradStatus",
    initialState,
    reducers:{
        setTradStatus: (state,action) => {
            const {isLoading , error } = action.payload
            state.isLoading = isLoading;
            state. error = error;
        },
        setLoading: (state,action)=>{
            state.isLoading = action.payload
        },
        setHandleError:(state,action)=>{
            state.error = action.payload;
        }
    }
})

export const {setTradStatus,setLoading,setHandleError} = tradStatusSlice.actions;
/* export const getTokenJwt = (state) => state.tradStatus.jwt; */
export default tradStatusSlice.reducer;