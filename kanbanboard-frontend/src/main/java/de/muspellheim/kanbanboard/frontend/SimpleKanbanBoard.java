/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class SimpleKanbanBoard extends KanbanBoardPane {
  public SimpleKanbanBoard() {
    var toDoColumn = new ActivityColumn("To Do", ActivityColumn.UNLIMITED_WIP);
    HBox.setHgrow(toDoColumn, Priority.ALWAYS);
    registerColumn("To Do", toDoColumn);
    getChildren().add(toDoColumn);

    var doingColumn = new ActivityColumn("Doing", 2);
    HBox.setHgrow(doingColumn, Priority.ALWAYS);
    registerColumn("Doing", doingColumn);
    getChildren().add(doingColumn);

    var inProgressColumn = new SubColumn("In Progress");
    HBox.setHgrow(inProgressColumn, Priority.ALWAYS);
    doingColumn.getColumns().add(inProgressColumn);
    registerColumn("Doing/In Progress", inProgressColumn);

    var completeColumn = new SubColumn("Complete");
    HBox.setHgrow(completeColumn, Priority.ALWAYS);
    doingColumn.getColumns().add(completeColumn);
    registerColumn("Doing/Complete", completeColumn);

    var doneColumn = new ActivityColumn("Done", ActivityColumn.UNLIMITED_WIP);
    HBox.setHgrow(doneColumn, Priority.ALWAYS);
    registerColumn("Done", doneColumn);
    getChildren().add(doneColumn);
  }
}
