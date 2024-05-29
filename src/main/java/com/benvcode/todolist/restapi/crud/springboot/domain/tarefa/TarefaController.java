package com.benvcode.todolist.restapi.crud.springboot.domain.tarefa;


import com.benvcode.todolist.restapi.crud.springboot.utils.BaseEntityDtoResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todolist/api/v1/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;
    private final TarefaMapperImpl tarefaMapper;

    @PostMapping
    public ResponseEntity<TarefaDto> create(@RequestBody TarefaDto tarefaDto) {
        // 'ResponseEntity' representa uma resposta HTTP com código de status, cabeçalhos e corpo.
        // '@RequestBody' recebe e mapeia os dados do 'corpo de uma solicitação HTTP' enviados pelo cliente
        //  geralmente no formato 'JSON' que são convertidos automaticamente pelo Spring Boot em objectos Java.

        Tarefa tarefaCriada = tarefaService.create(
                tarefaMapper.dtoToEntity(tarefaDto));

        // Retorna uma resposta com status 201 (CREATED) e corpo contendo os dados da tarefa.
        return ResponseEntity.status(HttpStatus.CREATED).body(
                tarefaMapper.entityToDto(tarefaCriada));
    }

    @GetMapping
    public ResponseEntity<List<TarefaDto>> getAll() {
        List<Tarefa> tarefaList = tarefaService.getAll();

        // Retorna uma resposta com status 200 (OK) e corpo contendo a lista de todas as tarefas.
        return ResponseEntity.ok(tarefaMapper.toListDto(tarefaList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDto> getById(@PathVariable("id") Long id) {
        // '@PathVariable' para extrair o valor da variável 'id' no endpoint.

        Tarefa tarefa = tarefaService.getById(id);

        // Retorna uma resposta com status 200 (OK) e corpo contendo a tarefa.
        return ResponseEntity.ok(tarefaMapper.entityToDto(tarefa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseEntityDtoResponse> update(
            @PathVariable("id") Long id, @RequestBody TarefaDto tarefaDto) {
        Tarefa novaTarefa = tarefaService.update(id,
                this.tarefaMapper.dtoToEntity(tarefaDto));

        BaseEntityDtoResponse baseEntityDtoResponse = new BaseEntityDtoResponse();
        baseEntityDtoResponse.setId(novaTarefa.getId());
        // Criando link hipermídia(hateoas) para recuperar os detalhes da tarefa atualizada, incluindo
        // campos não modificados.
        baseEntityDtoResponse.add(linkTo(methodOn(TarefaController.class).getById(
                novaTarefa.getId())).withSelfRel());

        // Retorna uma resposta com status 200 (OK) e corpo contendo 'baseEntityDtoResponse'.
        return ResponseEntity.ok(baseEntityDtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TarefaDto> delete(@PathVariable("id") Long id) {
        tarefaService.delete(id);

        // Retorna uma resposta com status 204 (No Content) indicando que a tarefa foi excluída com sucesso.
        return ResponseEntity.noContent().build();
    }
}