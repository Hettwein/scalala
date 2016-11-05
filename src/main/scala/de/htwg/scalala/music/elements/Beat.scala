package de.htwg.scalala.music.elements

import de.htwg.scalala.music._

case class Beat(value: Int = 4) extends MusicElement {
  
  def play(instrument: Instrument = Piano, volume: Int = 0) {
    
  }
}