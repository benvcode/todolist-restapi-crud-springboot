package com.benvcode.todolist.restapi.crud.springboot.domain.tarefa;

import com.benvcode.todolist.restapi.crud.springboot.domain.tarefa.interfaces.TarefaMapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TarefaMapperImpl implements TarefaMapper {
    @Override
    public Tarefa dtoToEntity(TarefaDto tarefaDto) {
        return TarefaMapper.INSTANCE.dtoToEntity(tarefaDto);
    }

    @Override
    public TarefaDto entityToDto(Tarefa tarefa) {
        return TarefaMapper.INSTANCE.entityToDto(tarefa);
    }

    @Override
    public List<TarefaDto> toListDto(List<Tarefa> tarefaList) {
        return tarefaList.stream()
                .map(TarefaMapper.INSTANCE::entityToDto)
                .collect(Collectors.toList());
    }

}
