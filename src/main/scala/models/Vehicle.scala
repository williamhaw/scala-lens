package models

import lens.Lens

case class Vehicle(passengers: Seq[Passenger])

case class Passenger(name: String, id: Long, role: Option[Role])

case class Role(name: String)

object VehicleLenses {
  val passengerRoleNameLens: Lens[Passenger, Option[String]] = Lens[Passenger, Option[String]](
    get = _.role.map(_.name),
    set = (a, b) => a.copy(role = b.map(Role))
  )
}
