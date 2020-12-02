```plantuml
@startuml
autonumber

[o->ReservationSystem: listAirlines(airportCode)
activate ReservationSystem
ReservationSystem -> Agent: listAirlines(airportCode)
activate Agent
Agent -> Airport : getDepartureAirlines()
activate Airport
deactivate Airport
deactivate Agent
deactivate ReservationSystem

@enduml
```