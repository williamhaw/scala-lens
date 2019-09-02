package prism

import models.Dog
import models.PetPrisms
import org.scalatest.{FlatSpec, Matchers}

class PrismSpec extends FlatSpec with Matchers {
  "The Prism" should "get product type as Option" in {
    PetPrisms.petPrism.getOption(Dog("Santa's Little Helper")) shouldEqual Some("Santa's Little Helper")
  }

  it should "get " in {
    PetPrisms.petPrism.reverseGet("Santa's Little Helper") shouldEqual Dog("Santa's Little Helper")
  }
}
