import { configureStore , combineReducers } from "@reduxjs/toolkit";
import authenticationSlice from "./slices/authenticationSlice";
import tradStatusSlice  from "./slices/tradStatusSlice";
import storage from "redux-persist/lib/storage";
import {encryptTransform} from "redux-persist-transform-encrypt";
import { persistReducer, persistStore } from "redux-persist";
import {thunk} from "redux-thunk"; 


const encriptor = encryptTransform ({secretKey:"temporal"})

const persistConfig =  {
    timeout:100,
    key:"tradPersist",
    storage,
    encriptor,
    expireIn : 24*60*60,
    whiteList : ["authentication"]
}

const rootReducer = combineReducers({
    authentication:authenticationSlice
})

const persistedReducer = persistReducer(persistConfig,rootReducer)

export const store = configureStore({
    reducer: {
        persistedReducer,
        authentication: authenticationSlice,
        tradStatus: tradStatusSlice,
    },
    middleware: () => [thunk]
})

export const persistor = persistStore(store)