package mx.isban.formacionplataformadigital.cuentas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import mx.isban.formacionplataformadigital.cuentas.exception.model.DefaultErrorList;
import mx.isban.formacionplataformadigital.cuentas.exception.model.DefaultError;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultErrorList> handleGenericException(Exception ex) {
		DefaultErrorList error = new DefaultErrorList(new DefaultError(ErrorEnum.CTAS_GENERICO));
		return new ResponseEntity<DefaultErrorList>(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }
	

	
}