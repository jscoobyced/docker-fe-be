import * as React from 'react';
import { Route, Switch } from 'react-router-dom';
import { SampleContent } from './main/Sample/SampleContent';

export const Routes = () => (
  <Switch>
    <Route exact path="/" component={SampleContent} />
  </Switch>
);
