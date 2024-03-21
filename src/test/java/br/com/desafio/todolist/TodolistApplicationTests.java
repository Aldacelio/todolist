package br.com.desafio.todolist;

import java.time.LocalDate;

import static br.com.desafio.todolist.TestConstants.TODO;
import static br.com.desafio.todolist.TestConstants.TODOS;

import br.com.desafio.todolist.model.ToDo;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("/remove.sql") // Executa o script SQL antes dos testes
class TodolistApplicationTests {

        @Autowired
        private WebTestClient webTestClient;

        @Test
        void testCreateTodoSuccess() {
                var todo = new ToDo("todo 1", "desc todo 1", LocalDate.of(2030, 07, 15));

                webTestClient
                                .post()
                                .uri("/todos")
                                .bodyValue(todo)
                                .exchange()
                                .expectStatus().isCreated()
                                .expectBody()
                                .jsonPath("$").isArray()
                                .jsonPath("$.length()").isEqualTo(1)
                                .jsonPath("$[0].titulo").isEqualTo(todo.getTitulo())
                                .jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
                                .jsonPath("$[0].vencimento").isEqualTo(todo.getVencimento().toString());
        }

        @Test
        public void testCreateTodoFailure() {
                webTestClient
                                .post()
                                .uri("/todos")
                                .bodyValue(new ToDo("", "", null))
                                .exchange()
                                .expectStatus().isBadRequest();
        }

        @Sql("/import.sql") // Executa o script SQL antes dos testes
        @Test
        public void testUpdateTodoSuccess() {
                var todoUp = new ToDo(TODO.getId(), TODO.getTitulo() + " Up", TODO.getDescricao() + " Up",
                                TODO.getVencimento());

                webTestClient
                                .put()
                                .uri("/todos/" + TODO.getId())
                                .bodyValue(todoUp)
                                .exchange()
                                .expectStatus().isOk()
                                .expectBody()
                                .jsonPath("$").isArray()
                                .jsonPath("$.length()").isEqualTo(2)
                                .jsonPath("$[0].titulo").isEqualTo(todoUp.getTitulo())
                                .jsonPath("$[0].descricao").isEqualTo(todoUp.getDescricao())
                                .jsonPath("$[0].vencimento").isEqualTo(todoUp.getVencimento().toString());
        }

        @Test
        public void testUpdateTodoFailure() {
                var unexinstingId = 1L;

                webTestClient
                                .put()
                                .uri("/todos/" + unexinstingId)
                                .bodyValue(new ToDo(unexinstingId, "", "", null))
                                .exchange()
                                .expectStatus().isBadRequest();
        }

        @Sql("/import.sql") // Executa o script SQL antes dos testes
        @Test
        public void testDeleteTodoSuccess() {
                webTestClient
                                .delete()
                                .uri("/todos/" + TODOS.get(0).getId())
                                .exchange()
                                .expectStatus().isOk()
                                .expectBody()
                                .jsonPath("$").isArray()
                                .jsonPath("$.length()").isEqualTo(1)
                                .jsonPath("$[0].titulo").isEqualTo(TODOS.get(1).getTitulo())
                                .jsonPath("$[0].descricao").isEqualTo(TODOS.get(1).getDescricao())
                                .jsonPath("$[0].vencimento").isEqualTo(TODOS.get(1).getVencimento().toString());
        }

        @Test
        public void testDeleteTodoFailure() {
                var unexinstingId = 1L;

                webTestClient
                                .delete()
                                .uri("/todos/" + unexinstingId)
                                .exchange()
                                .expectStatus().isBadRequest();
        }

        @Sql("/import.sql") // Executa o script SQL antes dos testes
        @Test
        public void testListTodos() throws Exception {
                webTestClient
                                .get()
                                .uri("/todos")
                                .exchange()
                                .expectStatus().isOk()
                                .expectBody()
                                .jsonPath("$").isArray()
                                .jsonPath("$.length()").isEqualTo(2);

        }

}
