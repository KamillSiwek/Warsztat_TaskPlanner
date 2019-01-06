package pl.coderslab.warsztatkoncowytaskplanner.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.warsztatkoncowytaskplanner.DTO.TaskDto;
import pl.coderslab.warsztatkoncowytaskplanner.Entities.Task;
import pl.coderslab.warsztatkoncowytaskplanner.Repositories.CategoryRepository;
import pl.coderslab.warsztatkoncowytaskplanner.Repositories.TaskRepository;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
    public class TaskService implements BaseService<TaskDto, Long> {

        private final TaskRepository taskRepository;
        private final CategoryRepository categoryRepository;

        @Autowired
        public TaskService(TaskRepository taskRepository, CategoryRepository categoryRepository) {
            this.taskRepository = taskRepository;
            this.categoryRepository =categoryRepository;
        }

        @Override
        public TaskDto save(TaskDto dto) {
            Task task = new Task();
            task.setName(dto.getName());
            task.setDescription(dto.getDescription());
            task.setCategory(categoryRepository.findCategoryByName(dto.getCategory().getName()));
            taskRepository.save(task);
            return task.toDto();
        }

        @Override
        public TaskDto update(TaskDto dto, Long id) {
            Task task = taskRepository.findTaskById(id);
            task.setName(dto.getName());
            task.setDescription(dto.getDescription());
            task.setCategory(categoryRepository.findCategoryByName(dto.getCategory().getName()));
            task.setComments(dto.getComments());
            taskRepository.save(task);
            return task.toDto();
        }

        @Override
        public TaskDto find(Long id) {
            Task task = taskRepository.findTaskById(id);
            if (Objects.isNull(task)) {
                return null;
            }else {
                return task.toDto();
            }

        }

        @Override
        public Boolean remove(Long id) {
            Task task = taskRepository.findTaskById(id);
            taskRepository.delete(task);
            return true;
        }

        @Override
        public Collection<TaskDto> getAll() {
            return taskRepository
                    .findAll()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(Task::toDto)
                    .collect(Collectors.toList());
        }
    }

