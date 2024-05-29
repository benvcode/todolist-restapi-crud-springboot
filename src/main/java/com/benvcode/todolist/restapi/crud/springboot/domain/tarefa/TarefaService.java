package com.benvcode.todolist.restapi.crud.springboot.domain.tarefa;

import com.benvcode.todolist.restapi.crud.springboot.domain.tarefa.interfaces.TarefaRepository;
import com.benvcode.todolist.restapi.crud.springboot.infra.exceptions.EntityNotFoundException;
import com.benvcode.todolist.restapi.crud.springboot.infra.exceptions.EntityUniqueViolationException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public Tarefa create(Tarefa tarefa) {
        try {
            return tarefaRepository.save(tarefa);
        } catch (org.springframework.dao.DataIntegrityViolationException  ex) {
            throw new EntityUniqueViolationException(
                    String.format("Tarefa '%s' já cadastrada", tarefa.getNome()));
        }
    }

    public List<Tarefa> getAll() {
        return tarefaRepository.findAll();
    }
    public Tarefa getById(Long id) {
        return  this.findById(id);
    }

    public Tarefa update(Long id, Tarefa novaTarefa) {

        // Obter a tarefa existente
        Tarefa tarefaExistente = this.findById(id);

        // Atribui o id da 'tarefaExistente' a 'novaTarefa'
        novaTarefa.setId(tarefaExistente.getId());

        // Retorna um novo objecto 'novaTarefa' criada com todos os campos modificados, porém para aqueles
        // que não foram modificados serão 'null'. Podemos verificar isto no 'Postman'.
        return this.create(novaTarefa);
    }

    public void delete(Long id) {
        // 'existsById()' retorna um valor booleano indicando se a entidade existe ou não

        if (!tarefaRepository.existsById(id)) {
            throw new EntityNotFoundException(String.
                    format("Tarefa com id '%s' não encontrada", id));
        }
        tarefaRepository.deleteById(id);
    }

    private Tarefa findById(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.
                        format("Tarefa com id '%s' não encontrada", id)));
    }

}
