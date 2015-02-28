C[+T] - more general; to do czego staramy sie przypisac wartosc jest BARDZIEJ generalne
C[-T] - more general; to do czego staramy sie przypisac wartosc jest MNIEJ generalne

trait C[+T] - kowariant

trait Parrent
trait Bottom extends Parrent

val a: C[Parent] = new C[Bottom]

trait C[-T] - kontrawariant

val b: C[Bottom] = new C[Parrent]