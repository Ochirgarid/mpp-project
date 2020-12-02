```plantuml
@startuml
title 3. View list of airports

Actor Agent
autonumber
Agent -> Admin : getAirports()
activate Admin
Admin -> Admin : readAirportList()
activate Admin
deactivate Admin
deactivate Admin

@enduml
```