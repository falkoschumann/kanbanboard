/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.beans.InvalidationListener;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.HBox;

public class KanbanBoardViewSkin extends SkinBase<KanbanBoardView> {
  private HBox content;

  protected KanbanBoardViewSkin(KanbanBoardView control) {
    super(control);
    build();
    bind();
  }

  private void build() {
    content = new HBox();
    content.getStyleClass().add("kanban-board-view");

    // TODO: Für ScrollPane müssen wohl noch min, max und pref definiert werden
    // ScrollPane container = new ScrollPane(content);
    getChildren().setAll(content);
  }

  private void bind() {
    InvalidationListener ticketListener =
        observable -> content.getChildren().setAll(getSkinnable().getColumns());
    getSkinnable().getColumns().addListener(ticketListener);
    ticketListener.invalidated(getSkinnable().getColumns());
  }
}
