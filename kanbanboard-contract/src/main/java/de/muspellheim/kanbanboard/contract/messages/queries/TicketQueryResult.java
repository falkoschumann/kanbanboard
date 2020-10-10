/*
 * Kanban Board - Contract
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.contract.messages.queries;

import java.util.List;
import java.util.Map;
import lombok.NonNull;
import lombok.Value;

@Value
public class TicketQueryResult {
  @NonNull Map<String, List<Ticket>> tickets;

  @Value
  public static class Ticket {
    @NonNull String text;
  }
}
