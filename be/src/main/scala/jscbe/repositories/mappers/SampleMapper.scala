package jscbe.repositories.mappers

import java.sql.ResultSet

import jscbe.models.http.sample.Sample

object SampleMapper extends AbstractMapper {

  def toSample(resultSet: ResultSet): List[Sample] = {
    val sampleIterator = resultSetIterator(resultSet)
    val helloList = sampleIterator.map(result => {
      Sample(
        result.getInt(1),
        result.getString(2),
        result.getDate(3).toString,
        result.getDate(4).toString
      )
    })
    helloList.toList
  }

}
