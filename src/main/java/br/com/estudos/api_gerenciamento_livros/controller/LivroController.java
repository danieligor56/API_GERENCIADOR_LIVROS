package br.com.estudos.api_gerenciamento_livros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.estudos.api_gerenciamento_livros.LivroEntity;
import br.com.estudos.api_gerenciamento_livros.services.LivroService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="GERENCIADOR DE LIVROS")
@RestController
@RequestMapping("/api/v1/Livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	
	 @GetMapping("/livros/{id}")
	    public ResponseEntity<LivroEntity> getLivroById(@PathVariable Long id) {
	        LivroEntity livro = livroService.getBookById(id);
	        if (livro != null) {
	            return ResponseEntity.ok(livro);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

		
	}




