package br.com.desafio.todolist.controller;

import java.util.List;

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

     // Método para criar uma nova tarefa
    @PostMapping
    List<ToDo> create(@RequestBody ToDo todo){
        return toDoService.create(todo);
    }

    // Método para listar todas as tarefas
    @GetMapping
    List<ToDo> list(){
        return toDoService.list();
    }

    // Método para atualizar uma tarefa existente
    @PutMapping
    List<ToDo> update(@RequestBody ToDo todo){
        return toDoService.update(todo);
    }

    // Método para excluir uma tarefa com base no ID
    @DeleteMapping("{id}")
    List<ToDo> delete(@PathVariable("id") Long id){
        return toDoService.delete(id);
    }
}
