package de.htwg.scalala.music.elements

import de.htwg.scalala.music._

case class TempoChange(value: Int) extends MusicElement {
  
  def to(bpm: Int) = copy(bpm)

  def play(instrument: Instrument = Piano, volume: Int = 0) {
    
  }
}