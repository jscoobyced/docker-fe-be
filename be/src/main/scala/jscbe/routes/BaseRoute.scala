package jscbe.routes

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives.{complete, handleExceptions}
import akka.http.scaladsl.server.{ExceptionHandler, Route}
import jscbe.models.http.sample.Sample
import jscbe.models.http.{FailResponse, ResponseData, SuccessResponse}
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

trait WebRoute {
  val route: Route
}

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val failedResponse: RootJsonFormat[FailResponse]           = jsonFormat1(FailResponse)
  implicit val responseDataFormat: RootJsonFormat[ResponseData]       = jsonFormat2(ResponseData)
  implicit val successResponseFormat: RootJsonFormat[SuccessResponse] = jsonFormat1(SuccessResponse)
  implicit val sampleFormat: RootJsonFormat[Sample]                   = jsonFormat4(Sample)
}

abstract class BaseRoute extends WebRoute with JsonSupport {

  implicit protected def unhandledExceptionsHandler: ExceptionHandler =
    ExceptionHandler {
      case e: Exception =>
        complete(StatusCodes.InternalServerError -> FailResponse(e.getMessage))
    }

  final override val route: Route = handleExceptions(unhandledExceptionsHandler) {
    routes
  }

  protected def routes: Route
}
