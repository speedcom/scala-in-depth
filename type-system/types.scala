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
x.bar(y.y) // success with #