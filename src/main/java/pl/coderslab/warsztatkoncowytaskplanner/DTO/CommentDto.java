package pl.coderslab.warsztatkoncowytaskplanner.DTO;

import pl.coderslab.warsztatkoncowytaskplanner.Entities.Task;

public class CommentDto {

  private Long id;
  private String content;
  private Task task;

  public CommentDto() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }
}
