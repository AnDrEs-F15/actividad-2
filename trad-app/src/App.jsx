import { ThemeProvider } from '@mui/system'
import React from 'react'
import { theme } from '../config/themeConfigMaterialUi'
import TradLoading from './components/TradLoading'
import RoutesApp from './routes/RoutesApp'


const App = () => {
  return (
    <>
      <ThemeProvider theme={theme} >
        <TradLoading />
        <RoutesApp />
      </ThemeProvider>
    </>
  )
}

export default App