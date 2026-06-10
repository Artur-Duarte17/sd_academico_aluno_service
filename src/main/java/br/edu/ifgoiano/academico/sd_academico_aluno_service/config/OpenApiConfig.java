package br.edu.ifgoiano.academico.sd_academico_aluno_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuração do OpenAPI/Swagger.
 *
 * Após subir o serviço, a documentação interativa fica disponível em:
 *   - Swagger UI:  http://localhost:8082/swagger-ui.html
 *   - OpenAPI JSON: http://localhost:8082/v3/api-docs
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI alunoServiceOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                        new Server().url("/aluno").description("Via API Gateway"),
                        new Server().url("/").description("Acesso direto ao serviço")))
                .info(new Info()
                .title("Aluno Service API")
                .description("API de cadastro e consulta de alunos do Sistema Acadêmico Distribuído.")
                .version("v1"));
    }
}
