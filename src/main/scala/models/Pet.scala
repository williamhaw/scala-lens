package models

import prism.Prism

sealed trait Pet

case class Dog(name: String) extends Pet

object PetPrisms {
  val petPrism: Prism[Pet, String] = Prism[Pet, String] {
    case Dog(n) => Some(n)
    case _      => None
  }(name => Dog(name))
}
