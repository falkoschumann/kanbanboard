/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

public class SubColumnSkin extends ActivityColumnSkin {

  public SubColumnSkin(SubColumn control) {
    super(control);
    container.getStyleClass().add("sub-column");
  }
}
