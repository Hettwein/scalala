package de.htwg.scalala.music

import de.htwg.scalala.players._
import de.htwg.scalala.music._
import de.htwg.scalala.music.sequences._
import de.htwg.scalala.music.elements._
import scala.language.postfixOps

object Hanayou {

  Measure.bpm = 80

  val LeftPiano = player(Piano, "LeftPiano")      //> Nov 06, 2016 4:08:17 PM java.util.prefs.WindowsPreferences <init>
                                                  //| WARNING: Could not open/create prefs root node Software\JavaSoft\Prefs at ro
                                                  //| ot 0x80000002. Windows RegCreateKeyEx(...) returned error code 5.
                                                  //| LeftPiano  : de.htwg.scalala.players.MusicPlayer = Actor[akka://Orchestra/us
                                                  //| er/LeftPianoPlayer#2000301008]
  val RightPiano = player(Piano, "RightPiano")    //> RightPiano  : de.htwg.scalala.players.MusicPlayer = Actor[akka://Orchestra/u
                                                  //| ser/RightPianoPlayer#741184910]

  var right = Line(new Measure(new TimeSignature(3, 4), new Key(f)),
    r4, a8, bes8, d8+, c8+, t.to(110), c2.dot+, r4, a8, bes8, d8+, c8+, c2.dot+,
    r4, a8, bes8, d8+, c8+, c+, a8, bes8, d8+, c8+, c+, f8+, g8+, a8+, bes8+, a2+, bes+,
    g2.dot+, g2.dot+, r4, ges8+, g8+, a8+, bes8+, g2.dot+,
    r4, d8+, e8+, f8+, g8+, f+, d8+, e8+, f8+, g8+, e+, c8+, d8+, e8+, c8+, a2.dot,
    r4, a8, bes8, d8+, c8+, c2.dot+, r4, a8, bes8, d8+, c8+, c2.dot+,
    r4, a8, bes8, d8+, c8+, c+, f8+, g8+, a8+, f8+,  d8++, c8++, bes8+, a8+, as8+, a8+,  c8++, bes8+, a8+, bes8+, d8+, e8+,  f2+, f8+, g8+,
    a8+, e8+, es8+, e8+, a8+, bes8+,  g8+, a8+, f8+, g8+, e8+, a8,  g8+, f8+, e8+, f8+, g8+, f8+,  d2++, d8+, e8+,  f.dot+, e8+, g8+, f8+,  bes+, e+, d8+, e8+,
    f.dot+, e8+, d8+, e8+,  c2++, d8+, e8+,  f.dot+, e8+, g8+, f8+,  bes+, e+, g+,  f2+, Chord(g-, bes-), t.to(80),  Chord(f2.dot-, a2.dot-))
                                                  //> right  : de.htwg.scalala.music.sequences.Line = p1/4, A1/8, Bâ™­1/8, D'1/8,
                                                  //|  C'1/8, TempoChange(110), C'1/2Â·, p1/4, A1/8, Bâ™­1/8, D'1/8, C'1/8, C'1/2
                                                  //| Â·, p1/4, A1/8, Bâ™­1/8, D'1/8, C'1/8, C'1/4, A1/8, Bâ™­1/8, D'1/8, C'1/8, 
                                                  //| C'1/4, F'1/8, G'1/8, A'1/8, Bâ™­'1/8, A'1/2, Bâ™­'1/4, G'1/2Â·, G'1/2Â·, p1
                                                  //| /4, Gâ™­'1/8, G'1/8, A'1/8, Bâ™­'1/8, G'1/2Â·, p1/4, D'1/8, E'1/8, F'1/8, G
                                                  //| '1/8, F'1/4, D'1/8, E'1/8, F'1/8, G'1/8, E'1/4, C'1/8, D'1/8, E'1/8, C'1/8,
                                                  //|  A1/2Â·, p1/4, A1/8, Bâ™­1/8, D'1/8, C'1/8, C'1/2Â·, p1/4, A1/8, Bâ™­1/8, D
                                                  //| '1/8, C'1/8, C'1/2Â·, p1/4, A1/8, Bâ™­1/8, D'1/8, C'1/8, C'1/4, F'1/8, G'1/
                                                  //| 8, A'1/8, F'1/8, D"1/8, C"1/8, Bâ™­'1/8, A'1/8, Aâ™­'1/8, A'1/8, C"1/8, Bâ™
                                                  //| ­'1/8, A'1/8, Bâ™­'1/8, D'1/8, E'1/8, F'1/2, F'1/8, G'1/8, A'1/8, E'1/8, Eâ
                                                  //| ™­'1/8, E'1/8, A'1/8, Bâ™­'1/8, G'1/8, A'1/8, F'1/8, G'1/8, E'1/8, A1/8, G'
                                                  //| 1/8, F'1/8, E'1/8, F'1/8, G'1/8, F'1/8, D"1/2, D'1/8, E'1/8, F'1/4Â·, E'1/8
                                                  //| , G'1/8, F'1/8, Bâ™­'1/
                                                  //| Output exceeds cutoff limit.

  var left = Line(new Measure(new TimeSignature(3, 4), new Key(f)),
    r2.dot, t.to(110), f-, Chord(a-, c), Chord(a-, c), c-, Chord(a-, c), Chord(a-, c), f-, Chord(a-, c), Chord(a-, c),
    c-, Chord(a-, c), Chord(a-, c), f-, Chord(a-, c), Chord(a-, c), a--, Chord(a-, c), Chord(a-, c), c-, Chord(bes-, e), Chord(bes-, e),
    c-, Chord(bes-, e), Chord(bes-, e), g-, Chord(bes-, d), Chord(d, g), Chord(g-, d, ges), d, Chord(bes-, d), c-, Chord(g-, c, e), Chord(g-, c, e),
    c-, Chord(g-, c), Chord(g-, c), g--, Chord(bes-, d), Chord(bes-, d), c-, Chord(g-, c), Chord(as-, c), f-, Chord(a-, c), Chord(a-, c),
    Chord(c2.dot-, bes2.dot-, e.dot-),
    f-, Chord(a-, c), Chord(a-, c), c-, Chord(a-, c), Chord(a-, c), f-, Chord(a-, c), Chord(a-, c),
    c-, Chord(a-, c), Chord(a-, c), f-, Chord(a-, es), Chord(a-, es),  a--, Chord(a-, es), Chord(a-, es),  bes--, Chord(d, f), Chord(d-, f),
    Chord(b2.dot--, d2.dot, f2.dot),  des8-, e8-, a8-, des8, e8, g8,  Chord(a8-, des8, e8), f8, d8, e8, Chord(e8-, des8), Chord(g8-, a8-),
    d-, Chord(f-, a-), c-,  Chord(bes2.dot--, bes2.dot-, d2.dot),  c-, Chord(f-, a-), Chord(f-, a-),  c-, Chord(e2-, bes2-),
    c-, Chord(f-, a-), Chord(f-, a-),  Chord(d8-, bes8-), Chord(e8-, c8), Chord(c-, e-), bes--,  a8--, c8-, f8-, a8-, bes8-, a8-,
    Chord(c-, c), Chord(bes2--, c2-, e2-),  f-, Chord(a-, c), c-,  t.to(80), f2.dot--)
                                                  //> left  : de.htwg.scalala.music.sequences.Line = p1/2Â·, TempoChange(110), F,
                                                  //| 1/4, [A,1/4, C1/4], [A,1/4, C1/4], C,1/4, [A,1/4, C1/4], [A,1/4, C1/4], F,1
                                                  //| /4, [A,1/4, C1/4], [A,1/4, C1/4], C,1/4, [A,1/4, C1/4], [A,1/4, C1/4], F,1/
                                                  //| 4, [A,1/4, C1/4], [A,1/4, C1/4], A,,1/4, [A,1/4, C1/4], [A,1/4, C1/4], C,1/
                                                  //| 4, [Bâ™­,1/4, E1/4], [Bâ™­,1/4, E1/4], C,1/4, [Bâ™­,1/4, E1/4], [Bâ™­,1/4, 
                                                  //| E1/4], G,1/4, [Bâ™­,1/4, D1/4], [D1/4, G1/4], [G,1/4, D1/4, Gâ™­1/4], D1/4,
                                                  //|  [Bâ™­,1/4, D1/4], C,1/4, [G,1/4, C1/4, E1/4], [G,1/4, C1/4, E1/4], C,1/4, 
                                                  //| [G,1/4, C1/4], [G,1/4, C1/4], G,,1/4, [Bâ™­,1/4, D1/4], [Bâ™­,1/4, D1/4], C
                                                  //| ,1/4, [G,1/4, C1/4], [Aâ™­,1/4, C1/4], F,1/4, [A,1/4, C1/4], [A,1/4, C1/4],
                                                  //|  [C,1/2Â·, Bâ™­,1/2Â·, E,1/4Â·], F,1/4, [A,1/4, C1/4], [A,1/4, C1/4], C,1/4
                                                  //| , [A,1/4, C1/4], [A,1/4, C1/4], F,1/4, [A,1/4, C1/4], [A,1/4, C1/4], C,1/4,
                                                  //|  [A,1/4, C1/4], [A,1/4, C1/4], F,1/4, [A,1/4, Eâ™­1/4], [A,1/4, Eâ™­1/4], A
                                                  //| ,,1/4, [A,1/4, Eâ™­1/4]
                                                  //| Output exceeds cutoff limit.|

  RightPiano.play(right)
  LeftPiano.play(left)
  //DrumPlayer.play(*Pattern(1,0,0,0)*4)
}