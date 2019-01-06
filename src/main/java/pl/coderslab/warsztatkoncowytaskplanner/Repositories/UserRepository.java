package pl.coderslab.warsztatkoncowytaskplanner.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.warsztatkoncowytaskplanner.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);
    User findUserByName(String name);
}
