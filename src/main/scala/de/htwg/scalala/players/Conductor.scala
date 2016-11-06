package de.htwg.scalala.players

import scala.language.postfixOps

import akka.actor._
import akka.actor.Scheduler
import scala.concurrent.duration._
import system.dispatcher
import scala.language.postfixOps
import de.htwg.scalala.music._

class Conductor() extends Actor {
  var measure: Measure = new Measure()
  var barNum: Int = 0
  var beatNum: Int = 0
  var tickNum: Int = 0
  def increment = {
    tickNum += 1
    while (tickNum >= (96 / measure.beatLength)) {
      tickNum -= (96 / measure.beatLength)
      beatNum += 1
    }
    while (beatNum >= measure.beats) {
      beatNum -= measure.beats
      barNum += 1
    }
  }                                            //1s initial delay
  val cancellable = system.scheduler.schedule(1000 milliseconds, Measure.tickDuration milliseconds, self, Tick(barNum, beatNum, tickNum))
  var actors: List[ActorRef] = List()

  def receive = {
    case Start => println("Conductor Started")
    case Stop => cancellable.cancel(); println("Conductor Stopped")
    case Add(player) => actors = player.actor :: actors
    case Tick(barNum, beatNum, tickNum) => actors.foreach(_ ! Tick(this.barNum, this.beatNum, this.tickNum)); increment
    case m: Measure => measure = m
  }

}
