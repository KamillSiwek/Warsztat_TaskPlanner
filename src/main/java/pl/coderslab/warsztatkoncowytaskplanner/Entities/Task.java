package pl.coderslab.warsztatkoncowytaskplanner.Entities;


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
    private LocalDateTime created;
    @Embedded
    private Creation creation = new Creation();
    @Embedded
    private TaskStatus taskStatus = new TaskStatus();
}
