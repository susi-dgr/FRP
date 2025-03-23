# Funktionale Datenstrukturen

## Was macht funktionale Datenstrukturen aus?
- unveränderbar
- basieren auf algebraischen Strukturen
- Operationen auf Datenstrukturen erzeugen neue Datenstrukturen
- haben ähnliche Eigenschaften wie Wertetypen
- Effiziente Konzepte für persistent Collections (hashtables, finger trees, ...)

## Wie kann man ADTs in Scala implementieren?
- ADTs sind algebraische Datentypen
- ADTs können in Scala durch `sealed trait` und `case class` implementiert werden

```scala
sealed trait Shape // nur in der Datei definierte Klassen können Shape erweitern
case class Rect(pos: Point, w: Int, h: Int) extends Shape
case class Circle(pos: Point, radius: Int) extends Shape
```

## Was ist besonders an case classes?
- unveränderbar (public final)
- haben automatisch `equals`, `hashCode`, `toString` und `copy` Methoden
- erlauben Pattern Matching

## Was kann man noch verwenden um einfache ADTs zu implementieren?
- Enumerationen mit enum classes 
```scala
enum Shape :
    case Rect(pos: Point, w: Int, h: Int) extends Shape
    case Circle(pos: Point, radius: Int) extends Shape
``` 

## Wie funktioniert Pattern Matching in Scala?
- überprüft Typ und reagiert darauf
- arbeitet mit Mustern, die mit den Werten im Code verglichen werden
```scala
x match {
  case pattern1 => result1
  case pattern2 => result2
  case _ => defaultResult  // catch-all Pattern für alle anderen Fälle
}
```
- x ist der Wert, der überprüft wird
- case pattern => result ist ein Pattern, das mit x verglichen wird und 
```scala 
val x = 5
x match {
  case 1 => println("Eins")
  case 2 => println("Zwei")
  case 3 => println("Drei")
  case _ => println("Andere Zahl")
}
```

## Was ist Option in Scala?
- Option ist ein ADT, der entweder einen Wert `Some` oder `None` enthält
```scala	
val optPrime : Option[Int] = list123.find(x => isPrime(x)) // erstes Element, das die Bedingung erfüllt oder None

optPrime match {
  case Some(x) => println(x)
  case None => println("Keine Primzahl gefunden")
}
```