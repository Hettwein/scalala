package de.htwg.scalala.music.elements

import de.htwg.scalala.music._

case class Rest(value: Int) extends MusicElement {

  def dot = copy((value.toDouble * 1.5).toInt)

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
  //    1 -> "1",//\u1D13B",
  //    4.0 / 3.0 -> "1/2\u00B7",//"\u1D13C\u00B7",
  //    2 -> "1/2",//"\u1D13C",
  //    3 -> "1/3",
  //    8.0/3.0 -> "1/4\u00B7",//"\u1D13D\u00B7",
  //    4 -> "1/4",//"\u1D13D",
  //    6 -> "1/6",
  //    16.0/3.0 -> "1/8\u00B7",//"\u1D13E\u00B7",
  //    8 -> "1/8",//"\u1D13E",
  //    12 -> "1/12",
  //    16 -> "1/16")//"\u1D13F")

  def play(instrument: Instrument = Piano, volume: Int = 0) = {
    instrument.midiPlayer.play(0, duration().toInt, 0)
  }

  override def toString = "p" + valueToString(value)
  override def equals(that: Any): Boolean =
    that match {
      case that: Rest => (this.value == that.value)
      case _ => false
    }
}