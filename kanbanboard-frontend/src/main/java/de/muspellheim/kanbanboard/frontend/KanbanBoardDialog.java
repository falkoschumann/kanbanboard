/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import de.muspellheim.kanbanboard.contract.messages.queries.TicketQueryResult;
import de.muspellheim.kanbanboard.contract.messages.queries.WorkflowQueryResult;
import de.muspellheim.kanbanboard.contract.messages.queries.WorkflowQueryResult.Activity;
import java.util.stream.Collectors;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class KanbanBoardDialog extends VBox {
  private final KanbanBoardView kanbanBoardView;

  public KanbanBoardDialog() {
    kanbanBoardView = new KanbanBoardView();
    VBox.setVgrow(kanbanBoardView, Priority.ALWAYS);
    getChildren().setAll(kanbanBoardView);
  }

  public void display(WorkflowQueryResult result) {
    var columns =
        result.getActivities().stream().map(it -> createColumn(it)).collect(Collectors.toList());
    kanbanBoardView.getColumns().setAll(columns);
  }

  private static ActivityColumn createColumn(Activity activity) {
    var column = new ActivityColumn(activity.getName(), activity.getWip());
    column
        .getColumns()
        .setAll(
            activity.getSubActivities().stream()
                .map(it -> createColumn(it))
                .collect(Collectors.toList()));
    return column;
  }

  public void display(TicketQueryResult result) {
    result
        .getTickets()
        .forEach(
            (columnName, tickets) -> {
              var column = kanbanBoardView.getColumn(columnName);
              var cells =
                  tickets.stream()
                      .map(it -> new TicketCell(it.getText()))
                      .collect(Collectors.toList());
              column.getTickets().setAll(cells);
            });
  }
}
