package lens

import models._
import org.scalatest.{FlatSpec, Matchers}
import models.AccountLenses._

class LensSpec extends FlatSpec with Matchers{

  "The Lens" should "get number of street from Street case class" in {
    val street = Street("Long Avenue", 3)
    streetNumberLens.get(street) shouldEqual 3
  }

  it should "set number of street in copy of Street case class" in {
    val street = Street("Short Street", 4)
    streetNumberLens.set(street, 25).number shouldEqual 25
    street.number shouldEqual 4
  }

  it should "get number of street from Address case class" in {
    val street = Street("Left Side", 10)
    val address = Address("USA", "New York", street)

    addressStreetNumberLens.get(address) shouldEqual 10

  }

  it should "set number of street in copy of Address case class" in {
    val street = Street("Left Side", 10)
    val address = Address("USA", "New York", street)

    addressStreetNumberLens.set(address, 3).street.number shouldEqual 3
    address.street.number shouldEqual 10
  }

  it should "get number of street from Account case class" in {
    val account = Account(1, User(2, Address("Brazil", "Sao Paolo", Street("Right Side", 3))), true)

    accountStreetNumberLens.get(account) shouldEqual 3
  }

  it should "set number of street in copy of Account case class" in {
    val account = Account(1, User(2, Address("Brazil", "Sao Paolo", Street("Right Side", 3))), true)

    accountStreetNumberLens.set(account, 10).user.address.street.number shouldEqual 10
    account.user.address.street.number shouldEqual 3
  }

}
