package com.benvcode.todolist.restapi.crud.springboot.domain.tarefa.interfaces;



import com.benvcode.todolist.restapi.crud.springboot.domain.tarefa.Tarefa;
import com.benvcode.todolist.restapi.crud.springboot.domain.tarefa.TarefaDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TarefaMapper {
    TarefaMapper INSTANCE = Mappers.getMapper(TarefaMapper.class);
    Tarefa dtoToEntity(TarefaDto tarefaDto);
    TarefaDto entityToDto(Tarefa tarefa);
    List<TarefaDto> toListDto(List<Tarefa> tarefaList);

    // Outars interfaces...
}
