package lens

import models.{Address, Street}
import org.scalatest.{FlatSpec, Matchers}
import lens.LensUtils._

class LensSpec extends FlatSpec with Matchers{

  val streetNumberLens: Lens[Street, Int] = Lens[Street, Int](get = _.number, set = (a, b) => a.copy(number = b))
  val addressStreetLens: Lens[Address, Street] = Lens[Address, Street](get = _.street, set = (a, b) => a.copy(street = b))
  val addressStreetNumberLens = compose(addressStreetLens, streetNumberLens)

  "The Lens" should "get value of attribute in case class" in {
    val street = Street("Long Avenue", 3)
    streetNumberLens.get(street) shouldEqual 3
  }

  "The Lens" should "set value in copy of case class" in {
    val street = Street("Short Street", 4)
    streetNumberLens.set(street, 25).number shouldEqual 25
  }

}
