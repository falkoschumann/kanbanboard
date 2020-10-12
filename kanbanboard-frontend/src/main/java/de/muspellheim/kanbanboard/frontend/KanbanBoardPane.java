/*
 * Kanban Board - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import de.muspellheim.kanbanboard.contract.messages.queries.TicketQueryResult;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.scene.layout.HBox;

public class KanbanBoardPane extends HBox {
  private final Map<String, ActivityColumn> columns = new LinkedHashMap<>();

  public KanbanBoardPane() {
    getStyleClass().add("kanban-board-pane");
  }

  public void registerColumn(String key, ActivityColumn column) {
    columns.put(key, column);
  }

  public void display(TicketQueryResult result) {
    result
        .getTickets()
        .forEach(
            (columnName, tickets) -> {
              var column = columns.get(columnName);
              var cells =
                  tickets.stream()
                      .map(
                          it -> {
                            var t = new TicketCard();
                            t.setTicketId(it.getTicketId());
                            t.setTitle(it.getTitle());
                            t.setDueDate(it.getDueDate());
                            t.setStartDate(it.getStartDate());
                            t.setAssignee(it.getAssignee());
                            t.setSlaExceeded(it.isSlaExceeded());
                            return t;
                          })
                      .collect(Collectors.toList());
              column.getTickets().setAll(cells);
            });
  }

  @Override
  public String getUserAgentStylesheet() {
    return KanbanBoardPane.class.getResource("kanban-board-pane.css").toExternalForm();
  }
}
