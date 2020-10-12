/*
 * Kanban Board - Contract
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.contract.messages.commands;

import lombok.NonNull;
import lombok.Value;

@Value
public class DestroyCommand {
  @NonNull String id;
}
