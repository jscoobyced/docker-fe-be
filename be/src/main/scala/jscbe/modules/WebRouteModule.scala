package jscbe.modules

import com.google.inject.AbstractModule
import jscbe.routes.{SampleRoute, WebRoute}
import net.codingwell.scalaguice.{ScalaModule, ScalaMultibinder}

class WebRouteModule extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
    val routesMultiBinding = ScalaMultibinder.newSetBinder[WebRoute](binder)
    routesMultiBinding.addBinding.to[SampleRoute]
    ()
  }
}
