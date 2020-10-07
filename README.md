# Kanban Board

[![Build Status](https://travis-ci.org/falkoschumann/kanbanboard.svg?branch=master)](https://travis-ci.org/falkoschumann/kanbanboard)

Ein Kanban Board zur Visualisierung von Aufgaben mit Spalten für die dafür
notwendigen Aktivitäten. 

Erfolgsrezept nach David J. Anderson

1.  Fokussiere auf Qualität
2.  Reduziere den Work in Progress
3.  Liefere häufig
4.  Sorge für ein Gleichgewicht zwischen Nachfrage und Durchsatz
5.  Priorisiere
6.  Nimm die Quellen von Variabilität ins Visier, um die Vorhersagbarkeit zu
    verbessern

Beispiel:

Aktivitäten mit WIP und Unterscheidung in Arbeit oder fertig (Karte gerade)

1.  Input Queue (wird aus Backlog gefüllt)
2.  Analyse (Start Messung SLA, active)
3.  Entwicklung
4.  Testen
5.  Stage (Ende Messung SLA, inactive)
6.  Produktiv

Zwischen den Aktivitäten können Puffer mit eigenen WIP stehen (Karte um 45°
gedreht)

1.  Input Queue
2.  Analyse
3.  Puffer: Bereit für Entwicklung
4.  Entwicklung
5.  Puffer: Bereit für Build
6.  Testen
7.  Puffer: Bereit für Release
8.  Stage
9.  Produktiv

Aufgabe geht als Karte bzw. Ticket von links nach rechts mit den Informationen 

-   elektronische ID-Nummer (oben links)
-   Titel (Mitte)
-   Startdatum (unten links)
-   optional fester Liefertermin (unten rechts)
-   Zugewiesenes Teammitglied (Avatar oder Kürzel)
-   Ist SLA überschritten (Stern)
-   Optional hat Blocker (als zusätzliche Karte obendrauf)

Aufgabentypen

-   Story
    -   gelb
    -   Beschreibung
    -   Optional aber sinnvoll: Akzeptanzkriterien
    -   Größenordnung < 1 Woche
    -   Markierung als Feature oder Hotfix
-   Epic
    -   grün
    -   Beschreibung
    -   Optional: Akzeptanzkriterien
    -   Größenordnung ≥ 1 Monat
    -   Als zweistufiges Board oder Swimlanes darstellen
-   Blocker
    -   rosa
    -   Referenz auf blockiertes Ticket

Serviceklassen

-   Beschleunigt
    -   weiß
    -   WIP = 1 auf Board, andere WIP dürfen überschritten werden 
    -   Wird vor allen anderen Aufgaben aus Input Queue gezogen
-   Fester Liefertermin
    -   violett
    -   Liefertermin
    -   Aufwandsschätzung notwendig und bei Bedarf zerlegen
    -   Muss rechtzeitig in Input Queue übernommen werden
    -   Hat Vorrang vor Standardklasse und unbestimmte Kosten
-   Standardklasse
    -   gelb
    -   Wird per FIFO oder Priorisierung in Input Queue übernommen
    -   Keine Aufwandsschätzung
    -   Eventuell Größenordnung klassifizieren (S: wenige Tage, M 1-2 Wochen, L:
        mehrere Monate) und bei Bedarf zerlegen
    -   Beispiel für SLA: Durchlaufzeit 30 Tage, bei 80 % Termintreue 
-   Unbestimmbare Kosten
    -   grün
    -   Wird bearbeitet, wenn keine Aufgabe höherer Priorität in Input Queue
    -   Keine Aufwandsschätzung
    -   Eventuell Größenordnung klassifizieren (S: wenige Tage, M 1-2 Wochen, L:
        mehrere Monate) und bei Bedarf zerlegen
    -   Beispiel für SLA: Durchlaufzeit 60 Tage, bei 50 % Termintreue

Visualisierung der Eigenschaften Aufgabentyp, Hierarchieebene und Serviceklasse

## Installation

TODO: Installation

## Usage

TODO: Usage

## Contributing

-   Der Code Style [Google Java Style Guide][1] wird beim Build geprüft.
-   Code formatieren: `./gradlew spotlessApply`
-   [Project Lombok][2] wird verwendet, um Boilerplate Code zu reduzieren, es
    werden nur stabile Features verwendet, zum Beispiel: `@NonNull`, `@Data`,
    `@Value` oder `@Builder`.
-   Hinweis: Die Nutzung von `lombok.var` bricht die Kompatibilität mit Java 10
    und höher.
-   Hinweis: Die Nutzung von JavaFX bricht die Kompatibilität mit Java 9 und
    höher.


[1]: https://google.github.io/styleguide/javaguide.html
[2]: https://projectlombok.org
