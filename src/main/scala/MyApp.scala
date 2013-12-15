import spray.routing.HttpService
import akka.actor._
import akka.io.IO
import spray.can.Http
import spray.json._
import DefaultJsonProtocol._

object MyApp extends App {
  implicit val system = ActorSystem()
  val service = system.actorOf(Props[AppService])

  IO(Http) ! Http.Bind(service, "localhost", port = 3001)
}

case class Person(id: Int, firstName: String, lastName: String)
object PersonProtocol extends DefaultJsonProtocol {
  implicit val personFormat = jsonFormat3(Person)
}

class AppService extends Actor with HttpService {
  import PersonProtocol._
  val people = List(Person(1, "hanh", "huynh"), Person(2, "caro", "ng"))

  val route =
    pathPrefix("be") {
      path("people") {
        get {
          complete {
            val json = JsObject("persons" -> people.toJson)
            json.compactPrint
          }
        }
      }
    }

  def actorRefFactory = context
  def receive = runRoute(route)
}
