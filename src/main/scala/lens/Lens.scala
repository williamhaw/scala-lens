package lens

case class Lens[A, B](get: A => B, set: (A, B) => A)
