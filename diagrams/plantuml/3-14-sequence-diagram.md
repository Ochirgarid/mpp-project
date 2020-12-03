```plantuml
@startuml

autonumber

[o->ReservationSystem: cancelReservation\n(passenger,\nreservationCode)
activate ReservationSystem
ReservationSystem->Agent: cancelReservation\n(passenger,\nreservationCode)
activate Agent
Agent -> Reservation: cancel(reservationCode)
activate Reservation
Reservation -> Reservation: findReservationByCode\n(reservationCode)
activate Reservation
deactivate Reservation
Reservation -> Reservation: setStatus(CANCEL)
activate Reservation
deactivate Reservation

@enduml
```