package com.example.GerenciadorTarefas.repositories;

import com.example.GerenciadorTarefas.entities.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {
}
