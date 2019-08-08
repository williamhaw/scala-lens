package models

case class Account()

case class User(id: Long, address: Address)

case class Address(country: String, city: String, street: Street)

case class Street(name: String, number: Int)
