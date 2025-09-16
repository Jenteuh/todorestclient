package be.vdab.todorestclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mensen")
class TodoController {
    private final TodoClient todoClient;
    public TodoController(TodoClient todoClient) {
        this.todoClient = todoClient;
    }

    @GetMapping("{id}/todos")
    List<TodoResponse> findTodos(@PathVariable("id") long id) {
        return todoClient.findAllByMensId(id);
    }
}
