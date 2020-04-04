const config = require('./config.json');

export const getApplicationConfig = () => ({
  Port: config.api.port,
});

export const getCopyright = () => ({
  Year: config.copyright.year,
  Author: config.copyright.author,
});
