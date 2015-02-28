// objects as a parameter
object Now
object Simulate {
  def once(behaviour: () => Unit) = new {
    def right(now: Now.type): Unit = {
      behaviour()
    }
  }
}
Simulate once { () => println("Simulation...")} right Now

// path-dependent types && type-projection
class Outer {
  trait Inner

  def y = new Inner {}
  def foo(x: this.Inner) = null  // using path-dependent type
  def bar(x: Outer#Inner) = null // using projection of type
}
val x = new Outer
val y = new Outer

x.y // type is shown as x.Inner, not Outer#Inner or Outer.Inner
x.foo(x.y) // success
x.foo(y.y) // error - different instances

// !!!
x.bar(y.y) // success with

// 1. Example using path-dependent types
case class Board(length: Int, height: Int) {
  case class Coordinate(x: Int, y: Int) {
    require(0 <= x && x < length && 0 <= y && y < height)
  }
  val occupied = scala.collection.mutable.Set[Coordinate]()
}

val b1 = Board(10,20)
val b2 = Board(55, 100)
val c1 = b1.Coordinate(9,19)
val c2 = b2.Coordinate(54, 99)

b1.occupied += c1
b2.occupied += c2
// this wont compile
// b2.occupied += c1