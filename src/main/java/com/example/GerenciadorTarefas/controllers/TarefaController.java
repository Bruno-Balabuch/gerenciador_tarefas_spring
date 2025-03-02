package com.example.GerenciadorTarefas.controllers;

import com.example.GerenciadorTarefas.entities.TarefaEntity;
import com.example.GerenciadorTarefas.services.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<TarefaEntity> listarTarefas(){
        return tarefaService.listarTarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaEntity> buscarTarefaId(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(tarefaService.buscarTarefaId(id));
    }

    @PostMapping
    public ResponseEntity<TarefaEntity> criarTarefa(@RequestBody TarefaEntity tarefa) {
        return ResponseEntity.ok(tarefaService.criarTarefa(tarefa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaEntity> atualizartarefa(@PathVariable(name = "id") Long id, @RequestBody TarefaEntity tarefa){
        return ResponseEntity.ok(tarefaService.atualizartarefa(id, tarefa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TarefaEntity> deletarTarefa(@PathVariable(name = "id") Long id){
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
