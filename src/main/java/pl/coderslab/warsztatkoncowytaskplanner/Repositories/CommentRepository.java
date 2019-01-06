package pl.coderslab.warsztatkoncowytaskplanner.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.warsztatkoncowytaskplanner.Entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findCommentById(Long id);
}
