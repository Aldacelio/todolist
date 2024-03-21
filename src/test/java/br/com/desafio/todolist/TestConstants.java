package br.com.desafio.todolist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.todolist.model.ToDo;

// Classe para definir constantes de teste relacionadas às tarefas (ToDo)
public class TestConstants {

  // Lista de tarefas de exemplo
  public static final List<ToDo> TODOS = new ArrayList<>() {

    {

      // Adiciona duas tarefas à lista
      add(new ToDo(9998L, "ToDo1", "Primeira ToDo", LocalDate.of(2025, 7, 15))); // Primeira tarefa
      add(new ToDo(9999L, "ToDo2", "Segunda ToDo", LocalDate.of(2028, 8, 28))); // Segunda tarefa

    }

  };

  // Tarefa de exemplo
  public static final ToDo TODO = TODOS.get(1);

}
