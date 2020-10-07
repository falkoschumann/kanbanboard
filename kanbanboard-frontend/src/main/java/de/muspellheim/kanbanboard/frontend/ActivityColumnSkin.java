/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import javafx.beans.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ActivityColumnSkin extends SkinBase<ActivityColumn> {
  private Label wipText;
  private Label headerText;

  protected ActivityColumnSkin(ActivityColumn control) {
    super(control);
    build();
    bind();
  }

  private void build() {
    // Header
    wipText = new Label();
    wipText.getStyleClass().add("wip");
    headerText = new Label();
    headerText.getStyleClass().add("headerText");
    VBox header = new VBox();
    header.getStyleClass().add("header");
    header.setAlignment(Pos.CENTER);
    header.getChildren().addAll(wipText, headerText);

    // Content
    FlowPane content = new FlowPane(Orientation.HORIZONTAL, 10, 10);
    content.setPadding(new Insets(10));
    content
        .getChildren()
        .setAll(
            new Label("Lorem ipsum"),
            new Label("Lorem ipsum"),
            new Label("Lorem ipsum"),
            new Label("Lorem ipsum"),
            new Label("Lorem ipsum"),
            new Label("Lorem ipsum"),
            new Label("Lorem ipsum"),
            new Label("Lorem ipsum"),
            new Label("Lorem ipsum"),
            new Label("Lorem ipsum"));

    // Container
    VBox container = new VBox();
    container.getStyleClass().add("activity-column");
    container.getChildren().setAll(header, content);
    getChildren().setAll(container);
  }

  private void bind() {
    InvalidationListener wipListener =
        new WeakInvalidationListener(
            observable -> wipText.setText("(" + getSkinnable().getWip() + ")"));
    getSkinnable().wipProperty().addListener(wipListener);
    wipListener.invalidated(getSkinnable().wipProperty());

    headerText.textProperty().bind(getSkinnable().textProperty());
  }
}
