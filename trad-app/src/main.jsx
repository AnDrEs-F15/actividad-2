import React from 'react'
import ReactDOM from 'react-dom/client'
import { Provider } from 'react-redux'
import { BrowserRouter } from 'react-router-dom'
import { PersistGate } from 'redux-persist/integration/react'
import App from './App.jsx'
import TradLoading from './components/TradLoading.jsx'
import { store , persistor } from './redux/store.js'

ReactDOM.createRoot(document.getElementById('root')).render(

  <BrowserRouter basename={import.meta.env.VITE_BASE_URL_APP}  >
    <PersistGate persistor={persistor} >
      <Provider store={store} >
        <App />
      </Provider>
    </PersistGate>
  </BrowserRouter>
)
