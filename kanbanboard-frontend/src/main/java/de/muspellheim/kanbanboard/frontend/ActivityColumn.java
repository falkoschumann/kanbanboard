/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.beans.property.*;
import javafx.collections.*;
import javafx.scene.control.*;

public class ActivityColumn extends Control {

  /***************************************************************************
   *                                                                         *
   * Static properties and methods                                           *
   *                                                                         *
   **************************************************************************/

  public static final int UNLIMITED_WIP = -1;

  /***************************************************************************
   *                                                                         *
   * Instance Variables                                                      *
   *                                                                         *
   **************************************************************************/

  private final ObservableList<ActivityColumn> columns = FXCollections.observableArrayList();

  private final ObservableList<Ticket> tickets = FXCollections.observableArrayList();

  /***************************************************************************
   *                                                                         *
   * Properties                                                              *
   *                                                                         *
   **************************************************************************/

  // --- Text
  private StringProperty text = new SimpleStringProperty(this, "text", "");

  public final StringProperty textProperty() {
    return text;
  }

  public final void setText(String value) {
    text.set(value);
  }

  public final String getText() {
    return text.get();
  }

  // --- WIP
  private IntegerProperty wip = new SimpleIntegerProperty(this, "wip", UNLIMITED_WIP);

  public final IntegerProperty wipProperty() {
    return wip;
  }

  public final void setWip(int value) {
    wip.set(value);
  }

  public final int getWip() {
    return wip.get();
  }

  /***************************************************************************
   *                                                                         *
   * Public API                                                              *
   *                                                                         *
   **************************************************************************/

  public final ObservableList<ActivityColumn> getColumns() {
    return columns;
  }

  public final ObservableList<Ticket> getTickets() {
    return tickets;
  }

  /***************************************************************************
   *                                                                         *
   * Methods                                                                 *
   *                                                                         *
   **************************************************************************/

  @Override
  protected Skin<?> createDefaultSkin() {
    return new ActivityColumnSkin(this);
  }

  @Override
  public String getUserAgentStylesheet() {
    return ActivityColumn.class.getResource("activity-column.css").toExternalForm();
  }
}
