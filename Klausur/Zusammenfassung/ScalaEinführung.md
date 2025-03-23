# Einführung in Scala

## Wie werden veränderliche und unveränderliche Variablen in Scala definiert?
- immutable mit **val**:
```scala	
val x = 5
```
- mutable mit **var**:
```scala
var y = 10
```

## Wie werden Methoden deklariert?
- Methoden werden mit dem Schlüsselwort **def** deklariert:
```scala
def max(list : List[Int]) : Int = {
    var m = Integer.MIN_VALUE
    for (x <- list) {
        if (x > m) then m = x
    }
    m
}
```

## Wie werden Klassen deklariert?
- Klassen werden mit dem Schlüsselwort **class** deklariert:
```scala
class Person:
    ...
```
oder mit Klammern:
```scala
class Person {
    ...
}
```

- Mit Erbschaft:
```scala
class Student extends Person:
    ...
    override def toString : String = ...
```

## Was sind traits und wie werden sie verwendet?
- traits sind wie Interfaces mit default Implementierungen:
```scala
trait Writeable :
    def write(out: PrintStream) : Unit
    def writeln(out: PrintStream) : Unit = {
        write(out)
        out.println()
    }
```

## Was sind objects und wie werden sie verwendet?
- objects sind Singleton-Instanzen einer Klasse:
```scala
object HelloWorld extends App :
    println("Hallo World")
```

## Was ist Type Inference?
- Scala kann Typen automatisch inferieren:
```scala
val list = List(2, 1, 4, 2) // List[Int]
```

## Wie werden Generics in Scala verwendet?
- Generics werden mit eckigen Klammern definiert:
```scala
class Box[T](val value: T)
```
- Methoden: 
```scala
def compose[A, B, C](f : A => B, g : B => C) : A => C =
    x => g(f(x))
```
-> nimmt zwei Funktionen als Parameter und gibt eine neue Funktion zurück. f wandelt einen Wert von Typ A in einen Wert von Typ B um, g wandelt einen Wert von Typ B in einen Wert von Typ C um. Die zusammengesetzte Funktion wandelt einen Wert von Typ A in einen Wert von Typ C um, indem sie f auf x anwendet und dann g auf das Ergebnis anwendet.