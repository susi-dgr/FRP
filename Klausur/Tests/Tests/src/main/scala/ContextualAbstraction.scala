def printToConsole(s: String)(implicit prompt: String) = println(prompt + " " + s)

trait Show[A] {
  def show(a: A): String
}

// Ein `given`-Wert für den Typ `Int`
given Show[Int] with {
  def show(a: Int): String = s"Int: $a"
}

// Ein `given`-Wert für den Typ `String`
given Show[String] with {
  def show(a: String): String = s"String: $a"
}

// Eine Funktion, die `Show[A]` benötigt
def printValue[A](a: A)(using showInstance: Show[A]) =
  println(showInstance.show(a))

object ContextualAbstraction extends App {
  implicit val p: String = "=>"
  printToConsole("hello")("->") // -> hello
  printToConsole("world") // => world

  printValue(12) // Nutzt automatisch den `given Show[Int]`
  printValue("test") // Nutzt automatisch den `given Show[String]`
}