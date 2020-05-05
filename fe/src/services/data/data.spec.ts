import DataService from './data';
import HttpServiceMock from '../http/http.mock';

const getDataService = (mockedValue: String): DataService => {
  const httpService = new HttpServiceMock(mockedValue);
  const dataService = new DataService(httpService);
  return dataService;
};

describe('data service', () => {
  const mockSuccessResponse = 'Hello, Scala!';
  it('should return blog data', async () => {
    const result = await getDataService(mockSuccessResponse).getHelloScala();
    expect(result).toEqual(mockSuccessResponse);
  });
});
