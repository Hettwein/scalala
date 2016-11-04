package de.htwg.scalala.music

trait MusicSequence extends Music {
  val elements: Seq[MusicElement]
  def applyKey: Seq[MusicElement]
}