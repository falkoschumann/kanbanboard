module de.muspellheim.kanbanboard.contract {
  requires static lombok;

  exports de.muspellheim.kanbanboard.contract.data;
  exports de.muspellheim.kanbanboard.contract.messages.commands;
  exports de.muspellheim.kanbanboard.contract.messages.queries;

  opens de.muspellheim.kanbanboard.contract.data;
}
