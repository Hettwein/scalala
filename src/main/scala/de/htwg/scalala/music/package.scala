package de.htwg.scalala

import de.htwg.scalala.music.elements._
import de.htwg.scalala.music.sequences.Line

package object music {

  val Piano = Instrument(name = "Piano", instrumentID = 0, channelID = 0)
  val Marimba = Instrument(name = "Marimba", instrumentID = 13, channelID = 1)
  val Xylophone = Instrument(name = "Xylophone", instrumentID = 14, channelID = 2)
  val Organ = Instrument(name = "Organ", instrumentID = 20, channelID = 3)
  val Guitar = Instrument(name = "Guitar", instrumentID = 25, channelID = 4)
  val Bass = Instrument(name = "Bass", instrumentID = 33, channelID = 5)
  val Violin = Instrument(name = "Violin", instrumentID = 41, channelID = 6)
  val Cello = Instrument(name = "Cello", instrumentID = 43, channelID = 7)
  val Trumpet = Instrument(name = "Trumpet", instrumentID = 57, channelID = 8)
  val Tuba = Instrument(name = "Tuba", instrumentID = 59, channelID = 10)
  val Horn = Instrument(name = "Horn", instrumentID = 61, channelID = 11)
  val Sax = Instrument(name = "Sax", instrumentID = 68, channelID = 12)
  val Oboe = Instrument(name = "Oboe", instrumentID = 69, channelID = 13)
  val Clarinet = Instrument(name = "Clarinet", instrumentID = 72, channelID = 14)
  val Flute = Instrument(name = "Flute", instrumentID = 74, channelID = 15)

  val DrumSet = Instrument(name = "DrumSet", instrumentID = 115, channelID = 9)

  val TomLowFloor, LFT = Note(pitch = 41, value = 12)
  val TomHighFloor, HFT = Note(43, 12)
  val TomLow, LT = Note(45, 24)
  val TomLowMid, LMT = Note(47, 12)
  val TomHiMid, HMT = Note(48, 12)
  val TomHigh, HT = Note(50, 12)

  val DrumAcousticBass, ABD = Note(35, 12)
  val DrumBass, BD = Note(36, 12)

  val SnareAcoustic, AS = Note(38, 12)
  val SnareElectric, ES = Note(40, 12)

  val SideStick, ss = Note(37, 12)
  val HandClap, hc = Note(39, 12)

  val HiHatClosed, xH = Note(42, 12)
  val HiHatPedal, pH = Note(44, 12)
  val HiHatOpen, oH = Note(46, 12)

  val CymbalCrash, CC = Note(49, 12)
  val CymbalRide, RC = Note(51, 12)
  val CymbalChinese, CHC = Note(52, 12)
  val CymbalSplash, SC = Note(55, 12)
  val CymbalCrash2, CC2 = Note(57, 12)
  val CymbalRide2, RC2 = Note(59, 12)

  val BongoHi, hBg = Note(60, 12)
  val BongoLow, lBg = Note(61, 12)

  val CongaMuteHi, xC = Note(62, 12)
  val CongaOpenHi, oC = Note(63, 12)
  val CongaLow, lC = Note(64, 12)

  val CowBell, cb = Note(56, 12)
      
  val t = new TempoChange(105)

  val C, c = Note(pitch = 60)
  val D, d = Note(pitch = 62)
  val E, e = Note(pitch = 64)
  val F, f = Note(pitch = 65)
  val G, g = Note(pitch = 67)
  val A, a = Note(pitch = 69)
  val B, b = Note(pitch = 71)

  val Cis, cis = c.sharp
  val Dis, dis = d.sharp
  val Eis, eis = e.sharp
  val Fis, fis = f.sharp
  val Gis, gis = g.sharp
  val Ais, ais = a.sharp
  val Bis, bis = b.sharp

  val Ces, ces = c.flat
  val Des, des = d.flat
  val Es, es = e.flat
  val Fes, fes = f.flat
  val Ges, ges = g.flat
  val As, as = a.flat
  val Bes, bes = b.flat

  val r1 = Rest(96)
  val r2 = Rest(48)
  val r3 = Rest(32)
  val r4 = Rest(24)
  val r6 = Rest(16)
  val r8 = Rest(12)
  val r12 = Rest(8)
  val r16 = Rest(6)
  val r32 = Rest(3)

  val ces1 = ces.copy(value = 96)
  val ces2 = ces.copy(value = 48)
  val ces3 = ces.copy(value = 32)
  val ces4 = ces.copy(value = 24)
  val ces6 = ces.copy(value = 16)
  val ces8 = ces.copy(value = 12)
  val ces12 = ces.copy(value = 8)
  val ces16 = ces.copy(value = 6)
  val ces32 = ces.copy(value = 3)

  val c1 = c.copy(value = 96)
  val c2 = c.copy(value = 48)
  val c3 = c.copy(value = 32)
  val c4 = c.copy(value = 24)
  val c6 = c.copy(value = 16)
  val c8 = c.copy(value = 12)
  val c12 = c.copy(value = 8)
  val c16 = c.copy(value = 6)
  val c32 = c.copy(value = 3)

  val cis1 = cis.copy(value = 96)
  val cis2 = cis.copy(value = 48)
  val cis3 = cis.copy(value = 32)
  val cis4 = cis.copy(value = 24)
  val cis6 = cis.copy(value = 16)
  val cis8 = cis.copy(value = 12)
  val cis12 = cis.copy(value = 8)
  val cis16 = cis.copy(value = 6)
  val cis32 = cis.copy(value = 3)

  val des1 = des.copy(value = 96)
  val des2 = des.copy(value = 48)
  val des3 = des.copy(value = 32)
  val des4 = des.copy(value = 24)
  val des6 = des.copy(value = 16)
  val des8 = des.copy(value = 12)
  val des12 = des.copy(value = 8)
  val des16 = des.copy(value = 6)
  val des32 = des.copy(value = 3)

  val d1 = d.copy(value = 96)
  val d2 = d.copy(value = 48)
  val d3 = d.copy(value = 32)
  val d4 = d.copy(value = 24)
  val d6 = d.copy(value = 16)
  val d8 = d.copy(value = 12)
  val d12 = d.copy(value = 8)
  val d16 = d.copy(value = 6)
  val d32 = d.copy(value = 3)

  val dis1 = dis.copy(value = 96)
  val dis2 = dis.copy(value = 48)
  val dis3 = dis.copy(value = 32)
  val dis4 = dis.copy(value = 24)
  val dis6 = dis.copy(value = 16)
  val dis8 = dis.copy(value = 12)
  val dis12 = dis.copy(value = 8)
  val dis16 = dis.copy(value = 6)
  val dis32 = dis.copy(value = 3)

  val es1 = es.copy(value = 96)
  val es2 = es.copy(value = 48)
  val es3 = es.copy(value = 32)
  val es4 = es.copy(value = 24)
  val es6 = es.copy(value = 16)
  val es8 = es.copy(value = 12)
  val es12 = es.copy(value = 8)
  val es16 = es.copy(value = 6)
  val es32 = es.copy(value = 3)

  val e1 = e.copy(value = 96)
  val e2 = e.copy(value = 48)
  val e3 = e.copy(value = 32)
  val e4 = e.copy(value = 24)
  val e6 = e.copy(value = 16)
  val e8 = e.copy(value = 12)
  val e12 = e.copy(value = 8)
  val e16 = e.copy(value = 6)
  val e32 = e.copy(value = 3)

  val eis1 = eis.copy(value = 96)
  val eis2 = eis.copy(value = 48)
  val eis3 = eis.copy(value = 32)
  val eis4 = eis.copy(value = 24)
  val eis6 = eis.copy(value = 16)
  val eis8 = eis.copy(value = 12)
  val eis12 = eis.copy(value = 8)
  val eis16 = eis.copy(value = 6)
  val eis32 = eis.copy(value = 3)

  val fes1 = fes.copy(value = 96)
  val fes2 = fes.copy(value = 48)
  val fes3 = fes.copy(value = 32)
  val fes4 = fes.copy(value = 24)
  val fes6 = fes.copy(value = 16)
  val fes8 = fes.copy(value = 12)
  val fes12 = fes.copy(value = 8)
  val fes16 = fes.copy(value = 6)
  val fes32 = fes.copy(value = 3)

  val f1 = f.copy(value = 96)
  val f2 = f.copy(value = 48)
  val f3 = f.copy(value = 32)
  val f4 = f.copy(value = 24)
  val f6 = f.copy(value = 16)
  val f8 = f.copy(value = 12)
  val f12 = f.copy(value = 8)
  val f16 = f.copy(value = 6)
  val f32 = f.copy(value = 3)

  val fis1 = fis.copy(value = 96)
  val fis2 = fis.copy(value = 48)
  val fis3 = fis.copy(value = 32)
  val fis4 = fis.copy(value = 24)
  val fis6 = fis.copy(value = 16)
  val fis8 = fis.copy(value = 12)
  val fis12 = fis.copy(value = 8)
  val fis16 = fis.copy(value = 6)
  val fis32 = fis.copy(value = 3)

  val ges1 = ges.copy(value = 96)
  val ges2 = ges.copy(value = 48)
  val ges3 = ges.copy(value = 32)
  val ges4 = ges.copy(value = 24)
  val ges6 = ges.copy(value = 16)
  val ges8 = ges.copy(value = 12)
  val ges12 = ges.copy(value = 8)
  val ges16 = ges.copy(value = 6)
  val ges32 = ges.copy(value = 3)

  val g1 = g.copy(value = 96)
  val g2 = g.copy(value = 48)
  val g3 = g.copy(value = 32)
  val g4 = g.copy(value = 24)
  val g6 = g.copy(value = 16)
  val g8 = g.copy(value = 12)
  val g12 = g.copy(value = 8)
  val g16 = g.copy(value = 6)
  val g32 = g.copy(value = 3)

  val gis1 = gis.copy(value = 96)
  val gis2 = gis.copy(value = 48)
  val gis3 = gis.copy(value = 32)
  val gis4 = gis.copy(value = 24)
  val gis6 = gis.copy(value = 16)
  val gis8 = gis.copy(value = 12)
  val gis12 = gis.copy(value = 8)
  val gis16 = gis.copy(value = 6)
  val gis32 = gis.copy(value = 3)

  val as1 = as.copy(value = 96)
  val as2 = as.copy(value = 48)
  val as3 = as.copy(value = 32)
  val as4 = as.copy(value = 24)
  val as6 = as.copy(value = 16)
  val as8 = as.copy(value = 12)
  val as12 = as.copy(value = 8)
  val as16 = as.copy(value = 6)
  val as32 = as.copy(value = 3)

  val a1 = a.copy(value = 96)
  val a2 = a.copy(value = 48)
  val a3 = a.copy(value = 32)
  val a4 = a.copy(value = 24)
  val a6 = a.copy(value = 16)
  val a8 = a.copy(value = 12)
  val a12 = a.copy(value = 8)
  val a16 = a.copy(value = 6)
  val a32 = a.copy(value = 3)

  val ais1 = ais.copy(value = 96)
  val ais2 = ais.copy(value = 48)
  val ais3 = ais.copy(value = 32)
  val ais4 = ais.copy(value = 24)
  val ais6 = ais.copy(value = 16)
  val ais8 = ais.copy(value = 12)
  val ais12 = ais.copy(value = 8)
  val ais16 = ais.copy(value = 6)
  val ais32 = ais.copy(value = 3)

  val bes1 = bes.copy(value = 96)
  val bes2 = bes.copy(value = 48)
  val bes3 = bes.copy(value = 32)
  val bes4 = bes.copy(value = 24)
  val bes6 = bes.copy(value = 16)
  val bes8 = bes.copy(value = 12)
  val bes12 = bes.copy(value = 8)
  val bes16 = bes.copy(value = 6)
  val bes32 = bes.copy(value = 3)

  val b1 = b.copy(value = 96)
  val b2 = b.copy(value = 48)
  val b3 = b.copy(value = 32)
  val b4 = b.copy(value = 24)
  val b6 = b.copy(value = 16)
  val b8 = b.copy(value = 12)
  val b12 = b.copy(value = 8)
  val b16 = b.copy(value = 6)
  val b32 = b.copy(value = 3)

  val bis1 = bis.copy(value = 96)
  val bis2 = bis.copy(value = 48)
  val bis3 = bis.copy(value = 32)
  val bis4 = bis.copy(value = 24)
  val bis6 = bis.copy(value = 16)
  val bis8 = bis.copy(value = 12)
  val bis12 = bis.copy(value = 8)
  val bis16 = bis.copy(value = 6)
  val bis32 = bis.copy(value = 3)

}