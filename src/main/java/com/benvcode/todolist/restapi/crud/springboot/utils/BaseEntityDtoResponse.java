package com.benvcode.todolist.restapi.crud.springboot.utils;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseEntityDtoResponse extends RepresentationModel<BaseEntityDtoResponse> implements Serializable {
    // 'RepresentationModel<...>' para adicionar links HATEOAS a esta classe.
    private Long id;
}
