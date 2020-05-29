package jscbe.modules

import com.google.inject.AbstractModule
import jscbe.configuration.{Configuration, RawConfiguration}
import net.codingwell.scalaguice.ScalaModule

class ConfigurationModule extends AbstractModule with ScalaModule {
  override def configure(): Unit = {

    val rawConfiguration = RawConfiguration(Configuration.getConfig)
    bind[RawConfiguration].toInstance(rawConfiguration)
  }
}
