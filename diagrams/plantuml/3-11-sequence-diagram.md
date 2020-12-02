```plantuml
@startuml

autonumber

[o-> ReservationSystem: makeReservation\n(List<FlightInstance>)
activate ReservationSystem
ReservationSystem -> Passenger: makeReservation()
activate Passenger
Passenger -> Reservation: createReservation()
activate Reservation
deactivate Reservation
Passenger -> Passenger: addReservation()
activate Passenger
deactivate Passenger

@enduml
```