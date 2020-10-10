/*
 * Kanban Board - Application
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard;

import de.muspellheim.kanbanboard.frontend.ActivityColumn;
import de.muspellheim.kanbanboard.frontend.KanbanBoardView;
import de.muspellheim.kanbanboard.frontend.TicketCell;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KanbanBoardTest extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    var toDoColumn = new ActivityColumn("To Do", ActivityColumn.UNLIMITED_WIP);
    toDoColumn.getTickets().setAll(new TicketCell("Use Kanban"), new TicketCell("Try Kanban tool"));

    var doingColumn = new ActivityColumn("Doing", 2);
    var doingInProgressColumn = new ActivityColumn("In Progress");
    doingInProgressColumn.getTickets().setAll(new TicketCell("Learn about Kanban"));
    var doingCompleteColumn = new ActivityColumn("Complete");
    doingColumn.getColumns().addAll(doingInProgressColumn, doingCompleteColumn);

    var doneColumn = new ActivityColumn("Done", ActivityColumn.UNLIMITED_WIP);
    doneColumn
        .getTickets()
        .setAll(new TicketCell("Get some sticky notes!"), new TicketCell("Get a whiteboard"));

    var kanbanBoardView = new KanbanBoardView();
    kanbanBoardView.getColumns().setAll(toDoColumn, doingColumn, doneColumn);

    Scene scene = new Scene(kanbanBoardView, 800, 600);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Kanban Board View Test");
    primaryStage.show();
  }
}
