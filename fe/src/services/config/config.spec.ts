import * as Config from './config';

describe('config service', () => {
  it('should contain application data', () => {
    const application = Config.getApplicationConfig();
    expect(application.Port).not.toBeNull();
    expect(application.Port).not.toBeNaN();
    expect(application.Server).not.toBeNull();
  });
});
