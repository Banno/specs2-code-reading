package com.banno

import akka.actor.Actor
import akka.dispatch.Future
import akka.actor.PoisonPill
import Actor._
import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import org.specs2.matcher._

class LearningSpec extends Specification {

  class MyActor extends Actor {
    def receive = {
      case _ =>
        Thread.sleep(500)
        self.reply("hello")
    }
  }

  "MyActor" should {
    "say hello" in new context {
      val reply = sayHey
      reply.result must eventually { beSome("hello") }
    }

    "kill my actor" in new context {
      myActor ! PoisonPill
      success
    }
  }

  trait context extends Scope {
    val myActor = actorOf(new MyActor).start

    def sayHey: Future[Any] = myActor !!! "Hey"
  }

  "Numbers" should {
    val beGreaterThan3: Matcher[Int] = ((i: Int) => i > 3,
                                        (i: Int) => "%s was not greater than 3".format(i))
      
    "be greater than 3" in {
      4 must beGreaterThan3
    }
  }
  
}
