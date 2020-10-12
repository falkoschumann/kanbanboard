module de.muspellheim.kanbanboard.backend {
  requires transitive de.muspellheim.kanbanboard.contract;
  requires com.google.gson;
  requires static lombok;

  exports de.muspellheim.kanbanboard.backend;
  exports de.muspellheim.kanbanboard.backend.adapters;
}
