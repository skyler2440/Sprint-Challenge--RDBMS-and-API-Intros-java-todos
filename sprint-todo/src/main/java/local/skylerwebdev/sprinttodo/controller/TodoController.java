package local.skylerwebdev.sprinttodo.controller;

import local.skylerwebdev.sprinttodo.model.Todo;
import local.skylerwebdev.sprinttodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")



public class TodoController
{
    @Autowired
    TodoService todoService;
    @PutMapping(value = "/todoid/{todoId}")
    public ResponseEntity<?> updateQuote(
            @RequestBody
            Todo updateTodo,
            @PathVariable
                    long todoId)
    {
        todoService.update(updateTodo, todoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
