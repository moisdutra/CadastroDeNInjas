package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaRepository ninjaRepository;
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService, NinjaRepository ninjaRepository) {
        this.ninjaService = ninjaService;
        this.ninjaRepository = ninjaRepository;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota dá uma mensagem de boas vindas a quem acessa")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo Ninja", description = "Cria um novo ninja e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do Ninja.")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    // Mostrar todos os ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por Id", description = "Lista um ninja pelo Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")
    })
    public ResponseEntity<?> listarNinjasPorID(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorID(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado.");
        }
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por Id", description = "Altera um ninja pelo seu Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")
    })
    public ResponseEntity<?> alterarNinjasPorID(
            @Parameter(description = "Usuário envia o id pela requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário envia os dados a serem atualizados no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado.");
        }
    }

    // Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjasPorID(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorID(id) != null) {
            ninjaService.deletarNinjaPorID(id);
            return ResponseEntity.ok("Ninja com ID " + id + " deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com ID " + id + " não encontrado.");
    }

}
