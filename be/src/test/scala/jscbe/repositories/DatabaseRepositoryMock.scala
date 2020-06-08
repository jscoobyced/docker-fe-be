package jscbe.repositories

import java.sql.ResultSet

import jscbe.repositories.db.{DatabaseRepository, Parameter}

class DatabaseRepositoryMock(private val samples: Iterator[List[Any]] = Iterator(List()),
                             private val single: Int = 1,
                             private val updated: Iterator[Int] = Iterator(1))
    extends DatabaseRepository {

  override def executeQuery[T](sql: String,
                               parameters: Option[List[Parameter]],
                               mapper: ResultSet => List[T]): List[T] =
    samples.next.map(a => a.asInstanceOf[T])

  override def executeSingleUpdate(sql: String, parameters: Option[List[Parameter]]): Int = single

  override def executeUpdate(sql: String, parameters: Option[List[List[Parameter]]]): Int = updated.next
}
