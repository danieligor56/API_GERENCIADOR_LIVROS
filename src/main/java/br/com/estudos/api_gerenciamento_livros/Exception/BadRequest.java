package br.com.estudos.api_gerenciamento_livros.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public BadRequest () {
		super();
	}

	public BadRequest(String message) { super(message);}
	public BadRequest(Throwable cause) {super(cause);}
	public BadRequest(String message,Throwable cause) {super(message,cause);}
}
