import DataService from './data';
import HttpServiceMock from '../http/http.mock';

const getDataService = (mode: string, mockedValue: string): DataService => {
  const httpService = new HttpServiceMock(mockedValue);
  const dataService = new DataService(mode, httpService);
  return dataService;
};

describe('data service', () => {
  const modes = ['development', 'production'];
  modes.forEach(mode => {
    const mockSuccessResponse = 'Hello, Scala!';
    it('should return hello scala', async () => {
      const result = await getDataService(mode, mockSuccessResponse).getHelloScala();
      expect(result).toEqual(mockSuccessResponse);
    });

    it('should return hello scala with parameter call', async () => {
      const result = await getDataService(mode, mockSuccessResponse).getHelloScalaWithParameters();
      expect(result).toEqual(mockSuccessResponse);
    });
  });
});
