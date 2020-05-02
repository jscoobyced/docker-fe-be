const config = require('./config.json');

export const getApplicationConfig = () => ({
  Port: config.api.port,
  Server: config.api.server,
});
