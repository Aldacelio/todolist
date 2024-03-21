package br.com.desafio.todolist.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "todos") // Define o nome da tabela no banco de dados
public class ToDo {

    @Id // Indica que este é o campo de identificação da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração automática do ID
    private long id;

    @NotBlank // Garante que o campo não pode estar vazio ou conter apenas espaços em branco
    private String titulo;

    @NotBlank // Garante que o campo não pode estar vazio ou conter apenas espaços em branco
    private String descricao;

    @NotNull // Garante que o campo não pode ser nulo
    @DateTimeFormat(pattern = "dd/MM/yyyy") // Define o formato da data
    @Temporal(TemporalType.DATE) // Define o tipo de temporalidade para a data
    private LocalDate vencimento;

    // Construtor padrão
    public ToDo() {

    }

    // Construtor com todos os campos
    public ToDo(Long id, @NotBlank String titulo, @NotBlank String descricao, @NotNull LocalDate vencimento) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.vencimento = vencimento;
    }

    // Construtor sem o campo id
    public ToDo(String titulo, String descricao, LocalDate vencimento) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.vencimento = vencimento;
    }

    // Getters e Setters para os campos
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

}
