package de.muspellheim.kanbanboard.frontend;

import javafx.beans.InvalidationListener;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TicketCardSkin extends SkinBase<TicketCard> {
  private Label ticketId;
  private Label title;
  private Label assignee;
  private Label slaExceeded;
  private Label startDate;
  private Label dueDate;

  public TicketCardSkin(TicketCard control) {
    super(control);
    build();
    bind();
  }

  private void build() {
    // Header
    ticketId = new Label();
    assignee = new Label();
    assignee.setMaxWidth(Double.MAX_VALUE);
    assignee.setAlignment(Pos.BASELINE_RIGHT);
    HBox.setHgrow(assignee, Priority.ALWAYS);
    slaExceeded = new Label();
    var header = new HBox(ticketId, assignee, slaExceeded);

    // Main
    title = new Label();
    title.setMaxHeight(Double.MAX_VALUE);
    title.setAlignment(Pos.CENTER);
    title.setWrapText(true);
    VBox.setVgrow(title, Priority.ALWAYS);

    // Footer
    startDate = new Label();
    startDate.setMaxWidth(Double.MAX_VALUE);
    startDate.setAlignment(Pos.BASELINE_LEFT);
    HBox.setHgrow(startDate, Priority.ALWAYS);
    dueDate = new Label();
    dueDate.setMaxWidth(Double.MAX_VALUE);
    dueDate.setAlignment(Pos.BASELINE_RIGHT);
    HBox.setHgrow(dueDate, Priority.ALWAYS);
    var footer = new HBox(startDate, dueDate);

    // Container
    VBox container = new VBox();
    container.setFillWidth(true);
    container.getStyleClass().add("ticket-card");
    container.getChildren().setAll(header, title, footer);
    getChildren().setAll(container);
  }

  private void bind() {
    ticketId.textProperty().bind(getSkinnable().ticketIdProperty());
    title.textProperty().bind(getSkinnable().titleProperty());
    assignee.textProperty().bind(getSkinnable().assigneeProperty());

    InvalidationListener slaExceededListener =
        observable -> slaExceeded.setText(getSkinnable().isSlaExceeded() ? " \u2731" : "");
    getSkinnable().slaExceededProperty().addListener(slaExceededListener);
    slaExceededListener.invalidated(getSkinnable().slaExceededProperty());

    InvalidationListener startDateListener =
        observable ->
            startDate.setText(
                getSkinnable().getStartDate() == null
                    ? ""
                    : getSkinnable().getStartDate().toString());
    getSkinnable().startDateProperty().addListener(startDateListener);
    startDateListener.invalidated(getSkinnable().startDateProperty());

    InvalidationListener dueDateListener =
        observable ->
            dueDate.setText(
                getSkinnable().getDueDate() == null ? "" : getSkinnable().getDueDate().toString());
    getSkinnable().dueDateProperty().addListener(dueDateListener);
    dueDateListener.invalidated(getSkinnable().dueDateProperty());
  }
}
