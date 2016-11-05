package de.htwg.scalala.music

trait MusicElement extends Music {
  val value: Int
  def duration(tiedValue: Int = 0): Long = {
//    val d = 1.0 / 135.0 * 60000.0 * 4.0
//    if(tiedValue == 0) {
//      (d / value).toLong
//    } else {
//      (d / value + d / tiedValue).toLong
//    }
    value + tiedValue
  }
}