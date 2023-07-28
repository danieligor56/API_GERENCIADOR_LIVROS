package br.com.estudos.api_gerenciamento_livros;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class bookDTO {

    private String titulo;
    private String autor;

    @Schema(example = "yyyy")
    @JsonFormat(pattern = "yyyy", timezone = "America/Sao_Paulo")
    private Date anoPublic;

    private int qtdNumPag;

    public bookDTO(LivroEntity livroEntity) {
        this.titulo = livroEntity.getTitulo();
        this.autor = livroEntity.getAutor();
        this.anoPublic = livroEntity.getAnoPublic();
        this.qtdNumPag = livroEntity.getQtdNumPag();
    }

    
}
