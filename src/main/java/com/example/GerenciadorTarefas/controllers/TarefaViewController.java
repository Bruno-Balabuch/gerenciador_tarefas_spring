package com.example.GerenciadorTarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TarefaViewController {

    @GetMapping("/tarefas")
    public String exibirPaginaTarefas() {
        return "index.html"; // Static: /static/index.html
    }

}
