module de.muspellheim.kanbanboard.frontend {
  requires transitive de.muspellheim.kanbanboard.contract;
  requires transitive javafx.controls;
  requires javafx.fxml;
  requires static lombok;

  exports de.muspellheim.kanbanboard.frontend;

  opens de.muspellheim.kanbanboard.frontend;
}
