/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import de.muspellheim.kanbanboard.contract.messages.queries.TicketQueryResult;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MyKanbanBoard extends KanbanBoardPane {
  private final Map<String, ActivityColumn> columns = new LinkedHashMap<>();

  public MyKanbanBoard() {
    var toDoColumn = new ActivityColumn("To Do", ActivityColumn.UNLIMITED_WIP);
    columns.put("To Do", toDoColumn);
    getChildren().add(toDoColumn);

    var doingColumn = new ActivityColumn("Doing", 2);
    columns.put("Doing", doingColumn);
    getChildren().add(doingColumn);

    var inProgressColumn = new SubColumn("In Progress");
    doingColumn.getColumns().add(inProgressColumn);
    columns.put("Doing/In Progress", inProgressColumn);

    var completeColumn = new SubColumn("Complete");
    doingColumn.getColumns().add(completeColumn);
    columns.put("Doing/Complete", completeColumn);

    var doneColumn = new ActivityColumn("Done", ActivityColumn.UNLIMITED_WIP);
    columns.put("Done", doneColumn);
    getChildren().add(doneColumn);
  }

  public void display(TicketQueryResult result) {
    result
        .getTickets()
        .forEach(
            (columnName, tickets) -> {
              var column = columns.get(columnName);
              var cells =
                  tickets.stream()
                      .map(it -> new TicketCell(it.getText()))
                      .collect(Collectors.toList());
              column.getTickets().setAll(cells);
            });
  }
}
