package br.com.desafio.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.desafio.todolist.model.ToDo;
import br.com.desafio.todolist.repository.ToDoRepository;

@Service // Indicando que esta classe é um componente de serviço
public class ToDoService {

    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    // Criando tarefa
    public List<ToDo> create(ToDo todo) {
        toDoRepository.save(todo); 
        return list(); // Chamando o metodo list para listar todas as tarefas
    }
 
    // Listando de forma ordenada todas as tarefas
    public List<ToDo> list() {
        Sort sort = Sort.by("vencimento").descending().and(
            Sort.by("titulo").ascending()
        ); // Criando objeto de ordenação.
        return toDoRepository.findAll(sort); 
    }

    // Atualizando uma tarefa
    public List<ToDo> update(ToDo todo) {
        toDoRepository.save(todo); 
        return list(); // Chamando o metodo list para listar todas as tarefas
    }

    // Deletando uma tarefa
    public List<ToDo> delete(Long id) {
        toDoRepository.deleteById(id);
        return list(); // Chamando o metodo list para listar todas as tarefas
    }
}
