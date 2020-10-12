/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class ActivityColumn extends Control {
  public static final int UNLIMITED_WIP = -1;
  public static final int HIDE_WIP = 0;

  private final ObservableList<ActivityColumn> columns = FXCollections.observableArrayList();
  private final ObservableList<TicketCell> tickets = FXCollections.observableArrayList();
  private StringProperty title = new SimpleStringProperty(this, "text", "");
  private IntegerProperty wip = new SimpleIntegerProperty(this, "wip", HIDE_WIP);

  public ActivityColumn() {}

  public ActivityColumn(String title) {
    setTitle(title);
  }

  public ActivityColumn(String title, int wip) {
    setTitle(title);
    setWip(wip);
  }

  public final StringProperty titleProperty() {
    return title;
  }

  public final void setTitle(String value) {
    title.set(value);
  }

  public final String getTitle() {
    return title.get();
  }

  public final IntegerProperty wipProperty() {
    return wip;
  }

  public final void setWip(int value) {
    wip.set(value);
  }

  public final int getWip() {
    return wip.get();
  }

  public final ObservableList<ActivityColumn> getColumns() {
    return columns;
  }

  public final ObservableList<TicketCell> getTickets() {
    return tickets;
  }

  @Override
  protected Skin<?> createDefaultSkin() {
    return new ActivityColumnSkin(this);
  }

  @Override
  public String getUserAgentStylesheet() {
    return ActivityColumn.class.getResource("activity-column.css").toExternalForm();
  }
}
