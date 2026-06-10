package br.edu.ifgoiano.academico.sd_academico_aluno_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.edu.ifgoiano.academico.sd_academico_aluno_service.dto.AlunoRequestDTO;
import br.edu.ifgoiano.academico.sd_academico_aluno_service.dto.AlunoResponseDTO;
import br.edu.ifgoiano.academico.sd_academico_aluno_service.service.AlunoService;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@Tag(name = "Alunos", description = "Cadastro e consulta de alunos")
public class AlunoController {

    private static final Logger logger = LoggerFactory.getLogger(AlunoController.class);

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar aluno", description = "Cadastra um novo aluno. A matrícula e o e-mail devem ser únicos.")
    public AlunoResponseDTO criarAluno(@RequestBody AlunoRequestDTO request) {
        return service.criarAluno(request);
    }

    @GetMapping
    @Operation(summary = "Listar alunos", description = "Retorna todos os alunos cadastrados.")
    public List<AlunoResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar aluno por ID", description = "Retorna o aluno com o ID informado.")
    public AlunoResponseDTO buscarPorId(
            @Parameter(description = "ID do aluno", example = "1") @PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "Verificar existência", description = "Indica se existe um aluno com o ID informado.")
    public boolean alunoExiste(
            @Parameter(description = "ID do aluno", example = "1") @PathVariable Long id) {
        logger.info("[ALUNO-SERVICE] GET /alunos/{}/existe", id);
        return service.alunoExiste(id);
    }

    @GetMapping("/{id}/ativo")
    @Operation(summary = "Verificar se está ativo",
            description = "Indica se o aluno existe e está com status ATIVO (usado pelo matrícula-service).")
    public boolean alunoAtivo(
            @Parameter(description = "ID do aluno", example = "1") @PathVariable Long id) {
        return service.alunoAtivo(id);
    }
}
