# Softwareentwicklungsprozess

## Ticket

- Oben rechts: elektronische ID-Nummer
- Mitte: Titel
- Unten links: Startdatum
- Liefertermin unten rechts
- Avatar des zugewiesenen Teammitglieds
- Stern, wenn SLA überschritten
- Verknüpfung mit Blocker, falls vorhanden
- Verknüpfung mit Epic, falls vorhanden

Ticket(Id, Thema, Titel, Beschreibung, Akzeptanzkriterien, Status, Release, SP, Startdatum, Fertigstellungdatum, Stunden, Bearbeiter, SLA überschritten, blockt, Epic)

## Aufgabentypen

### Epic

- Nur im Zustand Open erlaubt.
- Muss vor dem Übergang in Zustand Ready in User Stories zerlegt werden.

### Story

- Aufgabe um einen Wert für den Kunden zu erzeugen.
- auch Bugs und Refactoring
- 80% der Kapazität

### Blocker

- rosa
- Hängt an anderer Aufgabe, wenn diese blockiert ist.
- Muss bevorzugt bearbeitet werden.

## Serviceklassen

### Beschleunigt

- weiß
- WIP=1
- Wird bearbeitet, sobald ein Mitarbeiter frei ist.
- Ggf. Zwischenrelease

### Fester Liefertermin

- violett
- Liefertermin unten rechts
- Aufwandsschätzung notwendig
- Muss rechtzeitig in Input Queue übernommen.
- Hat Vorang vor Standardklasse und unbestimmte Kosten.

### Standardklasse

- gelb
- Per FIFO oder Priorisierung in Input Queue übernehmen.
- Keine Aufwandsschätzung
- Ggf. Größenordnung klassifizieren (S: wenige Tage, M: 1-2 Wochen; L: mehrere Monate).
- Beipiel-SLA: Durchlaufzeitzeit 30 Tage, bei 80% Termintreue

### Unbestimmte Kosten

- grün
- Wird bearbeitet, wenn keine Aufgabe höherer Priorität in Input Queue.
- Keine Aufwandsschätzung
- Ggf. Größenordnung klassifizieren (S: wenige Tage, M: 1-2 Wochen; L: mehrere Monate).

## Aufgabengröße

- XS -> weniger als 0,5 PT
- S -> 0,5 bis 1 PT
- M -> 2 bis 3 PT
- L -> 5 bis 8 PT
- XL -> mehr als 8 MT
