```plantuml
@startuml

autonumber

[o->ReservationSystem: confirmAndPurchase\n(reservationCode)
activate ReservationSystem
ReservationSystem -> Agent: confirmAndPurchase\n(reservationCode)
activate Agent
Agent -> Agent:findReservationByCode\n(reservationCode)
Agent -> Reservation: confirmAndPurchase\n(reservation)
activate Reservation
loop for all flight
    Reservation -> Flight: getFlight()
    activate Flight
    deactivate Flight
    Reservation -> Ticket: createTicket\n(reservationCode, flight)
    Ticket -> Ticket: generateNumber()
    activate Ticket
    deactivate Ticket
end

Reservation -> Reservation: setStatus\n(CONFIRMED_PURCHASED)
activate Reservation
deactivate Reservation


@enduml
```