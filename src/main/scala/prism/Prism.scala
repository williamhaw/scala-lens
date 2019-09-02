package prism

case class Prism[S, A](_getOption: S => Option[A])(_reverseGet: A => S) {
  def reverseGet(a: A): S        = _reverseGet(a)
  def getOption(s: S): Option[A] = _getOption(s)
}
