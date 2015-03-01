def peak[A, C <: Traversable[A]](col: C) = (col.head, col)

// compile-error:
// peak(List(1,2,3)) - engine can not infered A type
peak[Int, List[Int]](List(1,2,3))

