/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.scene.control.Skin;

public class SubColumn extends ActivityColumn {
  public SubColumn() {}

  public SubColumn(String title) {
    setTitle(title);
  }

  public SubColumn(String title, int wip) {
    setTitle(title);
    setWip(wip);
  }

  @Override
  protected Skin<?> createDefaultSkin() {
    return new SubColumnSkin(this);
  }
}
