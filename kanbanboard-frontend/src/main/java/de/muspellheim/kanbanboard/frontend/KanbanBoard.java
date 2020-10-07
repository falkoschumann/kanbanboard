/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.scene.control.*;

public class KanbanBoard extends Control {
  @Override
  protected Skin<?> createDefaultSkin() {
    return new KanbanBoardSkin(this);
  }
}
