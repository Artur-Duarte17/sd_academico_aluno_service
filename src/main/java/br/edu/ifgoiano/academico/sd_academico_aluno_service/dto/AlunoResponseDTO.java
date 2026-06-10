package br.edu.ifgoiano.academico.sd_academico_aluno_service.dto;

import br.edu.ifgoiano.academico.sd_academico_aluno_service.enums.StatusAluno;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Dados de saída ao expor um aluno pela API.
 */
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Representação de um aluno retornada pela API")
public class AlunoResponseDTO {

    @Schema(description = "Identificador do aluno", example = "1")
    private Long id;

    @Schema(description = "Nome completo do aluno", example = "Ana Beatriz Lima")
    private String nome;

    @Schema(description = "Matrícula única do aluno", example = "20251234")
    private String matricula;

    @Schema(description = "E-mail único do aluno", example = "ana.lima@ifgoiano.edu.br")
    private String email;

    @Schema(description = "Curso do aluno", example = "Sistemas de Informação")
    private String curso;

    @Schema(description = "Status atual do aluno", example = "ATIVO")
    private StatusAluno status;

    @Schema(description = "Data de criação do registro", example = "2026-06-10T14:30:00")
    private LocalDateTime dataCriacao;
}
