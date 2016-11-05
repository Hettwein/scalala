package de.htwg.scalala.music.sequences

import de.htwg.scalala.music._
import de.htwg.scalala.music.elements.Note
import de.htwg.scalala.music.elements.Chord
import de.htwg.scalala.music.elements.Interval

case class Line(measure: Measure, elements: MusicElement*) extends MusicSequence {

  def applyKey = {
//    val signCount = measure.keySignature.sign().pos.size
//    val sign = measure.keySignature.sign().mode
//    var sharp = true
//    val setSigns = if (sign == SignMode.Sharp) measure.keySignature.sharpSignsAt(signCount) else if (sign == SignMode.Flat) { sharp = false; measure.keySignature.flatSignsAt(signCount) } else List()
    var applied = elements
//    elements.foreach { e =>
//      e match {
//        case note: Note => if (setSigns.contains(note.keynumber)) { if (sharp) applied = applied.updated(applied.indexOf(e), note.sharp) else applied = applied.updated(applied.indexOf(e), note.flat) }
//        case chord: Chord => chord.notes.foreach { note => if (setSigns.contains(note.keynumber)) { if (sharp) applied = applied.updated(applied.indexOf(e), chord.copy(notes = chord.notes.updated(chord.notes.indexOf(e), note.sharp))) else applied = applied.updated(applied.indexOf(e), chord.copy(notes = chord.notes.updated(chord.notes.indexOf(e), note.flat))) } }
//        case _ => 
//        //          case interval: Interval =>  interval.notes.foreach { note => if(setSigns.contains(note)) note }
//      }
//    }
    applied
  }

//  val measures
  
  def play(instrument: Instrument = Piano, volume: Int = 75) = {
    elements.foreach { e => e.play(instrument, volume) }
  }
  override def toString: String = elements mkString ", "
}