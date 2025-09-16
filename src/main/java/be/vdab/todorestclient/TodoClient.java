package be.vdab.todorestclient;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Component
class TodoClient {
    private final Requests requests;

    TodoClient(Requests requests) {
        this.requests = requests;
    }

    List<TodoResponse> findAllByMensId(long id) {
        return Arrays.stream(requests.findAllByMensId(id))
                .sorted(Comparator.comparing(TodoResponse::prioriteit,
                        Comparator.reverseOrder())).toList();
    }
}
