package br.com.estudos.api_gerenciamento_livros.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.estudos.api_gerenciamento_livros.LivroEntity;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long>{

}
