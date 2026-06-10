package br.edu.ifgoiano.academico.sd_academico_aluno_service.dto;

import br.edu.ifgoiano.academico.sd_academico_aluno_service.enums.StatusAluno;
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
public class AlunoResponseDTO {
    private Long id;
    private String nome;
    private String matricula;
    private String email;
    private String curso;
    private StatusAluno status;
    private LocalDateTime dataCriacao;
}
