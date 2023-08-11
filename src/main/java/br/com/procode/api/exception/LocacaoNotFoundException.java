package br.com.procode.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocacaoNotFoundException extends RuntimeException {
    public LocacaoNotFoundException(String message) {
        super(message);
    }
}
