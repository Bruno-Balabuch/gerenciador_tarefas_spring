package com.example.GerenciadorTarefas.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tarefas")
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonProperty("title")
    private String titulo;

    @JsonProperty("description")
    private String descricao;

    @JsonProperty("completed")
    @Column(nullable = false)
    private boolean completo = false;

    public TarefaEntity() {
    }

    public TarefaEntity(boolean completo, String descricao, Long id, String titulo) {
        this.completo = completo;
        this.descricao = descricao;
        this.id = id;
        this.titulo = titulo;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TarefaEntity tarefaEntity = (TarefaEntity) o;
        return Objects.equals(id, tarefaEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
