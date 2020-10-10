/*
 * Kanban Board - Contract
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.kanbanboard.contract.messages.queries;

import java.util.List;
import lombok.NonNull;
import lombok.Value;

@Value
public class WorkflowQueryResult {
  @NonNull List<Activity> activities;

  @Value
  public static class Activity {
    public static final int UNLIMITED_WIP = -1;
    public static final int HIDE_WIP = 0;

    @NonNull String name;
    int wip;
    @NonNull List<Activity> subActivities;

    public static Activity of(String name) {
      return new Activity(name, HIDE_WIP, List.of());
    }

    public static Activity of(String name, int wip) {
      return new Activity(name, wip, List.of());
    }

    public static Activity of(String name, int wip, List<Activity> subActivities) {
      return new Activity(name, wip, subActivities);
    }
  }
}
