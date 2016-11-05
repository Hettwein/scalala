package de.htwg.scalala.music

trait MusicSequence extends Music {
  val elements: Seq[MusicElement] //Stream
//  def applyKey: Seq[MusicElement]
}