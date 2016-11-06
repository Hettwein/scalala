package de.htwg.scalala

import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.TypedActor
import akka.actor.TypedProps
import de.htwg.scalala.music._
import de.htwg.scalala.players._
import javax.sound.midi.MidiChannel
import javax.sound.midi.MidiSystem

package object players {
  val synthesizer = MidiSystem.getSynthesizer()
  synthesizer.open()
 
  val channels = synthesizer.getChannels()
  
  val system = ActorSystem("Orchestra")

  def player(instrument: Instrument, name: String = "", channelId: Int = 0): MusicPlayer = {
    val channel = channels(channelId)
    channel.programChange(instrument.instrumentID)
    val actor = system.actorOf(Props(new Musician(channel)), name = if (name == "") instrument.toString + "Actor" else name + "Actor")
    TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(actor)), name = if (name == "") instrument.toString + "Player" else name + "Player")
  }

  val PianoPlayer: MusicPlayer = player(Piano)
  val MarimbaPlayer = player(Marimba)
  val XylophonePlayer = player(Xylophone)
  val OrganPlayer = player(Organ)
  val GuitarPlayer = player(Guitar)
  val BassPlayer = player(Bass)
  val ViolinPlayer = player(Violin)
  val CelloPlayer = player(Cello)
  val TrumpetPlayer = player(Trumpet)
  val TubaPlayer = player(Tuba)
  val HornPlayer = player(Horn)
  val SaxPlayer = player(Sax)
  val OboePlayer = player(Oboe)
  val ClarinetPlayer = player(Clarinet)
  val FlutePlayer = player(Flute)

  val DrumPlayer = player(DrumSet)

//  val Conductor = system.actorOf(Props(classOf[Conductor]), "Conductor")
}