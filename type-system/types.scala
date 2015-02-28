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