# Messages

## Incoming/outgoing

### Request (incoming) -> Response (outgoing)

#### Command -> Command Status

- Lege Workflow an ([Spaltenname, WIP-Limit])
- Eröffne Ticket (Id, Titel)
- Bewege Ticket (Id, von Spalte, nach Spalte)
  - Setze Startdatum, wenn von Open verschoben.
  - Setze Fertigstellungsdatum, wenn nach Closed verschoben
- Schließe Ticket (Id)

#### Query -> Query Result

- Board
  - Spalten (Name, WIP-Limit)
    - Tickets (Id, Titel, Startdatum?, Fertigstellungsdatum?)

### Notification

#### Incoming: Notification -> Commands

#### Outgoing

## Event (internal)

- Workflow angelegt ([Spaltenname, WIP-Limit])
- Ticket eröffnet (Id, Titel)
- Ticket verschoben (Id, von Spalte, nach Spalte)
- Ticket geschlossen
