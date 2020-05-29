package jscbe.modules

import com.google.inject.AbstractModule
import jscbe.repositories.mysql.MysqlRepository
import jscbe.repositories.{DatabaseRepository, SqlConnectionCreator, SqlConnectionCreatorImpl}
import net.codingwell.scalaguice.ScalaModule

class RepositoryModule() extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
    bind[SqlConnectionCreator].to[SqlConnectionCreatorImpl].in[com.google.inject.Singleton]
    bind[DatabaseRepository].to[MysqlRepository].in[com.google.inject.Singleton]
  }

}
