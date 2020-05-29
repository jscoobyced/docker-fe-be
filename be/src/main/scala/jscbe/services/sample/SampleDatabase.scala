package jscbe.services.sample

import java.util.Date

import com.google.inject.Inject
import jscbe.models.http.sample.Sample
import jscbe.repositories.mappers.SampleMapper
import jscbe.repositories.db.{DatabaseRepository, Parameter}

class SampleDatabase @Inject()(databaseRepository: DatabaseRepository) {
  private val getSampleListSql: String = "SELECT id, value, created, modified FROM sample " +
    "WHERE status = 0 ORDER BY created DESC, modified DESC LIMIT 5"
  private val insertSampleSql = "INSERT INTO sample (value, created, modified, status) VALUES (?, ?, ?, 0)"
  private val updateSampleSql = "UPDATE sample SET value = ?, modified = ? WHERE id = ?"

  def getSampleList: List[Sample] =
    databaseRepository
      .executeQuery(getSampleListSql, None, SampleMapper.toSample)

  def saveSample(sample: Sample): Int =
    databaseRepository
      .executeSingleUpdate(
        insertSampleSql,
        Some(List(Parameter(1, sample.value), Parameter(2, new Date()), Parameter(3, new Date())))) match {
      case 0       => 0
      case id: Int => id
    }

  def updateSample(id: Int, sample: Sample): Boolean =
    databaseRepository.executeUpdate(
      updateSampleSql,
      Some(List(List(Parameter(1, sample.value), Parameter(2, new Date()), Parameter(3, id))))) == 1

}
