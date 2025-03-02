package com.example.GerenciadorTarefas.services;

import com.example.GerenciadorTarefas.entities.TarefaEntity;
import com.example.GerenciadorTarefas.exceptions.ResourceNotFoundException;
import com.example.GerenciadorTarefas.repositories.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<TarefaEntity> listarTarefas(){
        return tarefaRepository.findAll();
    }

    public TarefaEntity buscarTarefaId(Long id){
        return tarefaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa com o id: " + id + " não foi encontrada"));
    }

    public TarefaEntity criarTarefa(TarefaEntity tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public TarefaEntity atualizartarefa(Long id, TarefaEntity tarefaAtualizada) {
        TarefaEntity tarefaExistente = buscarTarefaId(id);
        tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
        tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
        tarefaExistente.setCompleto(tarefaAtualizada.isCompleto());
        return tarefaRepository.save(tarefaExistente);
    }

    public void deletarTarefa(Long id){
        TarefaEntity tarefa = buscarTarefaId(id);
        tarefaRepository.delete(tarefa);
    }
}
