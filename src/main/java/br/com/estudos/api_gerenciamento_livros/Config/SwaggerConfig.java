package br.com.estudos.api_gerenciamento_livros.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI gerenciadorLivros() {
		return new OpenAPI()
				.info(new Info().title("BookManager API")
				.description("Neste projeto, criamos uma API poderosa para gerenciar informações sobre livros."
						+ " Agora, você pode facilmente criar, ler, atualizar e excluir dados de livros usando nossa API.")
				.version("V1.0.0")
				.contact( new Contact()
						.name("0din.Ex3")
						.email("danieligor.vala@hotmail.com")
						.url("https://github.com/danieligor56/API_GERENCIADOR_LIVROS")));
			
	}

}
