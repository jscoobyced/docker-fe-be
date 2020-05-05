import * as Config from '../config/config';
import HttpService from '../http/http';

interface HelloMessage {
  hello: string
}

export default class DataService {
  private httpService: HttpService;

  constructor(httpService: HttpService) {
    this.httpService = httpService;
  }

  public getHelloScala = async (): Promise<HelloMessage> => this.get('hello')

  private get = async <T>(service: String, parameters?: (string | number)[]): Promise<T> => {
    const server = Config.getApplicationConfig().Server;
    const port = Config.getApplicationConfig().Port;
    const url = `http://${server}:${port}/${service}`;
    return this.httpService.fetchData<T>(url);
  }
}
