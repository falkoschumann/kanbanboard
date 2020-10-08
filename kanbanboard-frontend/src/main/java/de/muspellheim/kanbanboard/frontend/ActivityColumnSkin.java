/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.beans.InvalidationListener;
import javafx.beans.WeakInvalidationListener;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class ActivityColumnSkin extends SkinBase<ActivityColumn> {
  private Label wipText;
  private Label title;
  private FlowPane content;

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
    VBox header = new VBox();
    header.getStyleClass().add("header");
    header.getChildren().addAll(wipText, title);

    // Content
    content = new FlowPane(Orientation.HORIZONTAL, 10, 10);
    content.getStyleClass().add("content");

    // Container
    VBox container = new VBox();
    container.getStyleClass().add("activity-column");
    container.getChildren().setAll(header, content);
    getChildren().setAll(container);
  }

  private void bind() {
    InvalidationListener wipListener =
        new WeakInvalidationListener(
            observable ->
                wipText.setText(
                    "("
                        + (getSkinnable().getWip() == -1 ? "\u221E" : getSkinnable().getWip())
                        + ")"));
    getSkinnable().wipProperty().addListener(wipListener);
    wipListener.invalidated(getSkinnable().wipProperty());

    InvalidationListener ticketListener =
        observable -> content.getChildren().setAll(getSkinnable().getTickets());
    getSkinnable().getTickets().addListener(ticketListener);
    ticketListener.invalidated(getSkinnable().getTickets());

    title.textProperty().bind(getSkinnable().titleProperty());
  }
}
