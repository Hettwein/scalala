package de.htwg.scalala.music

import de.htwg.scalala.players._
import scala.language.postfixOps
 
object Greensleeves {

  val Lead = player(Violin, "lead")               //> Nov 01, 2016 2:42:02 PM java.util.prefs.WindowsPreferences <init>
                                                  //| WARNING: Could not open/create prefs root node Software\JavaSoft\Prefs at ro
                                                  //| ot 0x80000002. Windows RegCreateKeyEx(...) returned error code 5.
                                                  //| Lead  : de.htwg.scalala.players.MusicPlayer = Actor[akka://Orchestra/user/le
                                                  //| adPlayer#846986597]
  val Chords  = player(Flute, "chords")           //> Chords  : de.htwg.scalala.players.MusicPlayer = Actor[akka://Orchestra/user/
                                                  //| chordsPlayer#-687115193]
  
  var right = Line(f, g8, a8.dot, b16, a8,  g, e8, c8.dot, d16, e8,  f, d8, d8.dot, c16, d8,  e, c8, a-, d8,
  								 f, g8, a8.dot, b16, a8,  g, e8, c8.dot, d16, e8,  f8.dot, e16, d8, cis8, b8-, cis8,  d.dot, d, d8,
  								 f, g8, a8.dot, b16, a8,  g, e8, c8.dot, d16, e8,  f, d8, d8.dot, c16, d8,  e, c8, a-, d8,
  								 f, g8, a8.dot, b16, a8,  g, e8, c8.dot, d16, e8,  f8.dot, e16, d8, cis8, b8-, cis8,  d, d8, d)
                                                  //> right  : de.htwg.scalala.music.Line = [f, g1/8, a1/8Â·, b1/16, a1/8, g, e1/8
                                                  //| , c1/8Â·, d1/16, e1/8, f, d1/8, d1/8Â·, c1/16, d1/8, e, c1/8, a,, d1/8, f, g
                                                  //| 1/8, a1/8Â·, b1/16, a1/8, g, e1/8, c1/8Â·, d1/16, e1/8, f1/8Â·, e1/16, d1/8,
                                                  //|  câ™¯1/8, b,1/8, câ™¯1/8, dÂ·, d, d1/8, f, g1/8, a1/8Â·, b1/16, a1/8, g, e1/
                                                  //| 8, c1/8Â·, d1/16, e1/8, f, d1/8, d1/8Â·, c1/16, d1/8, e, c1/8, a,, d1/8, f, 
                                                  //| g1/8, a1/8Â·, b1/16, a1/8, g, e1/8, c1/8Â·, d1/16, e1/8, f1/8Â·, e1/16, d1/8
                                                  //| , câ™¯1/8, b,1/8, câ™¯1/8, d, d1/8, d]
  var left = Line(Chord(d2.dot-, ChordQuality.Minor), Chord(c2.dot-, ChordQuality.Major), Chord(d2.dot-, ChordQuality.Minor), Chord(a2.dot-, ChordQuality.Minor),
  							  Chord(d2.dot-, ChordQuality.Minor), Chord(c2.dot-, ChordQuality.Major), Chord(d.dot-, ChordQuality.Minor), Chord(a.dot-, ChordQuality.Seventh), Chord(d.dot-, ChordQuality.Minor), Chord(g.dot-, ChordQuality.Major),
  							  Chord(f.dot-, ChordQuality.Major), Chord(g.dot-, ChordQuality.Seventh), Chord(c.dot-, ChordQuality.Major), Chord(a.dot-, ChordQuality.Minor), Chord(d.dot-, ChordQuality.Minor), Chord(g.dot-, ChordQuality.Seventh), Chord(c.dot-, ChordQuality.Major), Chord(a.dot-, ChordQuality.Minor),
  							  Chord(f.dot-, ChordQuality.Major), Chord(g.dot-, ChordQuality.Seventh), Chord(c.dot-, ChordQuality.Major), Chord(a.dot-, ChordQuality.Minor), Chord(d.dot-, ChordQuality.Minor), Chord(a.dot-, ChordQuality.Seventh), Chord(d2.dot-, ChordQuality.Minor))
                                                  //> left  : de.htwg.scalala.music.Line = [D,Â½Â·min, C,Â½Â·maj, D,Â½Â·min, A,Â½
                                                  //| Â·min, D,Â½Â·min, C,Â½Â·maj, D,Â·min, A,Â·7, D,Â·min, G,Â·maj, F,Â·maj, G,Â
                                                  //| ·7, C,Â·maj, A,Â·min, D,Â·min, G,Â·7, C,Â·maj, A,Â·min, F,Â·maj, G,Â·7, C,Â
                                                  //| ·maj, A,Â·min, D,Â·min, A,Â·7, D,Â½Â·min]|
  
  Lead.play(right)
  Chords.play(left)
  
  //DrumPlayer.play(c*Pattern(1,0,0,0)*4)
}