package de.htwg.scalala.players

import akka.actor._
import de.htwg.scalala.music._

trait MusicMessage
case object Start extends MusicMessage
case object Stop extends MusicMessage
case class Tick(barNum: Int, beatNum: Int ,tickNum: Int) extends MusicMessage
case class PlayNow(music: List[Option[Music]]) extends MusicMessage
case class PlayAt(tick: Int, music: List[Option[Music]])
case class Add(player: MusicPlayer) extends MusicMessage 