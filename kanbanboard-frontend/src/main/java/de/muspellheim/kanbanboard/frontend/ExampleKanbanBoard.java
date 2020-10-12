/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ExampleKanbanBoard extends KanbanBoardPane {
  public ExampleKanbanBoard() {
    var ideenColumn = new ActivityColumn("Ideen", ActivityColumn.UNLIMITED_WIP);
    registerColumn("Ideen", ideenColumn);

    var vorschlaegeColumn = new ActivityColumn("Vorschläge", 4);
    registerColumn("Vorschläge", vorschlaegeColumn);

    var vorschlaegeInBearbeitung = new SubColumn(("In Bearbeitung"));
    registerColumn("Vorschläge/In Bearbeitung", vorschlaegeColumn);
    vorschlaegeColumn.getColumns().add(vorschlaegeInBearbeitung);

    var vorschlaegeFertig = new SubColumn(("Fertig"));
    registerColumn("Vorschläge/Fertig", vorschlaegeColumn);
    vorschlaegeColumn.getColumns().add(vorschlaegeFertig);

    var verworfenColumn = new ActivityColumn("Verworfen", 4);
    verworfenColumn.setPrefHeight(280);
    registerColumn("Verworfen", verworfenColumn);

    var inner = new HBox();
    VBox.setVgrow(inner, Priority.ALWAYS);
    inner.getChildren().setAll(ideenColumn, vorschlaegeColumn);

    var outer = new VBox();
    outer.getChildren().setAll(inner, verworfenColumn);
    getChildren().add(outer);

    var gewaehltColumn = new ActivityColumn("Gewählt", 4);
    getChildren().add(gewaehltColumn);
    registerColumn("Gewählt", gewaehltColumn);

    var entwicklungColumn = new ActivityColumn("Entwicklung", 6);
    getChildren().add(entwicklungColumn);
    registerColumn("Entwicklung", entwicklungColumn);

    var entwicklungInBearbeitung = new SubColumn(("In Bearbeitung"));
    registerColumn("Entwicklung/In Bearbeitung", entwicklungInBearbeitung);
    entwicklungColumn.getColumns().add(entwicklungInBearbeitung);

    var entwicklungFertig = new SubColumn(("Fertig"));
    registerColumn("Entwicklung/Fertig", entwicklungFertig);
    entwicklungColumn.getColumns().add(entwicklungFertig);

    var abnahmeColumn = new ActivityColumn("Abnahme", 4);
    registerColumn("Abnahme", abnahmeColumn);
    getChildren().add(abnahmeColumn);

    var fertigColumn = new ActivityColumn("Fertig", ActivityColumn.UNLIMITED_WIP);
    registerColumn("Fertig", fertigColumn);
    getChildren().add(fertigColumn);
  }
}
