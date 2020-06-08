package jscbe.routes

import akka.http.scaladsl.model.headers.RawHeader
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.google.inject.Inject
import jscbe.configuration.HttpConfigurationImpl
import jscbe.models.http.sample.Sample
import jscbe.models.http.{FailResponse, ResponseData, SuccessResponse}
import jscbe.services.sample.SampleService

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success, Try}

// $COVERAGE-OFF$
class SampleRoute @Inject()(implicit executionContext: ExecutionContext, private val sampleService: SampleService)
    extends BaseRoute {
  override protected def routes: Route = sampleRoutes

  val origin: String = HttpConfigurationImpl.getOrigin
  def sampleRoutes: Route = concat(
    path("hello") {
      get {
        respondWithHeaders(RawHeader("Access-Control-Allow-Origin", origin)) {
          val hello =
            if (sampleService.getSampleList.nonEmpty) sampleService.getSampleList
            else List(Sample(-1, "No result found.", "", ""))
          complete(hello)
        }
      }
    },
    pathPrefix("hello") {
      pathEnd {
        post {
          decodeRequest {
            entity(as[Sample]) { sample =>
              respondWithHeaders(RawHeader("Access-Control-Allow-Origin", origin)) {
                val insertedId = sampleService.saveSample(sample)
                if (insertedId > 0)
                  complete(SuccessResponse(ResponseData("Sample saved successfully", insertedId)))
                else complete(FailResponse("Sample not saved."))
              }
            }
          }
        }
      } ~
        path(Segment) {
          id =>
            put {
              decodeRequest {
                entity(as[Sample]) {
                  sample =>
                    respondWithHeaders(RawHeader("Access-Control-Allow-Origin", origin)) {
                      Try(id.toInt) match {
                        case Success(sampleId) =>
                          val result = sampleService.updateSample(sampleId, sample)
                          if (result)
                            complete(SuccessResponse(ResponseData("Sample updated successfully", sampleId)))
                          else complete(FailResponse("Sample not saved."))
                        case Failure(error) =>
                          complete(FailResponse(s"Not a sample reference. ${error.getMessage}"))
                      }
                    }
                }
              }
            }
        }
    }
  )
}
// $COVERAGE-ON$
