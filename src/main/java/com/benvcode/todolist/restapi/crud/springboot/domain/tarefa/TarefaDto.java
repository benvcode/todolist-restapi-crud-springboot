package com.benvcode.todolist.restapi.crud.springboot.domain.tarefa;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TarefaDto implements Serializable {
    // 'TarefaDto' que serve como um DTO (Data Transfer Object), inclui dados necessários que
    // queremos transporatr entre difrentes camadas da aplicação.
    private Long id;
    private String nome;
    private LocalDateTime dataCriacao;
}
