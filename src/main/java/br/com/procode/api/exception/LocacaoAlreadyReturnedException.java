package br.com.procode.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LocacaoAlreadyReturnedException extends RuntimeException {
    public LocacaoAlreadyReturnedException(String message) {
        super(message);
    }
}
