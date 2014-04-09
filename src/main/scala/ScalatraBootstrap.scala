
import _root_.akka.actor.{ActorSystem, Props}
import hu.zomg.tumblrplus._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {


  val system = ActorSystem()
  val myActor = system.actorOf(Props[HelloActor])

  override def init(context: ServletContext) {
    context.mount(new MyScalatraServlet, "/*")
    context.mount(new HelloActorApp(system, myActor), "/hello/*")
    context.mount(new TumblrFuckr(system), "/f/*")
  }

  override def destroy(context: ServletContext) = system.shutdown()
}
