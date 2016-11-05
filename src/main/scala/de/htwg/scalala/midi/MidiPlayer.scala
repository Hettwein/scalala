package de.htwg.scalala.midi

import javax.sound.midi.{ MidiSystem, Synthesizer }
import de.htwg.scalala.music.elements.Note

case class MidiPlayer(instrumentID: Int = 0, channelID: Int = 0) {

  val synthesizer = MidiSystem.getSynthesizer
  synthesizer.open
  val channels = synthesizer.getChannels
  val channel = channels.apply(channelID)
  changeToInstrument(instrumentID)

  def play(note: Int = 60, duration: Int = 800, volume: Int = 75): Unit = {

    channel.noteOn(note, volume)
    Thread.sleep(duration)
    channel.noteOff(note, volume)
  }

  def play(notes: Vector[Note], volume: Int): Unit = {
    val duration = notes.head.duration(notes.head.getTiedDuration)
    notes.foreach { note => start(note = note.pitch, volume = volume) }
    Thread.sleep(duration)
    notes.foreach { note => stop(note.pitch, volume = volume) }
  }

  def start(note: Int, volume: Int = 75): Unit = {
    channel.noteOn(note, volume)
  }

  def stop(note: Int, volume: Int = 75): Unit = {
    channel.noteOff(note, volume)
  }

  def changeToInstrument(instrumentID: Int = 0) = {
    channel.programChange(instrumentID)
  }
}