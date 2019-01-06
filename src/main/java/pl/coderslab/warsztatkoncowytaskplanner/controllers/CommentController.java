package pl.coderslab.warsztatkoncowytaskplanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.warsztatkoncowytaskplanner.DTO.CommentDto;
import pl.coderslab.warsztatkoncowytaskplanner.Services.CommentService;


import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Result post(@RequestBody CommentDto commentDto){
        if (commentDto != null) {
            return Result.ok(commentService.save(commentDto));
        }else {
            return Result.error("Error");
        }
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Result get(@PathVariable Long id){
        if(commentService.find(id)!=null ){
            return  Result.ok(commentService.find(id));
        }else {
            return  Result.error("Error");
        }
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Result getAll() {
        return Result.ok(commentService.getAll());
    }

    @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Result put(@RequestBody CommentDto commentDto, @PathVariable Long id){
        if (commentDto != null) {
            return Result.ok(commentService.update(commentDto,id));
        }else {
            return Result.error("Error");
        }
    }
    @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Result delete(@PathVariable Long id){
        if(commentService.find(id)!=null ){
            return  Result.ok(commentService.remove(id));
        }else {
            return  Result.error("Error");
        }
    }

}
