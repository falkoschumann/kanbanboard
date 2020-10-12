/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class TicketCard extends Control {
  private final StringProperty ticketId = new SimpleStringProperty(this, "ticketId");
  private final StringProperty title = new SimpleStringProperty(this, "title");
  private final ObjectProperty<LocalDate> dueDate = new SimpleObjectProperty<>(this, "dueDate");
  private final ObjectProperty<LocalDate> startDate = new SimpleObjectProperty<>(this, "startDate");
  private final StringProperty assignee = new SimpleStringProperty(this, "assignee");
  private final BooleanProperty slaExceeded = new SimpleBooleanProperty(this, "slaExceeded");

  public StringProperty ticketIdProperty() {
    return ticketId;
  }

  public String getTicketId() {
    return ticketId.get();
  }

  public void setTicketId(String ticketId) {
    this.ticketId.set(ticketId);
  }

  public StringProperty titleProperty() {
    return title;
  }

  public String getTitle() {
    return title.get();
  }

  public void setTitle(String title) {
    this.title.set(title);
  }

  public ObjectProperty<LocalDate> dueDateProperty() {
    return dueDate;
  }

  public LocalDate getDueDate() {
    return dueDate.get();
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate.set(dueDate);
  }

  public ObjectProperty<LocalDate> startDateProperty() {
    return startDate;
  }

  public LocalDate getStartDate() {
    return startDate.get();
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate.set(startDate);
  }

  public StringProperty assigneeProperty() {
    return assignee;
  }

  public String getAssignee() {
    return assignee.get();
  }

  public void setAssignee(String assignee) {
    this.assignee.set(assignee);
  }

  public BooleanProperty slaExceededProperty() {
    return slaExceeded;
  }

  public boolean isSlaExceeded() {
    return slaExceeded.get();
  }

  public void setSlaExceeded(boolean slaExceeded) {
    this.slaExceeded.set(slaExceeded);
  }

  @Override
  protected Skin<?> createDefaultSkin() {
    return new TicketCardSkin(this);
  }

  @Override
  public String getUserAgentStylesheet() {
    return ActivityColumn.class.getResource("ticket-card.css").toExternalForm();
  }
}
