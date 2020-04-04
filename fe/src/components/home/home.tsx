import * as React from 'react';
import './home.scss';
import * as Config from '../../services/config/config';

export const Home = () => (
  <>
    <header>
      <h1>Hello, TypeScript + React!</h1>
    </header>
    <div className="container">
      <section>
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
            href={`http://localhost:${Config.getApplicationConfig().Port}`}
          >
            {`http://localhost:${Config.getApplicationConfig().Port}`}
          </a>
          .
        </p>
      </section>
    </div>
    <footer>
      &copy; Copyright
      {' '}
      {Config.getCopyright().Year}
      {' '}
      {Config.getCopyright().Author}
    </footer>
  </>
);
