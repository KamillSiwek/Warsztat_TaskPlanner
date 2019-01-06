package pl.coderslab.warsztatkoncowytaskplanner.Entities;

import pl.coderslab.warsztatkoncowytaskplanner.DTO.CategoryDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Task> tasks = new ArrayList<>();

    public Category() {
    }


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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Transient
    public CategoryDto toDto() {
        CategoryDto dto = new CategoryDto();
        dto.setId(this.getId());
        return dto;
    }
}
