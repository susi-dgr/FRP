// Define the Monoid trait
trait Monoid[M] {
  val zero: M                      // Identity element
  def op(a: M, b: M): M             // Associative operation
}

// Companion object to create Monoids
object Monoid {
  def apply[M](z: M, operator: (M, M) => M): Monoid[M] = new Monoid[M] {
    override val zero: M = z
    override def op(a: M, b: M): M = operator(a, b)
  }

  // Define some common Monoids
  val intPlusMonoid: Monoid[Int] = Monoid(0, _ + _)
  val intTimesMonoid: Monoid[Int] = Monoid(1, _ * _)
  val doublePlusMonoid: Monoid[Double] = Monoid(0.0, _ + _)
  val stringMonoid: Monoid[String] = Monoid("", _ + _)

  def listMonoid[A]: Monoid[List[A]] = Monoid(List.empty[A], _ ++ _)
  def setMonoid[A]: Monoid[Set[A]] = Monoid(Set.empty[A], _ union _)
}

// Higher-order function using `reduce`
def reduceAll[M](xs: List[M])(implicit m: Monoid[M]): M =
  xs.reduce(m.op) // Uses reduction (throws exception if empty)

// Higher-order function using `fold`
def foldAll[M](xs: List[M])(implicit m: Monoid[M]): M =
  xs.fold(m.zero)(m.op) // Safe, handles empty lists

// Main method to run the program
object MonoidDemo extends App {
  import Monoid._

  // Example Lists
  val numbers = List(1, 2, 3, 4)
  val words = List("Hello", " ", "World!")
  val lists = List(List(1, 2), List(3, 4))
  val sets = List(Set(1, 2), Set(2, 3), Set(4))

  // Explicitly specifying which Monoid to use
  val sumReduce = reduceAll(numbers)(intPlusMonoid) // 10
  val wordReduce = reduceAll(words)(stringMonoid)  // "Hello World!"

  // Using `fold`
  val sumFold = foldAll(numbers)(intPlusMonoid) // 10
  val emptyFold = foldAll(List.empty[Int])(intPlusMonoid) // 0 (safe)

  // Print results
  println(s"Reduce Sum: $sumReduce")
  println(s"Reduce Words: $wordReduce")
  println(s"Fold Sum: $sumFold")
  println(s"Fold on Empty List: $emptyFold")
}
