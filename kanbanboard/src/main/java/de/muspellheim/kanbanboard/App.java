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
import de.muspellheim.kanbanboard.frontend.MyKanbanBoard;
import de.muspellheim.kanbanboard.frontend.TodoAppViewController;
import java.nio.file.Paths;
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
    var dialog = new MyKanbanBoard();

    TicketQueryResult ticketQueryResult =
        new TicketQueryResult(
            Map.of(
                "To Do", List.of(new Ticket("Use Kanban"), new Ticket("Try Kanban tool")),
                "Doing/In Progress", List.of(new Ticket("Learn about Kanban")),
                "Done",
                    List.of(new Ticket("Get some sticky notes!"), new Ticket("Get a whiteboard"))));
    dialog.display(ticketQueryResult);

    var scene = new Scene(dialog, 800, 600);
    primaryStage.setScene(scene);
    primaryStage.setTitle("TodoMVC");
    primaryStage.show();

    // stage = primaryStage;
    // build();
    // bind();
    // run();
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
