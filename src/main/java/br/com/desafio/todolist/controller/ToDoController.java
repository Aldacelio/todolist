package br.com.desafio.todolist.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.todolist.model.ToDo;
import br.com.desafio.todolist.service.ToDoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private ToDoService toDoService;

    // Injeta o serviço ToDoService no controlador ToDoController
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    // Endpoint para criar uma nova tarefa
    @PostMapping
    ResponseEntity<List<ToDo>> create(@Valid @RequestBody ToDo todo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toDoService.create(todo));
    }

    // Endpoint para obter a lista de todas as tarefas
    @GetMapping
    List<ToDo> list() {
        return toDoService.list();
    }

    // Endpoint para atualizar uma tarefa existente
    @PutMapping("{id}")
    List<ToDo> update(@PathVariable Long id, @RequestBody ToDo todo) {
        return toDoService.update(id, todo);
    }

    // Endpoint para excluir uma tarefa existente
    @DeleteMapping("{id}")
    List<ToDo> delete(@PathVariable Long id) {
        return toDoService.delete(id);
    }
}
