package de.htwg.scalala.music.elements

import de.htwg.scalala.music._

case class Note(pitch: Int, value: Int = 24, volume: Int = 75, sign: SignMode.Value = SignMode.None, tied: Note = null) extends MusicElement {

  require(0 <= pitch && pitch <= 128)
  require(0 <= volume && volume <= 100)

  val keynumber = pitch % 12
  val octave = pitch / 12 - 1

  def sharp = copy(pitch = pitch + 1, sign = SignMode.Sharp)
  def flat = copy(pitch = pitch - 1, sign = SignMode.Flat)
  def natural = copy(pitch = if (sign == SignMode.Sharp) (pitch - 1) else if (sign == SignMode.Flat) (pitch + 1) else pitch, sign = SignMode.Natural)
  def dot = copy(value = (value.toDouble * 1.5).toInt)
  def tie(note: Note) = copy(tied = note)

  def + = copy(pitch = pitch + 12)
  def ++ = copy(pitch = pitch + 24)
  def +++ = copy(pitch = pitch + 36)
  def - = copy(pitch = pitch - 12)
  def -- = copy(pitch = pitch - 24)
  def --- = copy(pitch = pitch - 36)

  val keynumberToString = Map(
    0 -> "C", //(if (sign == SignMode.Sharp) "B\u266F" else "C"),
    1 -> (if (sign == SignMode.Sharp) "C\u266F" else if (sign == SignMode.Flat) "D\u266D"),
    2 -> "D",
    3 -> (if (sign == SignMode.Sharp) "D\u266F" else if (sign == SignMode.Flat) "E\u266D"),
    4 -> "E", //(if (sign == SignMode.Flat) "F\u266D" else "E"),
    5 -> "F", //(if (sign == SignMode.Sharp) "E\u266F" else "F"),
    6 -> (if (sign == SignMode.Sharp) "F\u266F" else if (sign == SignMode.Flat) "G\u266D"),
    7 -> "G",
    8 -> (if (sign == SignMode.Sharp) "G\u266F" else if (sign == SignMode.Flat) "A\u266D"),
    9 -> "A",
    10 -> (if (sign == SignMode.Sharp) "A\u266F" else if (sign == SignMode.Flat) "B\u266D"),
    11 -> "B") //(if (sign == SignMode.Flat) "C\u266D" else "B"))

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

  val valueToString = Map(
    96 -> "1",
    72 -> "1/2\u00B7",
    48 -> "1/2",
    36 -> "1/4\u00B7",
    32 -> "1/2³",
    24 -> "1/4",
    18 -> "1/8\u00B7",
    16 -> "1/4³",
    12 -> "1/8",
    9 -> "1/16\u00B7",
    8 -> "1/8³",
    6 -> "1/16",
    4 -> "1/16³",
    3 -> "1/32",
    1 -> "1/32³")
  //    1 -> "1", //"\u1D15D",
  //    4.0 / 3.0 -> "1/2\u00B7", //"\u1D15E\u00B7",
  //    2 -> "1/2", //"\u1D15E",
  //    8.0 / 3.0 -> "1/4\u00B7", //"\u1D15F\u00B7",
  //    3 -> "1/3", //"\u1D15E³",
  //    4 -> "1/4", //"\u1D15F",
  //    16.0 / 3.0 -> "1/8\u00B7", //"\u1D160\u00B7",
  //    6 -> "1/6", //"\u1D15F³",
  //    8 -> "1/8", //"\u1D160",
  //    12 -> "1/12", //"\u1D160³",
  //    16 -> "1/16") //"\u1D161")

  def getTiedDuration = {
    var d = 0
    var n = this
    while (n.tied != null) {
      n = n.tied
      d += n.value
    }
    d
  }

  def play(instrument: Instrument = Piano, volume: Int = volume) = {
    instrument.midiPlayer.play(pitch, value + getTiedDuration, volume)
  }

  override def toString = if (tied == null) keynumberToString(keynumber) + octaveToString(octave) + valueToString(value) else keynumberToString(keynumber) + octaveToString(octave) + valueToString(value) + "_" + tied.toString
  override def equals(that: Any): Boolean =
    that match {
      case that: Note => (this.pitch == that.pitch) && (this.value == that.value)
      case _ => false
    }
}