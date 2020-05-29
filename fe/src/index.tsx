import * as React from 'react';
import * as ReactDOM from 'react-dom';
import { Home } from './components/main/Home/Home';
import HttpService from './services/http/http';
import HttpServiceMock from './services/http/http.mock';
import './styles/_main.scss';

/* eslint-disable */
let httpService;

const mode = process.env.mode as string;
if (mode === 'development') {
  httpService = new HttpServiceMock([{ value: "Hello, Scala!" }]);
} else {
  httpService = new HttpService();
}

ReactDOM.render(
  <Home httpService={httpService} mode={mode} />,
  document.getElementById('root'),
);
