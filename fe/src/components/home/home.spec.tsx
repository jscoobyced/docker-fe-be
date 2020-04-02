import { shallow } from 'enzyme';
import * as React from 'react';
import { Home } from './home';

describe('Home', () => {
  it('should display a h1 element', () => {
    const home = shallow(<Home />);
    expect(home.find('h1')).toHaveLength(1);
  });
});
