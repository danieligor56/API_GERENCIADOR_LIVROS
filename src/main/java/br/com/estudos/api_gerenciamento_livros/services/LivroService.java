package br.com.estudos.api_gerenciamento_livros.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudos.api_gerenciamento_livros.LivroEntity;
import br.com.estudos.api_gerenciamento_livros.bookDTO;
import br.com.estudos.api_gerenciamento_livros.Exception.BadRequest;
import br.com.estudos.api_gerenciamento_livros.Exception.NotFound;
import br.com.estudos.api_gerenciamento_livros.Repository.LivroRepository;

@Service
public class LivroService {
@Autowired
private LivroRepository livroRepository;

@Autowired
private ModelMapper modelMapper;

public LivroEntity getBookById(Long id) {
  return livroRepository.findById(id)
		  .orElseThrow(()-> new NotFound("Livro não encontrado"));
    
    }

public LivroEntity inserirBook(bookDTO newBook) {
	
	boolean exists = livroRepository.existsBytitulo(newBook.getTitulo());
	if (exists) {
		throw new BadRequest("Já existe um livro cadastrado com esse titulo !");
	}
	LivroEntity livro = modelMapper.map(newBook, LivroEntity.class);
	
			return livroRepository.save(livro);
}
public LivroEntity BookDelete(Long id) {
			try {
				livroRepository.deleteById(id);
			} catch (Exception e) {
				throw new BadRequest("Livro não encontrado");
			}
		return null;	
} 
}



