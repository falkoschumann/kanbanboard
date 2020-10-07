/*
 * Kanban Board - Backend
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.backend;

import de.muspellheim.kanbanboard.contract.data.Todo;
import java.io.IOException;
import java.util.List;

public interface TodoRepository {
  List<Todo> load() throws IOException;

  void store(List<Todo> todos) throws IOException;
}
