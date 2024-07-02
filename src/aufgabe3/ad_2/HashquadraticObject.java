package Aufgabe4;

import java.util.HashMap;

public class HashquadraticObject {
private int value;

    public HashquadraticObject(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashquadraticObject that = (HashquadraticObject) o;
        return value == that.value;
    }
    @Override
    public int hashCode() {
        return 0;
    }}
/**
 *AufgabeA:
 *_________________________________________________
 * 1.
 * jedes Objekt liefert dasselbe Hashcode. Das heißt alle Einträge haben denselben Index.
 * Beim Hinzufügen eines Schlüssels 1,2,3....,i in das Hashtable mit Verkettung, sieht die Komplexität folgendermaßen aus:
 * T(1,2,3,.....i)=1+(T(1)+1)+((T(1)+1)+1) also = 1+T(2)+T(3)+T(4)+......+T(i) also= 1+2+3+4+.......+i = O(i°2)
 * Das ist auch naheliegend, denn beim Hinzufügen i unterschiedliche Schlüssel, muss jeweils die ganze verkette Liste durchiteriert werden.
 * °°°°°°°°°°°°°°°°°°°
 * 2.
 *Lineare Sondierung wird dasselbe Ergebnis liefern also quadratisch, denn wenn alle Objekte gleiches Hashcode i liefern, dann wird ab dem Index i immer weiter
 * iteriert, also i+1, i+2, i+3, ........ i+p für Schlüssel 1,2,3........,p
 * °°°°°°°°°°°°°°°°°°°°°
 * 5.
 * sei M unsere Array-Große und N Anzahl Schlüssel.
 * Hauptidee: Löschen und -Einfügen Operationen abwechselnd verwenden, um eine maximale Größenänderung auszulösen.
 * Beispiel: Startgröße =8
 * Einfügen:N=4 key1,key2,key3,key4 => Größe*2=16
 * Löschen:N=3 key1,key2 ,key3      => N=1<=Größe/8 = 2 => Größe/2=8
 *
 * Veralgemeinerung:
 * Für Arraygröße=M
 * Einfügen: M/2
 * Löschen: Solange bis N<=M/8
 * Wiederhole!
 * */
/**
 * Aufgabe D
 * */