```plantuml
@startuml
autonumber
[o-> ReservationSystem : getAirports()
activate ReservationSystem
ReservationSystem -> Passenger: getAirports()
activate Passenger
Passenger -> Database : readAirportList()
activate Database
deactivate Database
deactivate Passenger
deactivate ReservationSystem

@enduml
```