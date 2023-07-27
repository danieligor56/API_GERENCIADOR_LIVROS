package br.com.estudos.api_gerenciamento_livros.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.estudos.api_gerenciamento_livros.LivroEntity;
import br.com.estudos.api_gerenciamento_livros.Repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LivroService {
@Autowired
private LivroRepository livroRepository;

public LivroEntity getBookById(Long id) {
    Optional<LivroEntity> livroOptional = livroRepository.findById(id);
   
    if (livroOptional.isPresent()) {
        return livroOptional.get(); // Extract and return the LivroEntity
    } else {
        // Handle the case when the LivroEntity with the given id is not found
        // You can throw an exception, return null, or do other appropriate error handling.
        throw new EntityNotFoundException("LivroEntity not found for id: " + id);
    }
}
}


