package be.vdab.todorestclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(components = {TodoController.class, TodoClient.class , Configuratie.class})
class TodoControllerTest {

    MockRestServiceServer mockServer;
    TodoController todoController;
    ObjectMapper objectMapper;

    TodoControllerTest(MockRestServiceServer mockServer, TodoController todoController, ObjectMapper objectMapper) {
        this.mockServer = mockServer;
        this.todoController = todoController;
        this.objectMapper = objectMapper;
    }

    @Test
    void findTodosVindtAlleTodosVolgensPrioriteit() throws JsonProcessingException {

        List<TodoResponse> data = List.of(
                new TodoResponse("test", 1, LocalDateTime.now()),
                new TodoResponse("test2", 10, LocalDateTime.now())
        );

        mockServer.expect(requestTo("http://localhost:8080/mensen/1/todos"))
                .andRespond(withSuccess(objectMapper.writeValueAsString(data), MediaType.APPLICATION_JSON));

        List<TodoResponse> todos = todoController.findTodos(1);
        assertEquals("test2", todos.getFirst().tekst());
    }
}
