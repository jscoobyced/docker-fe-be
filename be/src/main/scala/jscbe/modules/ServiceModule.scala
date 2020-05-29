package jscbe.modules

import com.google.inject.AbstractModule
import jscbe.services.sample.{SampleService, SampleServiceImpl}
import net.codingwell.scalaguice.ScalaModule

import scala.concurrent.ExecutionContext

class ServiceModule(implicit executionContext: ExecutionContext) extends AbstractModule with ScalaModule {
  override def configure(): Unit =
    bind[SampleService].to[SampleServiceImpl].in[com.google.inject.Singleton]
}
