// lower bound-type
class A {
  type B >: List[Int]
  def foo(a: B) = a
}

val a = new A { type B = Traversable[Int] }
a.foo(Set(1))

// upper bound-type
class C {
  type D <: Traversable[Int]
  def count(d: D) = d.foldLeft(0)(_ + _)
}
val c = new C { type D = List[Int] }