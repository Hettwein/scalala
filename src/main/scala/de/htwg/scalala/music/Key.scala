package de.htwg.scalala.music

import de.htwg.scalala.midi.MidiPlayer

case class Key(
    val midiNumber: Int,
    val isSharp: Boolean = false,
    val isFlat: Boolean = false,
    repeat: Int = 1,
    pattern: Pattern = Pattern(1),
    time: Double = Context.fraction,
    val tied: Double = 0,
    volume: Int = Context.volume) extends MusicElem {
  require(0 <= midiNumber && midiNumber <= 128)
  require(0 <= volume && volume <= 100)

  def play(instrument: Instrument = Piano, volume: Int = volume): Unit = for (i <- 1 to repeat; part <- pattern) {
    instrument.midiPlayer.play(key = midiNumber, duration = duration, volume = volume * part)
  }

  def *(pattern: Pattern): Key = copy(pattern = pattern)
  def *(repetitions: Int): Key = copy(repeat = repetitions)

  val keynumber = midiNumber % 12
  val octave = midiNumber / 12 - 1

  def sharp = Key(midiNumber = midiNumber + 1, isSharp = true)
  def flat = Key(midiNumber = midiNumber - 1, isFlat = true)
  def dot = copy(time = time * 1.5)
  def tie(note: Key) = copy(time = time + note.time, tied = note.time)

  def speed(t: Double) = { copy(time = t) }

  def + = copy(midiNumber = midiNumber + 12)
  def ++ = copy(midiNumber = midiNumber + 24)
  def - = copy(midiNumber = midiNumber - 12)
  def -- = copy(midiNumber = midiNumber - 24)

  def soft = copy(volume = volume - Context.softDecrease)
  def ? = soft
  def hard = copy(volume = volume + Context.hardIncrease)
  def ! = hard

  def chord(chordQuality: ChordQuality.Value): Chord = {
    chordQuality match {
      case ChordQuality.Major => Chord(Set(this, majorTerz, majorQuint), name = toString.toUpperCase() + "maj")
      case ChordQuality.Minor => Chord(Set(this, minorTerz, majorQuint), name = toString.toUpperCase() + "min")
      case ChordQuality.Diminshed => Chord(Set(this, minorTerz, minorQuint), name = toString.toUpperCase() + "dim")
      case ChordQuality.Augmented => Chord(Set(this, majorTerz, augmentedQuint), name = toString.toUpperCase() + "aug")
      case ChordQuality.Seventh => Chord(Set(this, majorTerz, majorQuint, minorSetp), name = toString.toUpperCase() + "7")
      case ChordQuality.MajorSeventh => Chord(Set(this, majorTerz, majorQuint, majorSetp), name = toString.toUpperCase() + "maj7")
      case ChordQuality.MinorSeventh => Chord(Set(this, minorTerz, majorQuint, minorSetp), name = toString.toUpperCase() + "min7")
    }
  }
  def interval(intervalQuality: IntervalQuality.Value): Interval = {
    intervalQuality match {
      case IntervalQuality.PerfectUnison => Interval(Set(this, copy(midiNumber = this.midiNumber + 0)))
      case IntervalQuality.MinorSecond => Interval(Set(this, copy(midiNumber = this.midiNumber + 1)))
      case IntervalQuality.MajorSecond => Interval(Set(this, copy(midiNumber = this.midiNumber + 2)))
      case IntervalQuality.MinorThird => Interval(Set(this, copy(midiNumber = this.midiNumber + 3)))
      case IntervalQuality.MajorThird => Interval(Set(this, copy(midiNumber = this.midiNumber + 4)))
      case IntervalQuality.PerfectFourth => Interval(Set(this, copy(midiNumber = this.midiNumber + 5)))
      case IntervalQuality.Tritone => Interval(Set(this, copy(midiNumber = this.midiNumber + 6)))
      case IntervalQuality.PerfectFifth => Interval(Set(this, copy(midiNumber = this.midiNumber + 7)))
      case IntervalQuality.MinorSixth => Interval(Set(this, copy(midiNumber = this.midiNumber + 8)))
      case IntervalQuality.MajorSixth => Interval(Set(this, copy(midiNumber = this.midiNumber + 9)))
      case IntervalQuality.MinorSeventh => Interval(Set(this, copy(midiNumber = this.midiNumber + 10)))
      case IntervalQuality.MajorSeventh => Interval(Set(this, copy(midiNumber = this.midiNumber + 11)))
      case IntervalQuality.PerfectOctave => Interval(Set(this, copy(midiNumber = this.midiNumber + 12)))
      case IntervalQuality.MinorNinth => Interval(Set(this, copy(midiNumber = this.midiNumber + 13)))
      case IntervalQuality.MajorNinth => Interval(Set(this, copy(midiNumber = this.midiNumber + 14)))

    }
  }
  def minorTerz = copy(midiNumber = this.midiNumber + 3)
  def majorTerz = copy(midiNumber = this.midiNumber + 4)
  def minorQuint = copy(midiNumber = this.midiNumber + 6)
  def majorQuint = copy(midiNumber = this.midiNumber + 7)
  def augmentedQuint = copy(midiNumber = this.midiNumber + 8)
  def minorSetp = copy(midiNumber = this.midiNumber + 10)
  def majorSetp = copy(midiNumber = this.midiNumber + 11)
  def maj: Chord = chord(ChordQuality.Major)
  def dur: Chord = maj
  def min: Chord = chord(ChordQuality.Minor)
  def mol: Chord = min
  def dim: Chord = chord(ChordQuality.Diminshed)
  def aug: Chord = chord(ChordQuality.Augmented)
  def maj7 = chord(ChordQuality.MajorSeventh)
  def min7 = chord(ChordQuality.MinorSeventh)

  def scale(scaleType: ScaleType.Value = ScaleType.Major) = Scale(this, scaleType)

  val keynumberToString = Map(
    0 -> "c",
    1 -> (if (isSharp) "c\u266F" else if (isFlat) "d\u266D"),
    2 -> "d",
    3 -> (if (isSharp) "d\u266F" else if (isFlat) "e\u266D"),
    4 -> "e",
    5 -> "f",
    6 -> (if (isSharp) "f\u266F" else if (isFlat) "g\u266D"),
    7 -> "g",
    8 -> (if (isSharp) "g\u266F" else if (isFlat) "a\u266D"),
    9 -> "a",
    10 -> (if (isSharp) "a\u266F" else if (isFlat) "b\u266D"),
    11 -> "b")
  val octaveToString = Map(
    -1 -> ",,,,,",
    0 -> ",,,,",
    1 -> ",,,",
    2 -> ",,",
    3 -> ",",
    4 -> "",
    5 -> "'",
    6 -> "\"",
    7 -> "\"'",
    8 -> "\"\"",
    9 -> "\"\"'")
  val timeToString = {
    Map(
      1.0 -> "\u1D15D",
      0.75 -> "\u00BD\u00B7",
      0.6667 -> "2/3",
      0.5 -> "\u00BD",
      0.375 -> "\u00B7",
      0.3333 -> "1/3",
      0.25 -> "",
      0.1875 -> "1/8\u00B7",
      0.1667 -> "1/6",
      0.125 -> "1/8",
      0.09375 -> "1/16\u00B7",
      0.0833 -> "1/12",
      0.0625 -> "1/16",
      0.0 -> "|")
  }

  override def toString = if (midiNumber == 128) "|" else if (volume == 0) "-" else if(tied == 0) keynumberToString(keynumber) + octaveToString(octave) + timeToString(time) else keynumberToString(keynumber) + octaveToString(octave) + timeToString(time - tied) + "_" + timeToString(tied) 
  override def equals(that: Any): Boolean =
    that match {
      case that: Key => (this.midiNumber == that.midiNumber) && (this.time == that.time)
      case _ => false
    }
}

object Key {

}