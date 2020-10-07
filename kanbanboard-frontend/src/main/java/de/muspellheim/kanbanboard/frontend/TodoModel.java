/*
 * TodoMVC - Frontend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.frontend;

import de.muspellheim.kanbanboard.contract.data.Todo;
import de.muspellheim.kanbanboard.contract.messages.commands.DestroyCommand;
import de.muspellheim.kanbanboard.contract.messages.commands.EditCommand;
import de.muspellheim.kanbanboard.contract.messages.commands.ToggleCommand;
import java.util.function.Consumer;
import lombok.NonNull;
import lombok.Value;

@Value
public class TodoModel {
  @NonNull Todo todo;
  @NonNull Consumer<ToggleCommand> onToggleCommand;
  @NonNull Consumer<EditCommand> onEditCommand;
  @NonNull Consumer<DestroyCommand> onDestroyCommand;
}
