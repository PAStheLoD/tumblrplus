package hu.zomg.tumblrplus

import akka.actor.{Actor, ActorRef, ActorSystem}
import org.scalatra.{Accepted, FutureSupport, ScalatraServlet}

import scala.concurrent.ExecutionContext
import akka.util.Timeout

import scala.concurrent.duration._

/**
 * Created by pas on 2014.04.07..
 */

class HelloActorApp(system: ActorSystem, myActor:ActorRef) extends ScalatraServlet with FutureSupport {
  import _root_.akka.pattern.ask
  implicit val timeout = Timeout(10 seconds)

  get("/async") {
    myActor ? "HELLO!"
  }


  get("/fof") {
    myActor ! "BOOM!"
    Accepted()
  }

  protected implicit def executor: ExecutionContext = system.dispatcher
}

class HelloActor extends Actor {
  def receive = {
    case "HELLO!" => sender ! "nice to see you too"
    case "BOOM!" => println("oh noes!")
  }
}
