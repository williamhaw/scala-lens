package lens

import models.{Address, Street}
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
  }

}
