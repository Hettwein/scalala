package de.htwg.scalala.music

case class Interval(set: Set[Key],
    repeat: Int = 1,
    pattern: Pattern = Pattern(1),
    time: Double = 0.25,
    name: String = "") extends MusicElem {

  def play(instrument: Instrument = Piano, volume: Int): Unit = for (i <- 1 to repeat; part <- pattern) {
    instrument.midiPlayer.play(set, volume = volume * part)
  }
  def *(_pattern: Pattern): Interval = copy(pattern = _pattern)
  def *(repetitions: Int): Interval = copy(repeat = repetitions)
  override def toString = if (name == "") "[" + set.foreach(_.toString) + "]" else name
  override def equals(that: Any): Boolean =
    that match {
      case that: Chord => (this.set == that.set)
      case _ => false
    }
}

object Interval {

  def apply(keys: Key*): Interval = {
    Interval(keys.toSet)
  }

  def apply(rootkey: Key, intervalQuality: IntervalQuality.Value): Interval = {
    rootkey.interval(intervalQuality)
  }
}

object IntervalQuality extends Enumeration {
  type IntervalQuality = Value
  val PerfectUnison, MinorSecond, MajorSecond, MinorThird, MajorThird, PerfectFourth, Tritone, PerfectFifth, MinorSixth, MajorSixth, MinorSeventh, MajorSeventh, PerfectOctave, MinorNinth, MajorNinth = Value
}