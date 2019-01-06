package pl.coderslab.warsztatkoncowytaskplanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.warsztatkoncowytaskplanner.DTO.UserDto;
import pl.coderslab.warsztatkoncowytaskplanner.Services.UserService;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Result post(@RequestBody UserDto userDto) {
        if (userDto != null) {
            return Result.ok(userService.save(userDto));
        } else {
            return Result.error("Error");
        }
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Result get(@PathVariable Long id) {
        if (userService.find(id) != null) {
            return Result.ok(userService.find(id));
        } else {
            return Result.error("Error");
        }
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Result getAll() {
        return Result.ok(userService.getAll());
    }

    @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Result put(@RequestBody UserDto userDto, @PathVariable Long id) {
        if (userDto != null) {
            return Result.ok(userService.update(userDto, id));
        } else {
            return Result.error("Error");
        }
    }

    @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Result delete(@PathVariable Long id) {
        if (userService.find(id) != null) {
            return Result.ok(userService.remove(id));
        } else {
            return Result.error("Error");
        }
    }
}
