import * as Config from './config';

describe('config service', () => {
  it('should contain development application data', () => {
    const application = Config.getApplicationConfig('development');
    expect(application.Port).not.toBeNull();
    expect(application.Port).not.toBeNaN();
    expect(application.Server).not.toBeNull();
    expect(application.isSecure).toBeFalsy();
  });

  it('should contain production application data', () => {
    const application = Config.getApplicationConfig('production');
    expect(application.Port).not.toBeNull();
    expect(application.Port).not.toBeNaN();
    expect(application.Server).not.toBeNull();
    expect(application.isSecure).toBeTruthy();
  });
});
