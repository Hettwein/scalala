package de.htwg.scalala

import de.htwg.scalala.music._
import de.htwg.scalala.music.elements._
import de.htwg.scalala.music.sequences._
import de.htwg.scalala.players._
import scala.language.postfixOps

object Main extends App {
  var lead = Line(new Measure(), r1, r1, r1, r1,
    r4, c6+, g12.tie(g), e, d, e6, f12.tie(f), r4, r4, b.dot, g8, a6, g12, c6, c, c12.tie(c), r4,
    r4, c6+, g12.tie(g), e, d, e6, f12.tie(f), r4, r6, g12, g, b, c+, d+, c6+, b12.tie(b6), g12, a,
    r4, c6+, g12.tie(g), e, d, e6, f12.tie(f), f6, d12, r4, b, b6, g12, a6, g12, c6, c, c12.tie(c6), e12, g,
    r4, Chord(c2+, e2+), Chord(bes, d+), Chord(a, c+), Chord(a, c+), Chord(a6, c6+), Chord(f12.tie(f), a12.tie(a)), r2, Chord(f6, d6+), Chord(e12, c12+), Chord(d6, b6), Chord(e12.tie(e2.dot), c12.tie(c2.dot+)+))

  var chords = Line(new Measure(), r1, r1, r1, r1,
    Chord(c1-, ChordQuality.Major), Chord(f1-, ChordQuality.Major), Chord(g1-, ChordQuality.Major), Chord(c1-, ChordQuality.Major),
    Chord(c1-, ChordQuality.Major), Chord(f1-, ChordQuality.Major), Chord(g1-, ChordQuality.Major), Chord(g1-, ChordQuality.Major),
    Chord(c1-, ChordQuality.Major), Chord(f1-, ChordQuality.Major), Chord(g1-, ChordQuality.Major), Chord(c1-, ChordQuality.Major),
    Chord(c1-, ChordQuality.Major), Chord(f1-, ChordQuality.Major), Chord(g1-, ChordQuality.Major), Chord(c1-, ChordQuality.Major))

  //  var bass = Line(new Measure(), c2--, e2--, f.dot--, f8.tie(f--)--, r4, g2--, d2--, g--, f--, e--, d--,
  //    c2--, e2--, f2.tie(f8--)--, f8--, fis--, g2--, f2--, e2.dot--, d--,
  //    c2--, e2--, f2.tie(f8--)--, f8--, fis8--, g8.tie(g2--)--, g2--, g--, f--, e--, d--,
  //    c2--, e2--, f2.tie(f.dot--)--, fis8--, g2--, f2--, e2.dot--, d--,
  //    c2--, e2--, f2.dot.tie(f8--)--, fis8--, g--, g--, r2, c8-, fis8--, g--, c--, r4)

  var bassSwing = Line(new Measure(), c2--, e2--, f.dot--, f8.tie(f--)--, r4, g2--, d2--, g--, f--, e--, d--,
    c2--, e2--, f2.tie(f6--)--, f12--, fis--, g2--, f2--, e2.dot--, d--,
    c2--, e2--, f2.tie(f6--)--, f12--, fis6--, g12.tie(g2--)--, g2--, g--, f--, e--, d--,
    c2--, e2--, f2.tie(f.dot--)--, fis8--, g2--, f2--, e2.dot--, d--,
    c2--, e2--, f2.dot.tie(f6--)--, fis12--, g--, g--, r2, c6-, fis12--, g--, c--, r4)

    Measure.bpm = 135
  val Lead = player(Piano, "Lead", 0)
  val Bassline = player(Bass, "Bassline", 1)
  val Chords = player(Flute, "Chords", 2)

//      Lead.play(lead)
//      Bassline.play(bassSwing)
//      Chords.play(chords)

  //  var right = Line(new Measure(new TimeSignature(3, 4), new Key(f)),
  //    r4, a8, b8, d8+, c8+, c2.dot+, r4, a8, b8, d8+, c8+, c2.dot+,
  //    r4, a8, b8, d8+, c8+, c+, a8, b8, d8+, c8+, c+, f8+, g8+, a8+, b8+, a2+, b+,
  //    g2.dot+, g2.dot+, r4, ges8+, g8+, a8+, b8+, g2.dot+,
  //    r4, d8+, e8+, f8+, g8+, f+, d8+, e8+, f8+, g8+, e+, c8+, d8+, e8+, c8+, a2.dot)

  //  var left = Line(new Measure(new TimeSignature(3, 4), new Key(f)),
  //    r2.dot, f-, Chord(a-, c), Chord(a-, c), c-, Chord(a-, c), Chord(a-, c), f-, Chord(a-, c), Chord(a-, c),
  //    c-, Chord(a-, c), Chord(a-, c), f-, Chord(a-, c), Chord(a-, c), a--, Chord(a-, c), Chord(a-, c), c-, Chord(b-, e), Chord(b-, e),
  //    c-, Chord(b-, e), Chord(b-, e), g-, Chord(b-, d), Chord(d, g), Chord(g-, d, ges), d, Chord(b-, d), e-, Chord(a-, c), Chord(a-, c),
  //    c-, Chord(g-, c, e), Chord(g-, c, e), c-, Chord(g-, c), Chord(g-, c), g--, Chord(b-, d), Chord(b-, d), c-, Chord(g-, c), Chord(as-, c), f-, Chord(a-, c), Chord(a-, c), Chord(c2.dot-, b2.dot-, e.dot-))
  //Lead.play(left)
  //  right.applyKey

  val LeftPiano = player(Piano, "LeftPiano")
  val RightPiano = player(Piano, "RightPiano")

  var right = Line(new Measure(new TimeSignature(3, 4), new Key(f)),
    r4, a8, bes8, d8+, c8+, t.to(110), c2.dot+, r4, a8, bes8, d8+, c8+, c2.dot+,
    r4, a8, bes8, d8+, c8+, c+, a8, bes8, d8+, c8+, c+, f8+, g8+, a8+, bes8+, a2+, bes+,
    g2.dot+, g2.dot+, r4, ges8+, g8+, a8+, bes8+, g2.dot+,
    r4, d8+, e8+, f8+, g8+, f+, d8+, e8+, f8+, g8+, e+, c8+, d8+, e8+, c8+, a2.dot)

  var left = Line(new Measure(new TimeSignature(3, 4), new Key(f)),
    r2.dot, t.to(110), f-, Chord(a-, c), Chord(a-, c), c-, Chord(a-, c), Chord(a-, c), f-, Chord(a-, c), Chord(a-, c),
    c-, Chord(a-, c), Chord(a-, c), f-, Chord(a-, c), Chord(a-, c), a--, Chord(a-, c), Chord(a-, c), c-, Chord(bes-, e), Chord(bes-, e),
    c-, Chord(bes-, e), Chord(bes-, e), g-, Chord(bes-, d), Chord(d, g), Chord(g-, d, ges), d, Chord(bes-, d), c-, Chord(g-, c, e), Chord(g-, c, e),
    c-, Chord(g-, c), Chord(g-, c), g--, Chord(bes-, d), Chord(bes-, d), c-, Chord(g-, c), Chord(as-, c), f-, Chord(a-, c), Chord(a-, c),
    Chord(c2.dot-, bes2.dot-, e.dot-))

    Measure.bpm = 80
  RightPiano.play(right)
  LeftPiano.play(left)
}