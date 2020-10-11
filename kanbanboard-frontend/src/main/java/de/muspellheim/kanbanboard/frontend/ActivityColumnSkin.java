/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.beans.InvalidationListener;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ActivityColumnSkin extends SkinBase<ActivityColumn> {
  protected VBox container;
  private Label wipText;
  private Label title;
  private HBox columnsContainer;
  private FlowPane ticketsContainer;

  protected ActivityColumnSkin(ActivityColumn control) {
    super(control);
    build();
    bind();
  }

  private void build() {
    // Header
    wipText = new Label();
    wipText.getStyleClass().add("wip");
    title = new Label();
    title.getStyleClass().add("title");
    var header = new VBox();
    header.getStyleClass().add("header");
    header.getChildren().addAll(wipText, title);

    // Content
    ticketsContainer = new FlowPane(Orientation.HORIZONTAL, 10, 10);
    ticketsContainer.getStyleClass().add("tickets");
    VBox.setVgrow(ticketsContainer, Priority.ALWAYS);
    columnsContainer = new HBox();
    columnsContainer.getStyleClass().add("columns");
    VBox.setVgrow(columnsContainer, Priority.ALWAYS);
    var content = new VBox();
    content.getStyleClass().add("content");
    VBox.setVgrow(content, Priority.ALWAYS);
    content.getChildren().setAll(ticketsContainer, columnsContainer);

    // Container
    container = new VBox();
    container.getStyleClass().add("activity-column");
    container.getChildren().setAll(header, content);
    getChildren().setAll(container);
  }

  private void bind() {
    InvalidationListener wipListener =
        observable -> {
          wipText.setText(
              switch (getSkinnable().getWip()) {
                case ActivityColumn.UNLIMITED_WIP -> "(\u221E)";
                case ActivityColumn.HIDE_WIP -> "";
                default -> "(" + getSkinnable().getWip() + ")";
              });
          var showWip = getSkinnable().getWip() != ActivityColumn.HIDE_WIP;
          wipText.setVisible(showWip);
          wipText.setManaged(showWip);
        };
    getSkinnable().wipProperty().addListener(wipListener);
    wipListener.invalidated(getSkinnable().wipProperty());

    InvalidationListener columnsListener = observable -> updateContent();
    getSkinnable().getColumns().addListener(columnsListener);
    columnsListener.invalidated(getSkinnable().getColumns());

    InvalidationListener ticketListener = observable -> updateContent();
    getSkinnable().getTickets().addListener(ticketListener);
    ticketListener.invalidated(getSkinnable().getTickets());

    title.textProperty().bind(getSkinnable().titleProperty());
  }

  private void updateContent() {
    columnsContainer.getChildren().setAll(getSkinnable().getColumns());
    var showColumns = !columnsContainer.getChildren().isEmpty();
    columnsContainer.setVisible(showColumns);
    columnsContainer.setManaged(showColumns);
    columnsContainer.getChildren().forEach(it -> HBox.setHgrow(it, Priority.ALWAYS));

    ticketsContainer.getChildren().setAll(getSkinnable().getTickets());
    var showTickets = !ticketsContainer.getChildren().isEmpty();
    ticketsContainer.setVisible(showTickets || !showColumns);
    ticketsContainer.setManaged(showTickets || !showColumns);
  }
}
