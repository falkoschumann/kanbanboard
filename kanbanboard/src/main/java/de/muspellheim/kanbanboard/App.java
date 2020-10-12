/*
 * Kanban Board - Application
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard;

import de.muspellheim.kanbanboard.backend.MessageHandler;
import de.muspellheim.kanbanboard.backend.adapters.TodoJsonRepository;
import de.muspellheim.kanbanboard.contract.messages.queries.TicketQueryResult;
import de.muspellheim.kanbanboard.contract.messages.queries.TicketQueryResult.Ticket;
import de.muspellheim.kanbanboard.contract.messages.queries.TodoListQuery;
import de.muspellheim.kanbanboard.frontend.ExampleKanbanBoard;
import de.muspellheim.kanbanboard.frontend.SimpleKanbanBoard;
import de.muspellheim.kanbanboard.frontend.TodoAppViewController;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
  private Stage stage;
  private MessageHandler messageHandler;
  private TodoAppViewController controller;

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    // simpleKanbanBoard(primaryStage);
    exampleKanbanBoard(primaryStage);

    // stage = primaryStage;
    // build();
    // bind();
    // run();
  }

  private void simpleKanbanBoard(Stage stage) {
    var dialog = new SimpleKanbanBoard();

    TicketQueryResult ticketQueryResult =
        new TicketQueryResult(
            Map.of(
                "To Do",
                List.of(Ticket.of("#4", "Use Kanban"), Ticket.of("#5", "Try Kanban tool")),
                "Doing/In Progress",
                List.of(
                    Ticket.of("#3", "Learn about Kanban"),
                    Ticket.builder()
                        .ticketId("#0")
                        .title(
                            "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod")
                        .assignee("FS")
                        .dueDate(LocalDate.now().plusDays(3))
                        .startDate(LocalDate.now())
                        .slaExceeded(true)
                        .build()),
                "Done",
                List.of(
                    Ticket.of("#1", "Get some sticky notes!"),
                    Ticket.of("#2", "Get a whiteboard"))));
    dialog.display(ticketQueryResult);

    var scene = new Scene(dialog, 800, 600);
    stage.setScene(scene);
    stage.setTitle("Simple Kanban Board");
    stage.show();
  }

  private void exampleKanbanBoard(Stage stage) {
    var dialog = new ExampleKanbanBoard();

    TicketQueryResult ticketQueryResult =
        new TicketQueryResult(
            Map.of(
                "Verworfen",
                List.of(
                    Ticket.builder()
                        .ticketId("#0")
                        .title(
                            "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod")
                        .assignee("FS")
                        .dueDate(LocalDate.now().plusDays(3))
                        .startDate(LocalDate.now())
                        .slaExceeded(true)
                        .build()),
                "Gewählt",
                List.of(Ticket.of("#4", "Use Kanban"), Ticket.of("#5", "Try Kanban tool")),
                "Entwicklung/In Bearbeitung",
                List.of(Ticket.of("#3", "Learn about Kanban")),
                "Fertig",
                List.of(
                    Ticket.of("#1", "Get some sticky notes!"),
                    Ticket.of("#2", "Get a whiteboard"))));
    dialog.display(ticketQueryResult);

    var scene = new Scene(dialog, 800, 600);
    stage.setScene(scene);
    stage.setTitle("Example Kanban Board");
    stage.setMaximized(true);
    stage.show();
  }

  private void build() {
    var file = Paths.get("todos.json");
    var repository = new TodoJsonRepository(file);
    messageHandler = new MessageHandler(repository);

    var root = TodoAppViewController.load();
    var view = root.getKey();
    controller = root.getValue();
    Scene scene = new Scene(view);
    stage.setScene(scene);
    stage.setTitle("TodoMVC");
  }

  private void bind() {
    controller.setOnNewTodoCommand(
        it -> {
          messageHandler.handle(it);
          runQuery();
        });
    controller.setOnToggleAllCommand(
        it -> {
          messageHandler.handle(it);
          runQuery();
        });
    controller.setOnToggleCommand(
        it -> {
          messageHandler.handle(it);
          runQuery();
        });
    controller.setOnDestroyCommand(
        it -> {
          messageHandler.handle(it);
          runQuery();
        });
    controller.setOnEditCommand(
        it -> {
          messageHandler.handle(it);
          runQuery();
        });
    controller.setOnClearCompletedCommand(
        it -> {
          messageHandler.handle(it);
          runQuery();
        });
    controller.setOnTodoListQuery(it -> runQuery());
  }

  private void run() {
    stage.show();
    runQuery();
  }

  private void runQuery() {
    var result = messageHandler.handle(new TodoListQuery());
    controller.display(result);
  }
}
