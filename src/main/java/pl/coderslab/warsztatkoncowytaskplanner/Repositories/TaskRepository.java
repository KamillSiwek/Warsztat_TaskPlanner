package pl.coderslab.warsztatkoncowytaskplanner.Repositories;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findTaskById(Long id);
}
