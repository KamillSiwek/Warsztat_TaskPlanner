package pl.coderslab.warsztatkoncowytaskplanner.Entities;

import pl.coderslab.warsztatkoncowytaskplanner.DTO.CommentDto;

import javax.persistence.*;

@Entity
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String content;

  @ManyToOne
  @JoinColumn(name = "task_id")
  private Task task;

    public Comment() {
    }

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

    @Transient
    public CommentDto toDto() {
        CommentDto dto = new CommentDto();
        dto.setId(this.getId());
        return dto;
    }
}
