import * as React from 'react';
import * as ReactDOM from 'react-dom';
import { Home } from './components/main/Home/Home';
import HttpService from './services/http/http';
import './styles/_main.scss';

const httpService = new HttpService();

ReactDOM.render(
  <Home httpService={httpService} />,
  document.getElementById('root'),
);
