import lejos.nxt.*;
/** Arena.java
  * Folge einer schwarzen Linie sowohl nach rechts als auch nach links.
  * @version vom 07.08.2018
  * @author Falk Rismansanj
  */
public class Arena {

  public static void main(String[] args) throws Exception {
    BasisRoboterNXT robbi = new BasisRoboterNXT();
    // Schreibe Splasch-Screen Zeile für Zeile aufs LCD
    LCD.drawString("Lego-Roboter", 0, 1);
    LCD.drawString("@ blista/CSS", 0, 2);
    LCD.drawString("Arena.java", 0, 3);
    LCD.drawString("By Falk R.", 0, 4);
    // Warte 8 Sekunden
    Thread.sleep(8000);
    // Lösche den Splasch-Screen vom LCD
    LCD.clear();
    // Tonfolge Aufsteigend spielen
    robbi.spieleTonfolgeAufsteigend();
    // Fahre so lange Geradeaus, bis sich der gemessene Lichtwert ändert.
    while(true){
    robbi.vor();
    // Wenn wir von der schwarzen Linie abkokommen bremese.
    while (robbi.gibLichtwert() < 500) {}
    robbi.schnellstop();
    // Wenn wir auf der schwarzen Linie sind fahr zurück.
    while (robbi.gibLichtwert() > 500) {
    robbi.zurueck();
    }
    // Fahre nach rechts wenn wir auf der Linie sind.
    robbi.rechts(10);
    // Fahre nach links wenn wir auf der Linie sind.
    if (robbi.gibLichtwert() > 500) {
    robbi.links(13);
    }
    // Fahre nach rechts wenn wir auf der Linie sind.
    if (robbi.gibLichtwert() > 500)
    robbi.rechts(10);
    }
    }
 } // main