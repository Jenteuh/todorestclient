package be.vdab.todorestclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

interface Requests {
    @GetExchange("{id}/todos")
    TodoResponse[] findAllByMensId(@PathVariable long id);
}
