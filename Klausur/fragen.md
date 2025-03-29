theoretische fragen:
* materialized value
* Closure
* reduceMap Funktionsweise erläutern können
* Future-Callbacks
* 3 grundlegende Aktoren-Operationen
* Akka-Stream-Terminologie erklären können (Processing Stages [Source, Flow, Sink], Materializer, RunnableGraph)
* Keyword sealed
* Wie kann man algebraische Datentypen erzeugen?
* Eigenschaften einer Case class nennen können (immutable, Default überschriebene Methoden, value type)


praktische fragen:

1. bintree mit predicate durchlaufen und pattern matching
2. map, flatmap, filter, sortBy, orderBy fuer zwei List(Race) ersteliste erster durchlauf zweite liste zweiter durchlauf
2.1 kombinieren und Zeiten addieren (auch anhand von … gruppieren)
2.2 filter
2.3 Partition
3. ???
4. Futures
Futures.traverse(seq)(sort)
merge(f1, f2)
5. Aktoren
5.1 Nachrichten definieren Command.Send und Command.Receive Reply.Result; dabei actorRef mitgeben in Nachrichten oder ueber apply
5.2 apply implementieren von MessageSender, MessageReceiver
6. Akka Streams
 parallelSum(seq, size, parallelism): Future(Double)
zuerst seq splitten in teilseq dann mit mapAsync summe von teilseq berechnen
dann mit moeglicherweise runFold(0)(a, b => a + b)(Keep.right) gesamt summe berechnen und materialized value von rechts behalten und zurueck geben  


mit Futuretraverse 2 sequenzen  parallelisiert sortieren und zusammenführen.

stream:

Sequenz in stream eingeben in teilsequenzen teilen nach Parameter parallelism, diese asyncron summieren und dann die Ergebnisse summieren