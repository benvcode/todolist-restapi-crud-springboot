package com.benvcode.todolist.restapi.crud.springboot.domain.tarefa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tarefa")
public class Tarefa implements Serializable {
    // 'Serializable' indica que os objectos desta class podem ser serializados(ou seja, convertidos
    // para outros tipos de formatos como JSON, XML)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @CreatedDate
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "realizada", nullable = false, columnDefinition = "boolean default false")
    private boolean realizada;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa1)) return false;
        return realizada == tarefa1.realizada && Objects.equals(id, tarefa1.id) && Objects.equals(nome, tarefa1.nome) && Objects.equals(dataCriacao, tarefa1.dataCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataCriacao, realizada);
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", realizada=" + realizada +
                '}';
    }
}