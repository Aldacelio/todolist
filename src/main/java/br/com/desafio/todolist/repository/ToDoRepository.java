package br.com.desafio.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.todolist.model.ToDo;

// Interface responsável por interagir com o banco de dados para operações relacionadas a ToDo
public interface ToDoRepository extends JpaRepository<ToDo, Long>{
    
}
