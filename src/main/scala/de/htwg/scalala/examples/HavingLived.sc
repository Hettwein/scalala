package de.htwg.scalala.examples

import de.htwg.scalala.players._
import de.htwg.scalala.music._
import de.htwg.scalala.music.sequences._
import de.htwg.scalala.music.elements._
import scala.language.postfixOps

object HavingLived {

	Measure.bpm = 60
  val LeftPiano = player(Piano, "LeftPiano")      //> Nov 05, 2016 2:06:48 PM java.util.prefs.WindowsPreferences <init>
                                                  //| WARNING: Could not open/create prefs root node Software\JavaSoft\Prefs at ro
                                                  //| ot 0x80000002. Windows RegCreateKeyEx(...) returned error code 5.
                                                  //| LeftPiano  : de.htwg.scalala.players.MusicPlayer = Actor[akka://Orchestra/us
                                                  //| er/LeftPianoPlayer#-370809957]
  val RightPiano = player(Piano, "RightPiano")    //> RightPiano  : de.htwg.scalala.players.MusicPlayer = Actor[akka://Orchestra/u
                                                  //| ser/RightPianoPlayer#-242355144]

  var right = Line(new Measure(),
  						g+,  e++, a+, a++, b16+, c16++, b16+, c16++,  d++, c.dot++, g++, a8+,  e++, a++, d++, a16++, g16++, e16++, d16++,
  						b12+, c12++, d12++, g.dot+, g8.tie(g++)++,  f8+, f8.tie(f2.tie(f8++)++)++, a8+,  b8+, g8.tie(g2.tie(g8.dot.tie(g32++)++)++)++, b32++,
  						c16+++, b16++, g16++, e16.tie(e++)++, c16++, b16+, g16+, e16.tie(e8.dot.tie(e32+)+)+, b32+,  c12++, b12+, e12+, a12+, g12+, d12+, Chord(e2.tie(e+)+, a2.tie(a+)+, c2.tie(c++)++),
  						Chord(a+, d++), Chord(g+, b+), Chord(d+, g+),  a2.dot.tie(a8++)++, e8.tie(e1+)+,  e++, a+, c++, d++,  b2+, g++, b++,
  						a++, a+, a.dot++, g8++,  e++, Chord(c+, d+, e+), c.dot+++, d8++,  d++, f++, a++, c8++, d8++,  f++, d++, e+, d++,
  						e1++,  d2++, Chord(g2+, c2++),  Chord(g1, b1, c1+, e1+))
                                                  //> right  : de.htwg.scalala.music.sequences.Line = G'1/4, E"1/4, A'1/4, A"1/4,
                                                  //|  B'1/16, C"1/16, B'1/16, C"1/16, D"1/4, C"1/4Â·, G"1/4, A'1/8, E"1/4, A"1/4
                                                  //| , D"1/4, A"1/16, G"1/16, E"1/16, D"1/16, B'1/8Â³, C"1/8Â³, D"1/8Â³, G'1/4Â·
                                                  //| , G"1/8_G"1/4, F'1/8, F"1/8_F"1/2_F"1/8, A'1/8, B'1/8, G"1/8_G"1/2_G"1/8Â·_
                                                  //| G"1/32, B"1/32, C"'1/16, B"1/16, G"1/16, E"1/16_E"1/4, C"1/16, B'1/16, G'1/
                                                  //| 16, E'1/16_E'1/8Â·_E'1/32, B'1/32, C"1/8Â³, B'1/8Â³, E'1/8Â³, A'1/8Â³, G'1/
                                                  //| 8Â³, D'1/8Â³, [E'1/2_E'1/4, A'1/2_A'1/4, C"1/2_C"1/4], [A'1/4, D"1/4], [G'1
                                                  //| /4, B'1/4], [D'1/4, G'1/4], A"1/2Â·_A"1/8, E'1/8_E'1, E"1/4, A'1/4, C"1/4, 
                                                  //| D"1/4, B'1/2, G"1/4, B"1/4, A"1/4, A'1/4, A"1/4Â·, G"1/8, E"1/4, [C'1/4, D'
                                                  //| 1/4, E'1/4], C"'1/4Â·, D"1/8, D"1/4, F"1/4, A"1/4, C"1/8, D"1/8, F"1/4, D"1
                                                  //| /4, E'1/4, D"1/4, E"1, D"1/2, [G'1/2, C"1/2], [G1, B1, C'1, E'1]

  var left = Line(new Measure(),
  					 r4,  Chord(f1-, a1-, c1, e1),  Chord(c2.dot, e2.dot, g2.dot, a2.dot, b2.dot), b,  Chord(f1-, a1-, c1, e1),  Chord(c2.dot, e2.dot, g2.dot, a2.dot, b2.dot), b8.dot, g16,
  					 f16, c16+, f16+, g16+, a16+, c16++, f16++, g16++, a.dot++, r16, a16,  g16, d16+, g16+, a16+, b16+, d16++, g16++, a16++, b2++,
  					 a16, e16+, b16+, c16.tie(c++)++, a16-, e16, b16, c16.tie(c+)+,  a12-, e12, b12, g12-, d12, g12, Chord(f2.tie(f1), a2.tie(a1),c2.tie(c1+)+),
  					 f12--, c12-, f12-, g12-, a12-, c12, f8, g, a8.tie(a1),  a2, f2,  Chord(b1-, b1, d1+),  a2-, f2-,  c1-,  Chord(a1-, c1, d1, e1),
  					 Chord(c1, d1, f1),  Chord(e1-, g1-, a1-, b1-),  Chord(f1-, c1),  Chord(g1-, c1, e1))
                                                  //> left  : de.htwg.scalala.music.sequences.Line = p1/4, [F,1, A,1, C1, E1], [C
                                                  //| 1/2Â·, E1/2Â·, G1/2Â·, A1/2Â·, B1/2Â·], B1/4, [F,1, A,1, C1, E1], [C1/2Â·, 
                                                  //| E1/2Â·, G1/2Â·, A1/2Â·, B1/2Â·], B1/8Â·, G1/16, F1/16, C'1/16, F'1/16, G'1/
                                                  //| 16, A'1/16, C"1/16, F"1/16, G"1/16, A"1/4Â·, p1/16, A1/16, G1/16, D'1/16, G
                                                  //| '1/16, A'1/16, B'1/16, D"1/16, G"1/16, A"1/16, B"1/2, A1/16, E'1/16, B'1/16
                                                  //| , C"1/16_C"1/4, A,1/16, E1/16, B1/16, C'1/16_C'1/4, A,1/8Â³, E1/8Â³, B1/8Â³
                                                  //| , G,1/8Â³, D1/8Â³, G1/8Â³, [F1/2_F1, A1/2_A1, C'1/2_C'1], F,,1/8Â³, C,1/8Â³
                                                  //| , F,1/8Â³, G,1/8Â³, A,1/8Â³, C1/8Â³, F1/8, G1/4, A1/8_A1, A1/2, F1/2, [B,1,
                                                  //|  B1, D'1], A,1/2, F,1/2, C,1, [A,1, C1, D1, E1], [C1, D1, F1], [E,1, G,1, A
                                                  //| ,1, B,1], [F,1, C1], [G,1, C1, E1]|



  RightPiano.play(right)
  LeftPiano.play(left)
}