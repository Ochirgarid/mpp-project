```plantuml
@startuml

Actor Agent
autonumber
Agent->ReservationSystem: findAirportByAirportCode\n(airportCode)
activate ReservationSystem

ReservationSystem -> ReservationSystemRepository: findAirportByAirportCode\n(airportCode)
activate ReservationSystemRepository
ReservationSystemRepository -> ReservationSystemRepository: findAllAirports()

ReservationSystem->Agent: Airport

@enduml
```