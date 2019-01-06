package pl.coderslab.warsztatkoncowytaskplanner.DTO;

import pl.coderslab.warsztatkoncowytaskplanner.Entities.Category;
import pl.coderslab.warsztatkoncowytaskplanner.Entities.Comment;
import pl.coderslab.warsztatkoncowytaskplanner.Entities.Task;

import java.beans.Transient;
import java.util.List;

public class TaskDto {


  private Long id;
  private String name;
  private String description;
  private Category category;
  private List<Comment> comments;

  public TaskDto() {}

  public TaskDto(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  @Transient
  public Task toTask(TaskDto taskDto) {
    Task entity = new Task();
    entity.setId(id);
    entity.setName(name);
    entity.setDescription(description);
    entity.setCategory(category);
    entity.setComments(comments);
    return entity;
  }
}
