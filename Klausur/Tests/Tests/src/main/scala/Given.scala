
trait Monoid[A] {
def zero: A
def combine(x: A, y: A): A
}

given intAdditionMonoid: Monoid[Int] with {
def zero: Int = 0
def combine(x: Int, y: Int): Int = x + y
}

given optionMonoid[A](using monoid: Monoid[A]): Monoid[Option[A]] with {
def zero: Option[A] = None
def combine(x: Option[A], y: Option[A]): Option[A] =
  (x, y) match {
    case (Some(a), Some(b)) => Some(monoid.combine(a, b)) // Nutze ursprüngliches Monoid
    case (Some(a), None)    => Some(a)
    case (None, Some(b))    => Some(b)
    case (None, None)       => None
  }
}

def sumOptions[A](list: List[Option[A]])(using monoid: Monoid[Option[A]]): Option[A] = {
list.foldLeft(monoid.zero)(monoid.combine)

object Given extends App {
  val numbers: List[Option[Int]] = List(Some(1), None, Some(3), Some(4))
  println(sumOptions(numbers)) // Ausgabe: Some(8)
}