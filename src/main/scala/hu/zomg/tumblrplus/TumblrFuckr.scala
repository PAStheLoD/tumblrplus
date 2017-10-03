package hu.zomg.tumblrplus

import org.scalatra.{AsyncResult, FutureSupport, ScalatraServlet}
import akka.actor.ActorSystem
import scala.concurrent.{Promise, Future, ExecutionContext}
import dispatch._
import scala.util.{Success, Failure, Left, Try}


/**
 * Created by pas on 2014.04.07..
 */


object DispatchAkka {

  val http = dispatch.Http.withConfiguration(_ setFollowRedirect true)

  def retrievePage()(implicit ctx: ExecutionContext): Future[String] = {
    val prom = Promise[String]()

    http(url("http://tumblr.com/") OK as.String) onComplete {
      case r => r match {
        case Failure(exception) => println(exception)
        case Success(content) => prom.complete(Try{content})
      }
    }

    prom.future
  }
}

class TumblrFuckr(system: ActorSystem) extends ScalatraServlet with FutureSupport{
  protected implicit def executor: ExecutionContext = system.dispatcher

  get("/zzz") {
    new AsyncResult() {
      contentType = "text/html"
      val is = DispatchAkka.retrievePage()
      println(is)
      is onComplete {
        case x => x match {
          case Success(res) => res
          case Failure(ex) => { println(ex) ; "WTF!" }
          case _ => "huh!?"
        }
      }
    }
  }

  get("/what") {
    "WTF"
  }
}
