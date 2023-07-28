package br.com.estudos.api_gerenciamento_livros.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
