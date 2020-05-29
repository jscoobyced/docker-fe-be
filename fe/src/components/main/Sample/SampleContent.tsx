import * as React from 'react';
import { getApplicationConfig } from '../../../services/config/config';
import { AppContext } from '../../../services/context/context';
import './SampleContent.scss';

export const SampleContent = () => {
  const [hello, setHello] = React.useState('Nothing...');
  const { dataService } = React.useContext(AppContext);
  const mode = process.env.mode as string;
  const server = getApplicationConfig(mode).Server;
  const port = getApplicationConfig(mode).Port;

  React.useEffect(() => {
    dataService.getHelloScala()
      .then((data) => {
        if (!data || data.length === 0) setHello('Nothing found...');
        else setHello(data[0].value);
      });
  }, []);

  return (
    <article>
      <p>
        This sample application can run in developer mode with hot-reload.
        <br />
        Simply start it from the
        <strong><i>fe</i></strong>
        folder by typing:
      </p>
      <pre>
        yarn start
      </pre>
      <br />
      <p>
        The API service is running at
        {' '}
        <a
          href={`http://${server}:${port}/hello`}
        >
          {`http://${server}:${port}/hello`}
        </a>
        . It says:
        {' '}
        {hello}
        .
      </p>
    </article>
  );
};
