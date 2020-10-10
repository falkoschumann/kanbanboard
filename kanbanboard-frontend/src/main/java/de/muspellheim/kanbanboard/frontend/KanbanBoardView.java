/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import java.util.List;
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

  public ActivityColumn getColumn(String columnName) {
    var columnPath = List.of(columnName.split("/"));
    var column = columns.filtered(it -> it.getTitle().equals(columnPath.get(0))).get(0);
    return getColumn(column, columnPath.subList(1, columnPath.size()));
  }

  private ActivityColumn getColumn(ActivityColumn column, List<String> columnPath) {
    if (columnPath.isEmpty()) {
      return column;
    }

    column = column.getColumns().filtered(it -> it.getTitle().equals(columnPath.get(0))).get(0);
    return getColumn(column, columnPath.subList(1, columnPath.size()));
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
