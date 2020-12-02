```plantuml
@startuml

title Class diagram

class Airline {
    - int id
    - String code
    - String name
    - String history
}

class Airport {
    - int id
    - String code
    - String name
}

class Address {
    - int id
    - String street
    - String city
    - String state
    - String zipCode
}

class FlightNumber {
    - int id
    - String number
    - int capacity
    - LocalTime departureTime
    - LocalTime arrivalTime
}

class Flight {
    - LocalDate departureDate
    - LocalDate arrivalDate
}

class Person {
    - int id
    - String firsName
    - String lastName
    - Date birthday
    - String email
}

class Passenger {
}

class Staff {
}

class Pilot {
}

class Reservation {
    - int id
    - int agentId
}


class Ticket {
    - int id
    - String number
    - String reservationCode
}

class Agent {
    - int id
}


FlightNumber "0..*" --* "1" Airline : belongs
Airport "1" <-- "0..*" FlightNumber : arrives
Airport "1" <-- "0..*" FlightNumber : departs

Airport "1" --> "0..*" Airline : approves

Address "1" <-- "1" Airport : exists
Address "1" <-- "1" Person : reside

Flight "1" --> "0..*" Passenger
Ticket --* Flight : flight ticket
Flight "1..*" <-- "1..*" Reservation
Reservation "0..*" <-- "1" Passenger

FlightNumber "1" <-- "0..*" Flight
Person <|-- Passenger
Person <|-- Pilot
Person <|-- Staff
Person <|-- Agent

Passenger "0..*" <-- "0..*" Agent : make\nreservation\nfor

Flight "1" --> "2..*" Pilot
Flight "1" --> "0..*" Staff

@enduml
```