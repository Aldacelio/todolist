package br.com.desafio.todolist.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Notação do JPA para indicar que isto é uma entidade
@Table(name = "todos") // Notação do JPA para definir o nome da tabela
public class ToDo {

    @Id // Indicando que este é nosso id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gerando uma estratégia para que o ID seja gerado de forma
                                                        // sequencial e automatico
    private long id;
    private String titulo;
    private String descricao;
    private LocalDate vencimento;
    private Boolean realizado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }

}
