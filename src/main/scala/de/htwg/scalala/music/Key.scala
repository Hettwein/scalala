package de.htwg.scalala.music

import de.htwg.scalala.music.elements.Note

case class Key(root: Note = C, mode: ScaleType.Value = ScaleType.Major) {

  //  def signs(): Sign = {
  ////    if(mode == ScaleType.Major) root = 
  //    sign(root)
  //  }

  def sign(note: Note = root, mode: ScaleType.Value = ScaleType.Major): Sign = {
    val s = Map(
      (c, ScaleType.Major) -> Sign(Vector(), SignMode.Sharp),
      (a, ScaleType.Minor) -> Sign(Vector(), SignMode.Sharp),

      (g, ScaleType.Major) -> Sign(Vector(6), SignMode.Sharp),
      (e, ScaleType.Minor) -> Sign(Vector(1), SignMode.Sharp),
      (d, ScaleType.Major) -> Sign(Vector(6, 2), SignMode.Sharp),
      (b, ScaleType.Minor) -> Sign(Vector(1, 5), SignMode.Sharp),
      (a, ScaleType.Major) -> Sign(Vector(6, 2, 5), SignMode.Sharp),
      (fis, ScaleType.Minor) -> Sign(Vector(1, 5, 0), SignMode.Sharp),
      (e, ScaleType.Major) -> Sign(Vector(6, 2, 5, 1), SignMode.Sharp),
      (cis, ScaleType.Minor) -> Sign(Vector(1, 5, 0, 4), SignMode.Sharp),
      (b, ScaleType.Major) -> Sign(Vector(6, 2, 5, 1, 4), SignMode.Sharp),
      (ais, ScaleType.Minor) -> Sign(Vector(1, 5, 0, 4, 6), SignMode.Sharp),
      (fis, ScaleType.Major) -> Sign(Vector(6, 2, 5, 1, 4, 0), SignMode.Sharp),
      (eis, ScaleType.Minor) -> Sign(Vector(1, 5, 0, 4, 6, 2), SignMode.Sharp),

      (f, ScaleType.Major) -> Sign(Vector(3), SignMode.Flat),
      (d, ScaleType.Minor) -> Sign(Vector(5), SignMode.Flat),
      (b, ScaleType.Major) -> Sign(Vector(3, 0), SignMode.Flat),
      (g, ScaleType.Minor) -> Sign(Vector(5, 2), SignMode.Flat),
      (es, ScaleType.Major) -> Sign(Vector(3, 0, 4), SignMode.Flat),
      (c, ScaleType.Minor) -> Sign(Vector(5, 2, 6), SignMode.Flat),
      (as, ScaleType.Major) -> Sign(Vector(3, 0, 4, 1), SignMode.Flat),
      (f, ScaleType.Minor) -> Sign(Vector(5, 2, 6, 3), SignMode.Flat),
      (des, ScaleType.Major) -> Sign(Vector(3, 0, 4, 1, 5), SignMode.Flat),
      (bes, ScaleType.Minor) -> Sign(Vector(5, 2, 6, 3, 0), SignMode.Flat),
      (ges, ScaleType.Major) -> Sign(Vector(3, 0, 4, 1, 5, 2), SignMode.Flat),
      (fes, ScaleType.Minor) -> Sign(Vector(5, 2, 6, 3, 0, 4), SignMode.Flat))

    s(note, mode)
  }

  val scale: Vector[Note] = {
    var s: Vector[Note] = ScaleType.scaleVector(mode).map(i => root.copy(pitch = root.pitch + i))
    sign(root).pos.map(i => s = s.updated(i, s(i).copy(sign = sign(root).mode)))
    s
  }

  val sharpSignsAt = Map(
    1 -> List(5),
    2 -> List(5, 0),
    3 -> List(5, 0, 7),
    4 -> List(5, 0, 7, 2),
    5 -> List(5, 0, 7, 2, 9),
    6 -> List(5, 0, 7, 2, 9, 4))

  val flatSignsAt = Map(
    1 -> List(11),
    2 -> List(11, 4),
    3 -> List(11, 4, 9),
    4 -> List(11, 4, 9, 2),
    5 -> List(11, 4, 9, 2, 7),
    6 -> List(11, 4, 9, 2, 7, 0))

}

object ScaleType extends Enumeration {
  val Major, Minor, Melodic, Harmonic, PentatonicMinorBlues, PentatonicMajorBlues, Ionian, Dorian, Phrygian, Lydian, Mixolydian, Aeolian, Locrian, PentatonicMinor, PentatonicMajor = Value

  val scaleVector = Map[ScaleType.Value, Vector[Int]](
    Major -> Vector(0, 2, 4, 5, 7, 9, 11, 12),
    Minor -> Vector(0, 2, 3, 5, 7, 8, 10, 12),
    Melodic -> Vector(0, 2, 3, 5, 7, 9, 11, 12),
    Harmonic -> Vector(0, 2, 3, 5, 7, 8, 11, 12),
    PentatonicMinorBlues -> Vector(0, 3, 5, 6, 7, 10, 12),
    PentatonicMajorBlues -> Vector(0, 2, 3, 4, 7, 9, 12),
    Ionian -> Vector(0, 2, 4, 5, 7, 9, 11, 12),
    Dorian -> Vector(0, 2, 3, 5, 7, 9, 10, 12),
    Phrygian -> Vector(0, 1, 3, 5, 7, 8, 10, 12),
    Lydian -> Vector(0, 2, 4, 6, 7, 9, 11, 12),
    Mixolydian -> Vector(0, 2, 4, 5, 7, 9, 10, 12),
    Aeolian -> Vector(0, 2, 3, 5, 7, 8, 10, 12),
    Locrian -> Vector(0, 1, 3, 5, 6, 8, 10, 12),
    PentatonicMinor -> Vector(0, 3, 5, 7, 10, 12),
    PentatonicMajor -> Vector(0, 2, 4, 7, 9, 12))
}