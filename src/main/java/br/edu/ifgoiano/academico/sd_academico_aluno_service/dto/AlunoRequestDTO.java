package br.edu.ifgoiano.academico.sd_academico_aluno_service.dto;

import br.edu.ifgoiano.academico.sd_academico_aluno_service.enums.StatusAluno;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dados de entrada para criação de um aluno.
 * O status é opcional; quando não informado, o aluno é criado como ATIVO.
 */
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Dados para criação de um aluno")
public class AlunoRequestDTO {

    @Schema(description = "Nome completo do aluno", example = "Ana Beatriz Lima")
    private String nome;

    @Schema(description = "Matrícula única do aluno", example = "20251234")
    private String matricula;

    @Schema(description = "E-mail único do aluno", example = "ana.lima@ifgoiano.edu.br")
    private String email;

    @Schema(description = "Curso do aluno", example = "Sistemas de Informação")
    private String curso;

    @Schema(description = "Status do aluno (opcional; padrão ATIVO)", example = "ATIVO")
    private StatusAluno status;
}
