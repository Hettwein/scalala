package de.htwg.scalala.music.sequences

import de.htwg.scalala.music._
import de.htwg.scalala.music.elements._
import de.htwg.scalala.music.events._

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
  //  val bars: Seq[Bar] = Seq(new Bar(measure))

  def play(instrument: Instrument = Piano, volume: Int = 75) = {
    elements.foreach { e => e.play(instrument, volume) }
  }

  def toTickList(): Seq[Bar] = {
    var bars: Seq[Bar] = Seq(new Bar(measure))
    var bar = 0
    var beat = 0
    var tick = 0
    elements.foreach {
      e =>
//        println(e)
        e match {
          case note: Note => {
            bars(bar).beats(beat).ticks(tick).events = bars(bar).beats(beat).ticks(tick).events.:+(new NoteOn(note))
            tick += note.duration(note.getTiedDuration).toInt
            while (tick >= (96 / measure.beatLength)) {
              tick -= (96 / measure.beatLength)
              beat += 1
            }
            while (beat >= measure.beats) {
              beat -= measure.beats
              bar += 1
            }
            while (bar >= bars.size) {
              bars = bars.:+(new Bar(measure))
            }
//            println(bar)
//            println(beat)
//            println(tick)
//            println(bars)
//            println(bars(bar).beats)
//            println(bars(bar).beats(beat).ticks)
            bars(bar).beats(beat).ticks(tick).events = bars(bar).beats(beat).ticks(tick).events.:+(new NoteOff(note))
          }
          case chord: Chord => {
            var tmpTick = tick
            var tmpBeat = beat
            var tmpBar = bar
            chord.notes.foreach { note =>
              bars(bar).beats(beat).ticks(tick).events = bars(bar).beats(beat).ticks(tick).events.:+(new NoteOn(note))
              tmpTick = tick + note.duration(note.getTiedDuration).toInt
              tmpBeat = beat
              tmpBar = bar
              while (tmpTick >= (96 / measure.beatLength)) {
                tmpTick -= (96 / measure.beatLength)
                tmpBeat += 1
              }
              while (tmpBeat >= measure.beats) {
                tmpBeat -= measure.beats
                tmpBar += 1
              }
              while (tmpBar >= bars.size) {
                bars = bars.:+(new Bar(measure))
              }
              bars(tmpBar).beats(tmpBeat).ticks(tmpTick).events = bars(tmpBar).beats(tmpBeat).ticks(tmpTick).events.:+(new NoteOff(note))
            }
            tick = tmpTick
            beat = tmpBeat
            bar = tmpBar
          }
          case rest: Rest => {
            tick += rest.duration().toInt
            while (tick >= (96 / measure.beatLength)) {
              tick -= (96 / measure.beatLength)
              beat += 1
            }
            while (beat >= measure.beats) {
              beat -= measure.beats
              bar += 1
            }
            while (bar >= bars.size) {
              bars = bars.:+(new Bar(measure))
            }
          }
          case _ =>
        }
    }
    bars
  }

  override def toString: String = elements mkString ", "
}

case class Bar(measure: Measure) {
  var beats = (0 until measure.beats).toList.map(x => new Beat(measure.beatLength))
  override def toString: String = "Beats(" + (beats mkString ", ") + ")"
}
case class Beat(beatLength: Int) {
  var ticks: Seq[Tick] = (0 until (96 / beatLength)).toList.map(y => new Tick())
  override def toString: String = "Ticks(" + (ticks mkString ", ") + ")"
}
case class Tick() {
  var events: Seq[MusicEvent] = Seq()
  override def toString: String = "Events(" + (events mkString ", ") + ")"
}