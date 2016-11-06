package de.htwg.scalala.music

import de.htwg.scalala.music.elements.Beat

case class Measure(timeSignature: TimeSignature = new TimeSignature(4, 4), keySignature: Key = new Key(C)) {

  val beat = new Beat(timeSignature.nominator)
  val beats = timeSignature.denominator
  def beatLength = {
    beat.duration().toInt
  }
}

object Measure {
  var bpm = 110.0
  var beat = 4.0
  def tickDuration(): Double = {
    60000 / bpm / (96.0 / beat)
  }
}