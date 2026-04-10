package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "NInja criado";
    }

    // Mostrar todos os ninjas
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas() {
        return "Mostrar Ninjas";
    }

    // Mostrar ninja por ID
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorID() {
        return "Mostrar Ninja por ID";
    }

    // Alterar dados dos ninjas
    @PutMapping("/alterarID")
    public String alterarNinjasPorID() {
        return "Alterar Ninja por ID";
    }

    // Deletar Ninja
    @DeleteMapping("/deletarID")
    public String deletarNinjasPorID() {
        return "Ninja deletado por ID";
    }

}
