package models

import lens.Lens
import lens.LensUtils.compose

case class Account(id: Long, user: User, isActive: Boolean)

case class User(id: Long, address: Address)

case class Address(country: String, city: String, street: Street)

case class Street(name: String, number: Int)

object AccountLenses{
  val streetNumberLens: Lens[Street, Int] = Lens[Street, Int](get = _.number, set = (a, b) => a.copy(number = b))
  val addressStreetLens: Lens[Address, Street] = Lens[Address, Street](get = _.street, set = (a, b) => a.copy(street = b))
  val addressStreetNumberLens: Lens[Address, Int] = compose(addressStreetLens, streetNumberLens)
  val userAddressLens: Lens[User, Address] = Lens[User, Address](get = _.address, set = (a, b) => a.copy(address = b))
  val accountUserLens: Lens[Account, User] = Lens[Account, User](get = _.user, set = (a, b) => a.copy(user = b))
  val accountStreetNumberLens: Lens[Account, Int] = compose(accountUserLens, compose(userAddressLens, compose(addressStreetLens, streetNumberLens)))
}