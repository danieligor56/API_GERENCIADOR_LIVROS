package br.com.estudos.api_gerenciamento_livros;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@Table(name="livro")
@NoArgsConstructor
@Getter
@Setter

public class LivroEntity {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIVRO_ID")
    private long id;
	
    @Column(name="TITULO")
    String titulo;
    
    @Column(name="AUTOR")
	String autor;
	
    @Schema(example="yyyy")
    @JsonFormat(pattern = "yyyy",timezone = "America/Sao_Paulo")
    @Temporal(TemporalType.TIMESTAMP)
    Date anoPublic;
	
    @Column(name="NUMERO_PAGINAS")
    int qtdNumPag;
	
}
