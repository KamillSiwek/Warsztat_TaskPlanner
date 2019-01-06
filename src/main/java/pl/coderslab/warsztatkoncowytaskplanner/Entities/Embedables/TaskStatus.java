package pl.coderslab.warsztatkoncowytaskplanner.Entities.Embedables;

import pl.coderslab.warsztatkoncowytaskplanner.enums.Priority;
import pl.coderslab.warsztatkoncowytaskplanner.enums.Status;

import javax.persistence.*;

@Embeddable
public class TaskStatus {
  @Enumerated(EnumType.STRING)
  @Column
  private Priority priority;

  @Enumerated(EnumType.STRING)
  @Column
  private Status status;

  @PrePersist
  public void prePersist() {
    priority = Priority.NORMAL;
    status = Status.NEW;
  }

  public Priority getPriority() {
    return priority;
  }

  public void setPriority(Priority priority) {
    this.priority = priority;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
