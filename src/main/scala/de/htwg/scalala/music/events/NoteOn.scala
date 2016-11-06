package de.htwg.scalala.music.events

import de.htwg.scalala.music._
import de.htwg.scalala.music.elements._

case class NoteOn(note: Note) extends MusicEvent {
  
  def play(instrument: Instrument, volume: Int) {
    
  }
}

case class NoteOff(note: Note) extends MusicEvent {
	
	def play(instrument: Instrument, volume: Int) {
		
	}
}

