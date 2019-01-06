package pl.coderslab.warsztatkoncowytaskplanner.Entities;

import pl.coderslab.warsztatkoncowytaskplanner.DTO.TaskDto;
import pl.coderslab.warsztatkoncowytaskplanner.Entities.Embedables.Creation;
import pl.coderslab.warsztatkoncowytaskplanner.Entities.Embedables.TaskStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String description;
  @OneToMany
  private Category category;
  @Embedded private Creation creation = new Creation();
  @Embedded private TaskStatus taskStatus = new TaskStatus();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Creation getCreation() {
    return creation;
  }

  public void setCreation(Creation creation) {
    this.creation = creation;
  }

  public TaskStatus getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(TaskStatus taskStatus) {
    this.taskStatus = taskStatus;
  }

  @Transient
  public TaskDto toDto() {
    TaskDto dto = new TaskDto();
    dto.setId(this.getId());
    return dto;
  }
}
