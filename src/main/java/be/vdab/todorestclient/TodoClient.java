package be.vdab.todorestclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
