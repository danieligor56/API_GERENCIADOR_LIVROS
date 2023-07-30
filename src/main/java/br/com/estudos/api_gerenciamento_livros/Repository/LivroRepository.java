package br.com.estudos.api_gerenciamento_livros.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.estudos.api_gerenciamento_livros.LivroEntity;



@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long>{

	public Optional<LivroEntity> findBytitulo(String titulo);
	public boolean existsBytitulo(String titulo);
}
