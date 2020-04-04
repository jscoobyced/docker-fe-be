import { shallow } from 'enzyme';
import * as React from 'react';
import { Home } from './home';

describe('Home', () => {
  it('should display a h1 element', () => {
    const home = shallow(<Home />);
    expect(home.find('header')).toHaveLength(1);
    expect(home.find('.container')).toHaveLength(1);
    expect(home.find('section')).toHaveLength(1);
    expect(home.find('footer')).toHaveLength(1);
  });
});
