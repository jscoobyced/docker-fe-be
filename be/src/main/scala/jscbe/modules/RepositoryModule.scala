package jscbe.modules

import com.google.inject.AbstractModule
import jscbe.repositories.db.{DatabaseRepository, DatabaseRepositoryImpl}
import net.codingwell.scalaguice.ScalaModule

class RepositoryModule() extends AbstractModule with ScalaModule {
  override def configure(): Unit =
    bind[DatabaseRepository].to[DatabaseRepositoryImpl].in[com.google.inject.Singleton]
}
