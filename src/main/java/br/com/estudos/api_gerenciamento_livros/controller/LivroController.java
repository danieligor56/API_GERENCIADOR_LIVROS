package br.com.estudos.api_gerenciamento_livros.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.estudos.api_gerenciamento_livros.LivroEntity;
import br.com.estudos.api_gerenciamento_livros.bookDTO;
import br.com.estudos.api_gerenciamento_livros.Exception.NotFound;
import br.com.estudos.api_gerenciamento_livros.services.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "GERENCIADOR DE LIVROS")
@RestController
@RequestMapping("/api/v1/Livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@Operation(summary = "Procurar livroSSS ", description = "Faz a busca do livro utilizando o ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK,LIVRO ENCONTRADO.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = LivroEntity.class)) }),
			@ApiResponse(responseCode = "201", description = "LIVRO ADICIONADO.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = LivroEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "LIVRO NÃO ENCONTRADO.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = NotFound.class)) }) })

	@GetMapping("/livros/{id}")
	public ResponseEntity<LivroEntity> getBookById(@PathVariable Long id) {
		return ResponseEntity.ok().body(livroService.getBookById(id));

	}

	@Operation(summary = "Cadastra um novo livro", description = "Faz o cadastro de um novo item")
	@ApiResponses(value = {

			@ApiResponse(responseCode = "201", description = "LIVRO ADICIONADO.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = LivroEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "LIVRO NÃO ENCONTRADO.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = NotFound.class)) }) })
	@PostMapping
	public ResponseEntity<LivroEntity> newBookEntity(@RequestBody bookDTO newBook) {
		LivroEntity livroEntity = livroService.inserirBook(newBook);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(livroEntity.getId()).toUri();

		return ResponseEntity.created(location).body(livroEntity);
	}
	@Operation(summary = "Cadastra um novo livro", description = "Faz o cadastro de um novo item")
	@ApiResponses(value = {

			@ApiResponse(responseCode = "201", description = "LIVRO ADICIONADO.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = LivroEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "LIVRO NÃO ENCONTRADO.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = NotFound.class)) }) })
	@DeleteMapping("/livros/{id}")
	public ResponseEntity<LivroEntity> deleteBook(@PathVariable Long id){
		return ResponseEntity.ok(livroService.BookDelete(id));
		}
	@PutMapping("/livros/{id}")
	public ResponseEntity<Void> alterarBook(@PathVariable("id") Long id,@Valid @RequestBody bookDTO dto){
		livroService.alterarBook(id,dto); 
		return ResponseEntity.noContent().build();
	}
	

}
