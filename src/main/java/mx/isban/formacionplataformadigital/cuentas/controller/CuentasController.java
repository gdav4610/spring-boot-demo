package mx.isban.formacionplataformadigital.cuentas.controller;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import mx.isban.formacionplataformadigital.cuentas.exception.CuentaNoEncontradaException;
import mx.isban.formacionplataformadigital.cuentas.exception.ErrorEnum;
import mx.isban.formacionplataformadigital.cuentas.exception.LimiteCuentasException;
import mx.isban.formacionplataformadigital.cuentas.exception.model.DefaultErrorList;
import mx.isban.formacionplataformadigital.cuentas.exception.model.DefaultError;
import mx.isban.formacionplataformadigital.cuentas.model.Cuenta;
import mx.isban.formacionplataformadigital.cuentas.service.ICuentasService;


@RestController
@RequestMapping("/cuentas")
public class CuentasController {
	
	@Autowired
	private ICuentasService ctaService;
	
	/** La Constante logger. Obtiene el Logger de la clase */
    private static final Logger logger = LoggerFactory.getLogger(CuentasController.class);

    

    @RequestMapping(value = "/{id}/datos_basicos", method = RequestMethod.GET , 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<?> getCuentaPorId(@PathVariable("id") long id) {
        logger.info("Consulta cuentas con id {}", id);
        Cuenta cta;
        
		try {
			cta = ctaService.getPorId(id);
	        return new ResponseEntity<Cuenta>(cta, HttpStatus.OK);
		} catch (CuentaNoEncontradaException e) {
			logger.error("Excepcion de negocio", e);
			return new ResponseEntity<Object>(
            		new DefaultErrorList(new DefaultError(ErrorEnum.CTAS_NO_ENCONTRADA)), HttpStatus.NOT_FOUND);

		}

    }
    
    
    @RequestMapping(value = "/", method = RequestMethod.POST, 
					consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<?> crearCuenta(@Valid @RequestBody Cuenta cta, UriComponentsBuilder ucBuilder) {
        logger.info("Creando cuenta : {}", cta);
        long ctaId;
        
		try {
			ctaId = ctaService.create(cta);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
					"/{id}/datos_basicos").buildAndExpand(ctaId).toUri();
			return ResponseEntity.created(location).build();
			
		} catch (LimiteCuentasException e) {
			logger.error("Excepcion de negocio", e);
			 return new ResponseEntity<Object>(
	            		new DefaultErrorList(new DefaultError(ErrorEnum.CTAS_LIMITE_ALCANZADO)), HttpStatus.INTERNAL_SERVER_ERROR);

		}
        
    }
    
    
}
