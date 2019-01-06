package pl.coderslab.warsztatkoncowytaskplanner.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.warsztatkoncowytaskplanner.Entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findTaskById(Long id);
}
