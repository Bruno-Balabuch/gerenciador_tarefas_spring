package com.example.GerenciadorTarefas.repositories;

import com.example.GerenciadorTarefas.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
