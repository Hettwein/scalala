package de.htwg.scalala.players

import javax.sound.midi.MidiChannel
import de.htwg.scalala.music.elements.Rest
import akka.actor.Actor
import de.htwg.scalala.music.elements.Note
import de.htwg.scalala.music.elements.Chord
import de.htwg.scalala.music.Music
import akka.actor.ActorRef
import de.htwg.scalala.music.MusicElement
import de.htwg.scalala.music.MusicSequence

class Musician(channel: MidiChannel) extends Actor {

  //  private val beatLength = 175

  def receive = {
    case Ping => sender ! Ping
    case rest: Rest => Thread.sleep(rest.duration())
    case note: Note => {
      channel.noteOn(note.pitch, note.volume)
      Thread.sleep(note.duration(note.tied))
      channel.noteOff(note.pitch, note.volume)
    }
    case chord: Chord => {
      val duration = chord.notes.head.duration(chord.notes.head.tied)
      chord.notes.foreach { note => channel.noteOn(note.pitch, note.volume) }
      Thread.sleep(duration)
      chord.notes.foreach { note => channel.noteOff(note.pitch, note.volume) }
    }
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
        sequence.applyKey.foreach { e => musicActor ! e }
      }
    }
  }
}