package br.com.desafio.todolist.exception;

// Exceção personalizada para representar erros de requisição inválidos (status HTTP 400)
public class BadRequestException extends RuntimeException {

    // Construtor que aceita uma mensagem de erro como parâmetro
    public BadRequestException(String message){
        super(message);// Chama o construtor da classe RuntimeException, passando a mensagem de erro
    }
}
