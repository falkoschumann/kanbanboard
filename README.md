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

1.  Input Queue
2.  Analyse (Start Messung SLA)
3.  Entwicklung
4.  Test
5.  Stage
6.  Produktiv (Ende Messung SLA)

Zwischen den Aktivitäten können Puffer mit eigenen WIP stehen (Karte um 45°
gedreht)

1.  Input Queue
2.  Analyse
3.  Puffer: Bereit für Entwicklung
4.  Entwicklung
5.  Puffer: Bereit für Build
6.  Test
7.  Puffer: Bereit für Release
8.  Stage
9.  Produktiv

Aufgabe geht als Karte bzw. Ticket von links nach rechts mit den Informationen 

-   elektronische ID-Nummer (oben rechts)
-   Titel (Mitte)
-   Startdatum (unten links)
-   optional fester Lieferdatum (unten rechts)
-   Zugewiesenes Teammitglied (Avatar oder Kürzel)
-   Ist SLA überschritten (Stern)
-   Optional hat Blocker (als zusätzliche Karte oben drauf)



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
