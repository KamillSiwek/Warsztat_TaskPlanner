package pl.coderslab.warsztatkoncowytaskplanner.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.warsztatkoncowytaskplanner.Entities.Task;
import pl.coderslab.warsztatkoncowytaskplanner.Repositories.TaskRepository;

import java.util.Objects;
import java.util.stream.Collectors;


    @Service
    public class TaskService implements BaseService<TaskDto, Long> {

        private final TaskRepository taskRepository;

        @Autowired
        public TaskService(TaskRepository taskRepository) {
            this.taskRepository = taskRepository;
        }

        @Override
        public TaskDto save(TaskDto dto) {
            Task task = new Task();
            task.setTitle(dto.getTitle());
            task.setDescription(dto.getDescription());
            taskRepository.save(task);
            return task.toDto();
        }

        @Override
        public TaskDto update(TaskDto dto) {
            Task task = taskRepository.findTaskById(dto.getId());
            task.setTitle(dto.getTitle());
            task.setDescription(dto.getDescription());
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

