package br.com.desafio.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.todolist.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long>{
    
}
