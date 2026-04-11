package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET -- Mandar requisição para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // GET - listar missoes por Id
    @GetMapping("listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id) {
        return missoesService.listarMissoesPorID(id);
    }

    // POST -- Mandar requisição para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criaMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissoes(missao);
    }

    // PUT -- Mandar requisição para alterar as missoes
    @PutMapping("/alterar")
    public String alteraMissao(){
        return "Missao alterada com sucesso";
    }

    // DELETE -- Mandar requisição para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public void deletarMissoesPorID(@PathVariable Long id){
        missoesService.deletarMIssoesPorId(id);
    }

}
