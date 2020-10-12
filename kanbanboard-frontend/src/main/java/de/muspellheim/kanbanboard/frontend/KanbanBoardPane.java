/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.scene.layout.HBox;

public class KanbanBoardPane extends HBox {
  public KanbanBoardPane() {
    getStyleClass().add("kanban-board-pane");
  }

  @Override
  public String getUserAgentStylesheet() {
    return KanbanBoardPane.class.getResource("kanban-board-pane.css").toExternalForm();
  }
}
