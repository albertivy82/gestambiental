import React from 'react';
import ReactDOM from 'react-dom/client';
import './core/imports.css';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter, Route, Routes  } from 'react-router-dom';
import GlobalStyles from './core/globalStyles';
import DefaultLayout from './app/layouts/Default/Default.layout';
import Routex from './app/routes';
import { ConfigProvider } from 'antd';
import ptBR from 'antd/lib/locale/pt_BR';


const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
      <ConfigProvider locale={ptBR}>
        <BrowserRouter>
        <DefaultLayout>
          <Routex/>
        </DefaultLayout>
      </BrowserRouter>
      <GlobalStyles/>
      </ConfigProvider> 
    </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals



reportWebVitals();
