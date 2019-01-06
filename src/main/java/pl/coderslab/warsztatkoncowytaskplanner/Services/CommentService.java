package pl.coderslab.warsztatkoncowytaskplanner.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.warsztatkoncowytaskplanner.DTO.CommentDto;
import pl.coderslab.warsztatkoncowytaskplanner.Entities.Comment;
import pl.coderslab.warsztatkoncowytaskplanner.Repositories.CommentRepository;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentService implements BaseService<CommentDto, Long> {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto save(CommentDto dto) {
        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        commentRepository.save(comment);
        return comment.toDto();
    }

    @Override
    public CommentDto update(CommentDto dto, Long id) {
        Comment comment = commentRepository.findCommentById(id);
        comment.setContent(dto.getContent());
        commentRepository.save(comment);
        return comment.toDto();
    }

    @Override
    public CommentDto find(Long id) {
        Comment comment = commentRepository.findCommentById(id);
        if (Objects.isNull(comment)) {
            return null;
        }else {
            return comment.toDto();
        }

    }

    @Override
    public Boolean remove(Long id) {
        Comment comment = commentRepository.findCommentById(id);
        commentRepository.delete(comment);
        return true;
    }

    @Override
    public Collection<CommentDto> getAll() {
        return commentRepository
                .findAll()
                .stream()
                .filter(Objects::nonNull)
                .map(Comment::toDto)
                .collect(Collectors.toList());
    }
}
