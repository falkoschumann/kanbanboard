/*
 * Kanban Board - Application
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard;

import de.muspellheim.kanbanboard.frontend.ActivityColumn;
import de.muspellheim.kanbanboard.frontend.KanbanBoardView;
import de.muspellheim.kanbanboard.frontend.TicketCell;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KanbanBoardTest extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    KanbanBoardView kanbanBoardView =
        new KanbanBoardView(
            List.of(
                new ActivityColumn(
                    "To Do",
                    List.of(new TicketCell("Use Kanban"), new TicketCell("Try Kanban tool"))),
                new ActivityColumn("Doing", List.of(new TicketCell("Learn about Kanban"))),
                new ActivityColumn(
                    "Done",
                    List.of(
                        new TicketCell("Get some sticky notes!"),
                        new TicketCell("Get a whiteboard")))));

    Scene scene = new Scene(kanbanBoardView, 800, 600);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Kanban Board View Test");
    primaryStage.show();
  }
}
