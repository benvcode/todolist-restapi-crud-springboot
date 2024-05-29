package com.benvcode.todolist.restapi.crud.springboot.domain.tarefa.interfaces;


import com.benvcode.todolist.restapi.crud.springboot.domain.tarefa.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
