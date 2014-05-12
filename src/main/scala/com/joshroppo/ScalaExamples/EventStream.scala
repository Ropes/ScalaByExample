package com.joshroppo.ScalaExamples

import akka.actor.{Actor, Props, ActorSystem}

class Subscriber(func: (String, Any) => Unit) extends Actor {
    override def receive = { case (topic: String, payload: Any) => func(topic, payload) }
}


object EventStream{
    val system = ActorSystem("actorsys")

    def subscribe(func: (String, Any) => Option[Unit], name: String)={
        val props = Props(classOf[Subscriber], func)
        val subscriber = system.actorOf(props, name = name)
        system.eventStream.subscribe(subscriber, classOf[(String, Any)])
    }

    def publish(topic: String, payload: Any){
        system.eventStream.publish(topic, payload)
    }
}

