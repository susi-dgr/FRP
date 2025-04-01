import scala.concurrent.{Future, ExecutionContext}
import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global

object FutureExample extends App {

  // Simuliert eine asynchrone Berechnung
  val futureResult: Future[Int] = Future {
    println("Berechnung startet...")
    Thread.sleep(2000) // Simulierte Verzögerung
    42 // Rückgabewert der Berechnung
  }

  // Reaktion auf das Ergebnis des Futures
  futureResult.onComplete {
    case Success(value) => println(s"Berechnung abgeschlossen: Ergebnis = $value")
    case Failure(exception) => println(s"Fehler: ${exception.getMessage}")
  }

  println("Das Programm läuft weiter...")

  Thread.sleep(3000) // Warten, damit der Future abgeschlossen wird
}
