/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class ActivityColumn extends Control {

  // TODO: Sub Columns mit gestrichelter Linie trennen
  // TODO: Sub Columns ohne Border und Padding
  // TODO: Sub Columns ohne WIP: WIP aus Layout entfernen

  /***************************************************************************
   *                                                                         *
   * Static properties and methods                                           *
   *                                                                         *
   **************************************************************************/

  public static final int UNLIMITED_WIP = -1;

  /***************************************************************************
   *                                                                         *
   * Constructors                                                            *
   *                                                                         *
   **************************************************************************/

  public ActivityColumn() {}

  public ActivityColumn(String title, int wip) {
    setTitle(title);
    setWip(wip);
  }

  public ActivityColumn(String title, int wip, List<ActivityColumn> columns) {
    setTitle(title);
    setWip(wip);
    getColumns().setAll(columns);
  }

  public ActivityColumn(String title, int wip, List<ActivityColumn> columns, List<TicketCell> tickets) {
    setTitle(title);
    setWip(wip);
    getColumns().setAll(columns);
    getTickets().setAll(tickets);
  }

  /***************************************************************************
   *                                                                         *
   * Instance Variables                                                      *
   *                                                                         *
   **************************************************************************/

  private final ObservableList<ActivityColumn> columns = FXCollections.observableArrayList();

  private final ObservableList<TicketCell> tickets = FXCollections.observableArrayList();

  /***************************************************************************
   *                                                                         *
   * Properties                                                              *
   *                                                                         *
   **************************************************************************/

  // --- Title
  private StringProperty title = new SimpleStringProperty(this, "text", "");

  public final StringProperty titleProperty() {
    return title;
  }

  public final void setTitle(String value) {
    title.set(value);
  }

  public final String getTitle() {
    return title.get();
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

  public final ObservableList<TicketCell> getTickets() {
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
