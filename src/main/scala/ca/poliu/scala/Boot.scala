package ca.poliu.scala

import java.net.InetSocketAddress

import akka.actor.{ActorSystem, Props}
import akka.io.{Udp, IO}
import akka.pattern.ask
import akka.util.{ByteString, Timeout}
import scala.concurrent.duration._

object Boot extends App {

  // Configs
  val serviceHost = "localhost"
  val port = 8000

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("on-spray-can")

  implicit val timeout = Timeout(5.seconds)


  // Start a new service
  val udpService = system.actorOf(Props[AnalyticsServiceActor], "udp-service")
  val udpServiceAddress = new InetSocketAddress(serviceHost, port)
  IO(Udp) ? Udp.Bind(udpService, udpServiceAddress)

  println("Boot end reached")
}
