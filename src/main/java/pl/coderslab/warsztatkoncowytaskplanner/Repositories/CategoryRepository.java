package pl.coderslab.warsztatkoncowytaskplanner.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.warsztatkoncowytaskplanner.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryById(Long id);
    Category findCategoryByName(String name);
}
