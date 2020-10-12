/*
 * Kanban Board - Contract
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.contract.messages.queries;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.With;

@Value
public class TicketQueryResult {
  @NonNull Map<String, List<Ticket>> tickets;

  @Value
  @Builder
  public static class Ticket {
    @NonNull String ticketId;
    @NonNull String title;
    LocalDate dueDate;
    @With LocalDate startDate;
    @With String assignee;
    @With boolean slaExceeded;

    public static Ticket of(String ticketId, String title) {
      return new Ticket(ticketId, title, null, null, null, false);
    }

    public static Ticket of(String ticketId, String title, LocalDate dueDate) {
      return new Ticket(ticketId, title, dueDate, null, null, false);
    }
  }
}
