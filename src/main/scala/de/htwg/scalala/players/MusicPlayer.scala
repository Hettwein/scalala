package de.htwg.scalala.players

import javax.sound.midi.MidiChannel
import de.htwg.scalala.music.elements._
import de.htwg.scalala.music.sequences._
import akka.actor.Actor
import de.htwg.scalala.music.Music
import akka.actor.ActorRef
import de.htwg.scalala.music._
import de.htwg.scalala.music.events._

class Musician(channel: MidiChannel) extends Actor {

  //  private val beatLength = 175
  var tickList: Seq[Bar] = List()

  def receive = {
    case line: Line => tickList = line.toTickList()//; println("Got list")
    case Tick(barNum, beatNum, tickNum) => {
      if(barNum == tickList.length) {
        sender ! Stop
      } else {
        tickList(barNum).beats(beatNum).ticks(tickNum).events.foreach { e => playEvent(e) }//; println("Got tick " + tickNum)
      }
    }
    case Ping => sender ! Ping
    case rest: Rest => Thread.sleep((rest.duration().toDouble * Measure.tickDuration()).toLong)
    case note: Note => {
      channel.noteOn(note.pitch, note.volume)
      Thread.sleep((note.duration(note.getTiedDuration).toDouble * Measure.tickDuration()).toLong)
      channel.noteOff(note.pitch, note.volume)
    }
    case chord: Chord => {
      val duration = chord.notes.head.duration(chord.notes.head.getTiedDuration)
      chord.notes.foreach { note => channel.noteOn(note.pitch, note.volume) }
      Thread.sleep((duration.toDouble * Measure.tickDuration()).toLong)
      chord.notes.foreach { note => channel.noteOff(note.pitch, note.volume) }
    }
    case tempo: TempoChange => Measure.bpm = tempo.value
  }
  
  def playEvent(event: MusicEvent) = event match {
    case e: NoteOn => channel.noteOn(e.note.pitch, e.note.volume)
    case e: NoteOff => channel.noteOff(e.note.pitch, e.note.volume)
    case _ =>
  }
}
case object Ping

trait MusicPlayer {
  val actor: ActorRef
  def play(music: Music)
}

case class MusicPlayerImpl(musicActor: ActorRef) extends MusicPlayer {
  val actor = musicActor
  def play(music: Music) = {
    music match {
      case element: MusicElement => musicActor ! element
      case sequence: MusicSequence => {
        sequence.elements.foreach { e => musicActor ! e }
      }
    }
  }
}