package de.htwg.scalala.music.elements

import de.htwg.scalala.music._

case class Interval(value: Double, volume: Int) extends MusicElement {
  def play(instrument: Instrument = Piano, volume: Int = volume) = {

  }
}