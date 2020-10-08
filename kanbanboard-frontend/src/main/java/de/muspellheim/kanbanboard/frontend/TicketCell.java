/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class TicketCell extends Label {
  public TicketCell(String text) {
    super(text);
    setPadding(new Insets(7));
    getStyleClass().add("ticket");
  }

  @Override
  public String getUserAgentStylesheet() {
    return ActivityColumn.class.getResource("ticket-cell.css").toExternalForm();
  }
}
