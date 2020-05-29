package jscbe.services.sample

import com.google.inject.Inject
import jscbe.models.http.sample.Sample
import jscbe.repositories.db.DatabaseRepository
import jscbe.routes.JsonSupport

import scala.concurrent.ExecutionContext

trait SampleService {
  def getSampleList: List[Sample]
  def saveSample(sample: Sample): Int
  def updateSample(id: Int, sample: Sample): Boolean
}

class SampleServiceImpl @Inject()(private val databaseRepository: DatabaseRepository)(
    implicit private val executionContext: ExecutionContext)
    extends SampleService
    with JsonSupport {
  val database = new SampleDatabase(databaseRepository)

  override def getSampleList: List[Sample] = database.getSampleList

  override def saveSample(sample: Sample): Int = database.saveSample(sample)

  override def updateSample(id: Int, sample: Sample): Boolean = database.updateSample(id, sample)

}
