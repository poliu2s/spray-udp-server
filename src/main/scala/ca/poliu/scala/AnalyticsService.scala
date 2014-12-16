package ca.poliu.scala

import akka.actor.{ActorRef, Actor}
import akka.io.Udp

class AnalyticsServiceActor extends Actor with AnalyticsService {
  def actorRefFactor = context

  def receive = {

    case Udp.Received(data, remote) =>
      println("UDP Datagram Received")
      println(data.utf8String)

    case _ =>
      println("Got something else")
  }
}

trait AnalyticsService {}