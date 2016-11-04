package de.htwg.scalala.music

import de.htwg.scalala.players._
import de.htwg.scalala.music._
import de.htwg.scalala.music.sequences._
import de.htwg.scalala.music.elements._
import scala.language.postfixOps
 
object LordOfTheRingsPiano {

  val LeftPiano = player(Piano, "LeftPiano")      //> Nov 04, 2016 5:35:39 PM java.util.prefs.WindowsPreferences <init>
                                                  //| WARNING: Could not open/create prefs root node Software\JavaSoft\Prefs at ro
                                                  //| ot 0x80000002. Windows RegCreateKeyEx(...) returned error code 5.
                                                  //| LeftPiano  : de.htwg.scalala.players.MusicPlayer = Actor[akka://Orchestra/us
                                                  //| er/LeftPianoPlayer#19386720]
  val RightPiano  = player(Piano, "RightPiano")   //> RightPiano  : de.htwg.scalala.players.MusicPlayer = Actor[akka://Orchestra/u
                                                  //| ser/RightPianoPlayer#1532599029]
  
  var right = Line(new Measure(new TimeSignature(3, 4), new Key(f)),
   						r4, a8, bes8, d8+, c8+,  c2.dot+,                 r4, a8, bes8, d8+, c8+,      c2.dot+,
   						r4, a8, bes8, d8+, c8+,  c+, a8, bes8, d8+, c8+,  c+, f8+, g8+, a8+, bes8+,    a2+, bes+,
   						g2.dot+,                 g2.dot+,                 r4, ges8+, g8+, a8+, bes8+,  g2.dot+,
   						r4, d8+, e8+, f8+, g8+,  f+, d8+, e8+, f8+, g8+,  e+, c8+, d8+, e8+, c8+,      a2.dot)
                                                  //> right  : de.htwg.scalala.music.sequences.Line = p1/4, A1/8, Bâ™­1/8, D'1/8, 
                                                  //| C'1/8, C'1/2Â·, p1/4, A1/8, Bâ™­1/8, D'1/8, C'1/8, C'1/2Â·, p1/4, A1/8, Bâ™­
                                                  //| 1/8, D'1/8, C'1/8, C'1/4, A1/8, Bâ™­1/8, D'1/8, C'1/8, C'1/4, F'1/8, G'1/8, 
                                                  //| A'1/8, Bâ™­'1/8, A'1/2, Bâ™­'1/4, G'1/2Â·, G'1/2Â·, p1/4, Gâ™­'1/8, G'1/8, A
                                                  //| '1/8, Bâ™­'1/8, G'1/2Â·, p1/4, D'1/8, E'1/8, F'1/8, G'1/8, F'1/4, D'1/8, E'1
                                                  //| /8, F'1/8, G'1/8, E'1/4, C'1/8, D'1/8, E'1/8, C'1/8, A1/2Â·

  var left = Line(new Measure(new TimeSignature(3, 4), new Key(f)),
  		        r2.dot,                              f-, Chord(a-, c), Chord(a-, c),       c-, Chord(a-, c), Chord(a-, c),        f-, Chord(a-, c), Chord(a-, c),
  						c-, Chord(a-, c), Chord(a-, c),      f-, Chord(a-, c), Chord(a-, c),       a--, Chord(a-, c), Chord(a-, c),       c-, Chord(bes-, e), Chord(bes-, e),
  						c-, Chord(bes-, e), Chord(bes-, e),  g-, Chord(bes-, d), Chord(d, g),      Chord(g-, d, ges), d, Chord(bes-, d),  c-, Chord(g-, c, e), Chord(g-, c, e),
  						c-, Chord(g-, c), Chord(g-, c),      g--, Chord(bes-, d), Chord(bes-, d),  c-, Chord(g-, c), Chord(as-, c),       f-, Chord(a-, c), Chord(a-, c),
  						Chord(c2.dot-, bes2.dot-, e.dot-))
                                                  //> left  : de.htwg.scalala.music.sequences.Line = p1/2Â·, F,1/4, [A,1/4, C1/4]
                                                  //| , [A,1/4, C1/4], C,1/4, [A,1/4, C1/4], [A,1/4, C1/4], F,1/4, [A,1/4, C1/4],
                                                  //|  [A,1/4, C1/4], C,1/4, [A,1/4, C1/4], [A,1/4, C1/4], F,1/4, [A,1/4, C1/4], 
                                                  //| [A,1/4, C1/4], A,,1/4, [A,1/4, C1/4], [A,1/4, C1/4], C,1/4, [Bâ™­,1/4, E1/4
                                                  //| ], [Bâ™­,1/4, E1/4], C,1/4, [Bâ™­,1/4, E1/4], [Bâ™­,1/4, E1/4], G,1/4, [Bâ™
                                                  //| ­,1/4, D1/4], [D1/4, G1/4], [G,1/4, D1/4, Gâ™­1/4], D1/4, [Bâ™­,1/4, D1/4],
                                                  //|  C,1/4, [G,1/4, C1/4, E1/4], [G,1/4, C1/4, E1/4], C,1/4, [G,1/4, C1/4], [G,
                                                  //| 1/4, C1/4], G,,1/4, [Bâ™­,1/4, D1/4], [Bâ™­,1/4, D1/4], C,1/4, [G,1/4, C1/4
                                                  //| ], [Aâ™­,1/4, C1/4], F,1/4, [A,1/4, C1/4], [A,1/4, C1/4], [C,1/2Â·, Bâ™­,1/
                                                  //| 2Â·, E,1/4Â·]/

//  var right = Line(new Measure(new TimeSignature(3, 4), new Key(f)),
//   						r4, a8, b8, d8+, c8+,    c2.dot+,                 r4, a8, b8, d8+, c8+,      c2.dot+,
//   						r4, a8, b8, d8+, c8+,    c+, a8, b8, d8+, c8+,    c+, f8+, g8+, a8+, b8+,    a2+, b+,
//   						g2.dot+,                 g2.dot+,                 r4, ges8+, g8+, a8+, b8+,  g2.dot+,
//   						r4, d8+, e8+, f8+, g8+,  f+, d8+, e8+, f8+, g8+,  e+, c8+, d8+, e8+, c8+,    a2.dot)

//  var left = Line(new Measure(new TimeSignature(3, 4), new Key(f)),
//  						r2.dot,                                f-, Chord(a-, c), Chord(a-, c),  c-, Chord(a-, c), Chord(a-, c),      f-, Chord(a-, c), Chord(a-, c),
//  						c-, Chord(a-, c), Chord(a-, c),        f-, Chord(a-, c), Chord(a-, c),  a--, Chord(a-, c), Chord(a-, c),     c-, Chord(b-, e), Chord(b-, e),
//  						c-, Chord(b-, e), Chord(b-, e),        g-, Chord(b-, d), Chord(d, g),   Chord(g-, d, ges), d, Chord(b-, d),  e-, Chord(a-, c), Chord(a-, c),
//  						c-, Chord(g-, c, e), Chord(g-, c, e),  c-, Chord(g-, c), Chord(g-, c),  g--, Chord(b-, d), Chord(b-, d),     c-, Chord(g-, c), Chord(as-, c),  f-, Chord(a-, c), Chord(a-, c),  Chord(c2.dot-, b2.dot-, e.dot-))


  RightPiano.play(right)
  LeftPiano.play(left)
  //DrumPlayer.play(*Pattern(1,0,0,0)*4)
}