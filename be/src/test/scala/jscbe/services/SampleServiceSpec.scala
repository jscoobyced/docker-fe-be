package jscbe.services

import jscbe.BaseTest
import jscbe.models.http.sample.Sample
import jscbe.repositories.DatabaseRepositoryMock
import jscbe.services.sample.SampleServiceImpl

class SampleServiceSpec extends BaseTest {
  val expectedSample: Sample = Sample(1, "test", "now", "now")
  describe("A SampleService") {
    it("should be able to get sample list") {
      val sampleService = new SampleServiceImpl(
        new DatabaseRepositoryMock(samples = Iterator(List(expectedSample)), updated = Iterator(1), single = 1)
      )
      assert(sampleService.getSampleList.nonEmpty)
    }
    it("should be able to save a sample") {
      val sampleService = new SampleServiceImpl(
        new DatabaseRepositoryMock(samples = Iterator(List(expectedSample)), updated = Iterator(1), single = 1)
      )
      assert(sampleService.saveSample(expectedSample) == expectedSample.id)
    }
    it("should be able to update a sample") {
      val sampleService = new SampleServiceImpl(
        new DatabaseRepositoryMock(samples = Iterator(List(expectedSample)), updated = Iterator(1), single = 1)
      )
      assert(sampleService.updateSample(1, expectedSample))
    }
  }
}
