package de.htwg.scalala.music.elements

import de.htwg.scalala.music._

case class Chord(notes: Vector[Note], value: Int, volume: Int = 75, name: String = "") extends MusicElement {
  def play(instrument: Instrument = Piano, volume: Int = volume) = {
    instrument.midiPlayer.play(notes, volume = volume)
  }

  override def toString = if (name == "") "[" + (notes mkString ", ") + "]" else name
  override def equals(that: Any): Boolean =
    that match {
      case that: Chord => (this.notes == that.notes)
      case _ => false
    }
}

object Chord {

  def apply(notes: Note*): Chord = {
    Chord(notes = notes.toVector, value = notes.head.value) //?
  }

  def apply(root: Note, chordQuality: ChordQuality.Value): Chord = {
    generateChord(root, chordQuality)
  }

  //naja
  def generateChord(root: Note, chordQuality: ChordQuality.Value): Chord = {
    chordQuality match {
      case ChordQuality.Major => Chord(Vector(root, majorThird(root), fifth(root)), name = root.toString.toUpperCase() + "Maj", value = root.value)
      case ChordQuality.Minor => Chord(Vector(root, minorThird(root), fifth(root)), name = root.toString.toUpperCase() + "min", value = root.value)
      case ChordQuality.Diminshed => Chord(Vector(root, minorThird(root), tritone(root)), name = root.toString.toUpperCase() + "dim", value = root.value)
      case ChordQuality.Augmented => Chord(Vector(root, majorThird(root), minorSixth(root)), name = root.toString.toUpperCase() + "aug", value = root.value)
      case ChordQuality.Seventh => Chord(Vector(root, majorThird(root), fifth(root), minorSeventh(root)), name = root.toString.toUpperCase() + "7", value = root.value)
      case ChordQuality.MajorSeventh => Chord(Vector(root, majorThird(root), fifth(root), majorSeventh(root)), name = root.toString.toUpperCase() + "Maj7", value = root.value)
      case ChordQuality.MinorSeventh => Chord(Vector(root, minorThird(root), fifth(root), majorSeventh(root)), name = root.toString.toUpperCase() + "min7", value = root.value)
      case ChordQuality.SuspendedFourth => Chord(Vector(root, fourth(root), fifth(root)), name = root.toString.toUpperCase() + "sus4", value = root.value)
      case ChordQuality.SuspendedSecond => Chord(Vector(root, majorSecond(root), fifth(root)), name = root.toString.toUpperCase() + "sus2", value = root.value)
      case ChordQuality.MajorSixth => Chord(Vector(root, majorThird(root), fifth(root), majorSixth(root)), name = root.toString.toUpperCase() + "6", value = root.value)
      case ChordQuality.MinorSixth => Chord(Vector(root, minorThird(root), fifth(root), majorSixth(root)), name = root.toString.toUpperCase() + "min6", value = root.value)
      case ChordQuality.Fifth => Chord(Vector(root, fifth(root), octave(root)), name = root.toString.toUpperCase() + "5", value = root.value)
    }
  }

  def minorSecond(root: Note) = root.copy(pitch = root.pitch + 1)
  def majorSecond(root: Note) = root.copy(pitch = root.pitch + 2)
  def minorThird(root: Note) = root.copy(pitch = root.pitch + 3)
  def majorThird(root: Note) = root.copy(pitch = root.pitch + 4)
  def fourth(root: Note) = root.copy(pitch = root.pitch + 5)
  def tritone(root: Note) = root.copy(pitch = root.pitch + 6)
  def fifth(root: Note) = root.copy(pitch = root.pitch + 7)
  def minorSixth(root: Note) = root.copy(pitch = root.pitch + 8)
  def majorSixth(root: Note) = root.copy(pitch = root.pitch + 9)
  def minorSeventh(root: Note) = root.copy(pitch = root.pitch + 10)
  def majorSeventh(root: Note) = root.copy(pitch = root.pitch + 11)
  def octave(root: Note) = root.copy(pitch = root.pitch + 12)
}

object ChordQuality extends Enumeration {
  type ChordQuality = Value
  val Major, Minor, Diminshed, Augmented, Seventh, MajorSeventh, MinorSeventh, SuspendedFourth, SuspendedSecond, MajorSixth, MinorSixth, Fifth = Value //jazz chords evtl noch
}