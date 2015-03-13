package Day0

object Day0Stuff {

  trait Monoid[A] {
    def mappend(a1: A, a2: A): A
    def mzero: A
  }

  object Monoid {
    implicit val IntMonoid: Monoid[Int] = new Monoid[Int] {
      def mappend(a1: Int, a2: Int): Int = a1 + a2
      def mzero: Int = 0
    }

    implicit val StringMonoid: Monoid[String] = new Monoid[String] {
      def mappend(a1: String, a2: String): String = a1 + a2
      def mzero: String = ""
    }
  }

  trait FoldLeft[F[_]] {
    def foldLeft[A, B](xs: F[A], b: B, f: (B, A) => B): B
  }

  object FoldLeft {
    implicit val FoldLeftList: FoldLeft[List] = new FoldLeft[List] {
      def foldLeft[A, B](xs: List[A], b: B, f: (B, A) => B) = xs.foldLeft(b)(f)
    }
  }

  trait MonoidOp[A] {
    val F: Monoid[A]
    val value: A
    def |+|(a2: A) = F.mappend(value, a2)
  }

  object Stuff {

    implicit def toMonoidOp[A: Monoid](a: A): MonoidOp[A] = new MonoidOp[A] {
      val F: Monoid[A] = implicitly[Monoid[A]]
      val value: A = a
    }

    def sum[M[_]: FoldLeft, A: Monoid](xs: M[A]): A = {
      val m = implicitly[Monoid[A]]
      val fl = implicitly[FoldLeft[M]]
      fl.foldLeft(xs, m.mzero, m.mappend)
    }

  }

}
