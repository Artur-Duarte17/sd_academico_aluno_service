package br.edu.ifgoiano.academico.sd_academico_aluno_service.dto;

import br.edu.ifgoiano.academico.sd_academico_aluno_service.enums.StatusAluno;
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
public class AlunoRequestDTO {
    private String nome;
    private String matricula;
    private String email;
    private String curso;
    private StatusAluno status;
}
