package br.edu.ifgoiano.academico.sd_academico_aluno_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.edu.ifgoiano.academico.sd_academico_aluno_service.dto.AlunoRequestDTO;
import br.edu.ifgoiano.academico.sd_academico_aluno_service.dto.AlunoResponseDTO;
import br.edu.ifgoiano.academico.sd_academico_aluno_service.entity.Aluno;
import br.edu.ifgoiano.academico.sd_academico_aluno_service.enums.StatusAluno;
import br.edu.ifgoiano.academico.sd_academico_aluno_service.repository.AlunoRepository;

import java.util.List;

@Service
public class AlunoService {

    private static final Logger logger = LoggerFactory.getLogger(AlunoService.class);

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public AlunoResponseDTO criarAluno(AlunoRequestDTO request) {

        if (repository.existsByMatricula(request.getMatricula())) {
            throw new RuntimeException("Matrícula já cadastrada.");
        }

        if (repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email já cadastrado.");
        }

        Aluno aluno = new Aluno();
        aluno.setNome(request.getNome());
        aluno.setMatricula(request.getMatricula());
        aluno.setEmail(request.getEmail());
        aluno.setCurso(request.getCurso());
        aluno.setStatus(request.getStatus() != null ? request.getStatus() : StatusAluno.ATIVO);

        return paraResponse(repository.save(aluno));
    }

    public List<AlunoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::paraResponse)
                .toList();
    }

    public AlunoResponseDTO buscarPorId(Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));
        return paraResponse(aluno);
    }

    public boolean alunoExiste(Long id) {
        boolean existe = repository.existsById(id);
        logger.info("[ALUNO-SERVICE] Verificando existência do aluno ID: {} -> {}", id, existe);
        return existe;
    }

    /**
     * Indica se o aluno existe E está com status ATIVO.
     * Usado pelo matrícula-service para impedir que alunos
     * INATIVOS ou TRANCADOS se matriculem.
     */
    public boolean alunoAtivo(Long id) {
        return repository.findById(id)
                .map(aluno -> aluno.getStatus() == StatusAluno.ATIVO)
                .orElse(false);
    }

    /**
     * Converte a entidade Aluno no DTO de resposta exposto pela API.
     */
    private AlunoResponseDTO paraResponse(Aluno aluno) {
        AlunoResponseDTO response = new AlunoResponseDTO();
        response.setId(aluno.getId());
        response.setNome(aluno.getNome());
        response.setMatricula(aluno.getMatricula());
        response.setEmail(aluno.getEmail());
        response.setCurso(aluno.getCurso());
        response.setStatus(aluno.getStatus());
        response.setDataCriacao(aluno.getDataCriacao());
        return response;
    }
}
