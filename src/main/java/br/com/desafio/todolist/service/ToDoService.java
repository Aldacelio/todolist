package br.com.desafio.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.desafio.todolist.exception.BadRequestException;
import br.com.desafio.todolist.model.ToDo;
import br.com.desafio.todolist.repository.ToDoRepository;

@Service // Indica que esta classe é um componente de serviço gerenciado pelo Spring
public class ToDoService {

    private ToDoRepository toDoRepository;

    // Construtor que injeta a dependência do ToDoRepository
    public ToDoService(ToDoRepository toDoRepository) {

        this.toDoRepository = toDoRepository;
    
    }

    // Método para criar uma nova tarefa
    public List<ToDo> create(ToDo todo) {

        toDoRepository.save(todo);// Salva a nova tarefa no banco de dados
        return list(); // Retorna a lista atualizada de tarefas

    }

    // Método para listar todas as tarefas de forma ordenada
    public List<ToDo> list() {

        // Cria um objeto Sort para definir a ordem de classificação
        Sort sort = Sort.by("vencimento").descending().and(
                Sort.by("titulo").ascending()); // Criando objeto de ordenação.

        return toDoRepository.findAll(sort); // Retorna todas as tarefas ordenadas

    }

    // Método para atualizar uma tarefa existente
    public List<ToDo> update(Long id, ToDo todo) {
        
        // Verifica se a tarefa existe pelo ID
        toDoRepository.findById(id).ifPresentOrElse((existingTodo) -> {
            todo.setId(id); // Define o ID da nova tarefa
            toDoRepository.save(todo); // Atualiza a tarefa no banco de dados
        }, () -> {
            // Caso a tarefa não exista, lança uma BadRequestException
            throw new BadRequestException("Todo %d não existe! ".formatted(id));
        });

        return list(); // Retorna a lista atualizada de tarefas

    }

    // Método para excluir uma tarefa existente
    public List<ToDo> delete(Long id) {

        // Verifica se a tarefa existe pelo ID
        toDoRepository.findById(id).ifPresentOrElse((existingTodo) -> toDoRepository.delete(existingTodo), () -> {
            // Caso a tarefa não exista, lança uma BadRequestException
            throw new BadRequestException("Todo %d não existe! ".formatted(id));
        });

        return list(); // Caso a tarefa não exista, lança uma BadRequestException

    }
    
}
