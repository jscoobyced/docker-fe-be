
import * as Config from '../config/config';
import HttpService from '../http/http';

interface Parameter {
  name: string;
  value: string | number;
}

interface HelloMessage {
  hello: string
}

export default class DataService {
  private httpService: HttpService;

  private mode: string;

  constructor(mode: string, httpService: HttpService) {
    this.mode = mode;
    this.httpService = httpService;
  }

  public getHelloScala = async (): Promise<HelloMessage> => this.get('hello')

  public getHelloScalaWithParameters = async (): Promise<HelloMessage> => {
    const parameters = {
      name: "page",
      value: 0
    }
    return this.get('hello', [parameters]);
  }

  private get = async <T>(service: String, parameters?: Parameter[]): Promise<T> => {
    const applicationConfiguration = Config.getApplicationConfig(this.mode);
    const server = applicationConfiguration.Server;
    const port = applicationConfiguration.Port;
    const queryString = parameters ? `?${parameters
      .map(parameter => `${parameter.name}=${parameter.value}`)
      .join('&')}` : '';
    const secure = applicationConfiguration.isSecure ? 's' : '';
    const url = `http${secure}://${server}:${port}/${service}${queryString}`;
    return this.httpService.fetchData<T>(url);
  }
}
