def peek[A, C <: Traversable[A]](col: C) = (col.head, col)

// compile-error:
// peak(List(1,2,3)) - engine can not infered A type
peek[Int, List[Int]](List(1,2,3))

// second version with two list parameter
def peek[C, A](col: C)(implicit ev: C <:< Traversable[A]) = (col.head, col)

peek(List(1,2,3))