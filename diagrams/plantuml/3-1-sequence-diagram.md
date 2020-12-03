```plantuml
@startuml

Actor Passenger

autonumber
Passenger-> ReservationSystem : findAllAirports()
activate ReservationSystem
ReservationSystem -> ReservationSystemRepository: findAllAirports()
activate ReservationSystemRepository
ReservationSystemRepository -> ReservationSystemRepository : findAllAirports()

activate ReservationSystemRepository
deactivate ReservationSystemRepository
deactivate ReservationSystemRepository

ReservationSystem -> Passenger: List<Airport>

@enduml
```