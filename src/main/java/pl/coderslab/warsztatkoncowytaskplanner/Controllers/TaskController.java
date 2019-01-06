package pl.coderslab.warsztatkoncowytaskplanner.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.warsztatkoncowytaskplanner.DTO.TaskDto;
import pl.coderslab.warsztatkoncowytaskplanner.Services.TaskService;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

    @RestController
    @RequestMapping("/task")
    public class TaskController {

        private final TaskService taskService;

        @Autowired
        public TaskController(TaskService taskService) {
            this.taskService = taskService;
        }

        @PostMapping(produces = APPLICATION_JSON_VALUE)
        public Result post(@RequestBody TaskDto taskDto){
            if (taskDto != null) {
                return Result.ok(taskService.save(taskDto));
            }else {
                return Result.error("Error");
            }
        }

        @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
        public Result get(@PathVariable Long id){
            if(taskService.find(id)!=null ){
                return  Result.ok(taskService.find(id));
            }else {
                return  Result.error("Error");
            }
        }

        @GetMapping(produces = APPLICATION_JSON_VALUE)
        public Result getAll() {
            return Result.ok(taskService.getAll());
        }

        @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
        public Result put(@RequestBody TaskDto taskDto, @PathVariable Long id){
            if (taskDto != null) {
                return Result.ok(taskService.update(taskDto,id));
            }else {
                return Result.error("Error");
            }
        }
        @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
        public Result delete(@PathVariable Long id){
            if(taskService.find(id)!=null ){
                return  Result.ok(taskService.remove(id));
            }else {
                return  Result.error("Error");
            }
        }
    }

