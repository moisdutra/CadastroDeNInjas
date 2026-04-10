package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // GET -- Mandar requisição para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissoes() {
        return "Missoes listadas";
    }

    // POST -- Mandar requisição para criar as missoes
    @PostMapping("/criar")
    public String criaMissao(){
        return "Missao criada com sucesso";
    }

    // PUT -- Mandar requisição para alterar as missoes
    @PutMapping("/alterar")
    public String alteraMissao(){
        return "Missao alterada com sucesso";
    }

    // DELETE -- Mandar requisição para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletaMissao(){
        return "Missao deletada com sucesso";
    }

}
