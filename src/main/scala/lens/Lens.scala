package lens

case class Lens[A, B](get: A => B, set: (A, B) => A)

object LensUtils {
  def compose[Outer, Inner, Value](
      outer: Lens[Outer, Inner],
      inner: Lens[Inner, Value]
  ): Lens[Outer, Value] =
    Lens[Outer, Value](
      get = outer.get andThen inner.get,
      set = (obj, value) => outer.set(obj, inner.set(outer.get(obj), value))
    )
}
