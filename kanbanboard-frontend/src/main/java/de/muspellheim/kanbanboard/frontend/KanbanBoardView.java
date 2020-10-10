/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class KanbanBoardView extends Control {
  /***************************************************************************
   *                                                                         *
   * Instance Variables                                                      *
   *                                                                         *
   **************************************************************************/

  private final ObservableList<ActivityColumn> columns = FXCollections.observableArrayList();

  /***************************************************************************
   *                                                                         *
   * Public API                                                              *
   *                                                                         *
   **************************************************************************/

  public final ObservableList<ActivityColumn> getColumns() {
    return columns;
  }

  /***************************************************************************
   *                                                                         *
   * Methods                                                                 *
   *                                                                         *
   **************************************************************************/

  @Override
  protected Skin<?> createDefaultSkin() {
    return new KanbanBoardViewSkin(this);
  }

  @Override
  public String getUserAgentStylesheet() {
    return KanbanBoardView.class.getResource("kanban-board-view.css").toExternalForm();
  }
}
