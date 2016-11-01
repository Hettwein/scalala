package de.htwg.scalala.music

import de.htwg.scalala.players._
import scala.language.postfixOps
 
object KingOfTheRoad {

	Context.bpm = 135

  val Lead = player(Piano, "lead")
  val Chords = player(Flute, "chords")
  val Bassline = player(Bass, "bass")
  
  var lead = Line(p1, |, p1, |, p1, |, p1, |,
  							  p4, c8+, g8.tie(g), e, |, d, e8, f8.tie(f), p4, |, p4, b.dot, g8, a8, g8, |, c8, c, c.dot, p4, |,
  							  p4, c8+, g.dot, e, |, d, e8, f.dot, p4, |, p8, g8, g, b, c+, |, d+, c8+, b, g8, a, |,
  							  p4, c8+, g.dot, e, |, d, e8, f.dot, f8, d8, |, p4, b, b8, g8, a8, g8, |, c8, c, c, e8, g, |,
  							  p4, Chord(c2+, e2+), Chord(bes, d+), |, Chord(a, c+), Chord(a, c+), Chord(a8, c8+), Chord(f.dot, a.dot), |, p2, Chord(f8, d8+), Chord(e8, c8+), Chord(d8, b8), Chord(e2.dot, c2.dot+) )

  var chords = Line(p1, |, p1, |, p1, |, p1, |,
  								  Chord(c1-, ChordQuality.Major), |, Chord(f1-, ChordQuality.Major), |, Chord(g1-, ChordQuality.Major), Chord(c1-, ChordQuality.Major), |,
  								  Chord(c1-, ChordQuality.Major), |, Chord(f1-, ChordQuality.Major), |, Chord(g1-, ChordQuality.Major), |, Chord(g1-, ChordQuality.Major), |,
  								  Chord(c1-, ChordQuality.Major), |, Chord(f1-, ChordQuality.Major), |, Chord(g1-, ChordQuality.Major), Chord(c1-, ChordQuality.Major), |,
  								  Chord(c1-, ChordQuality.Major), |, Chord(f1-, ChordQuality.Major), |, Chord(g1-, ChordQuality.Major), Chord(c1-, ChordQuality.Major), |)

  var bass = Line(c2--, e2--, |, f.dot--, f8.tie(f--)--, p4, |, g2--, d2--, |, g--, f--, e--, d--, |,
  								c2--, e2--, |, f2.tie(f8--)--, f8--, fis--, |, g2--, f2--, |, e2.dot--, d--, |,
  								c2--, e2--, |, f2.tie(f8--)--, f8--, fis8--, g8.tie(g2--)--, g2--, |, g--, f--, e--, d--, |,
  								c2--, e2--, |, f2.tie(f.dot--)--, fis8--, |, g2--, f2--, |, e2.dot--, d--, |,
  								c2--, e2--, |, f2.dot.tie(f8--)--, fis8--, |, g--, g--, p2, |, c8-, fis8--, g--, c--, p4, |)
  
  Lead.play(lead)
  Chords.play(chords)
  Bassline.play(bass)
  
  //DrumPlayer.play(c*Pattern(1,0,0,0)*4)
}