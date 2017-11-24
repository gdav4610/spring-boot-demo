package mx.isban.formacionplataformadigital.cuentas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.formacionplataformadigital.cuentas.dao.ICuentasDAO;
import mx.isban.formacionplataformadigital.cuentas.exception.CuentaNoEncontradaException;
import mx.isban.formacionplataformadigital.cuentas.exception.ErrorEnum;
import mx.isban.formacionplataformadigital.cuentas.exception.LimiteCuentasException;
import mx.isban.formacionplataformadigital.cuentas.model.Cuenta;


@Service
public class CuentasService implements ICuentasService {

	/** La Constante logger. Obtiene el Logger de la clase */
    private static final Logger logger = LoggerFactory.getLogger(CuentasService.class);

	@Autowired
	private ICuentasDAO ctaDao;
	
	@Autowired
	private IClienteService ctasClienteService;


	@Override
	public Cuenta getPorId(long id) throws CuentaNoEncontradaException {
		Cuenta cta = ctaDao.getPorId(id);
		if(cta == null){
			logger.info("Cuenta {} no encontrada", id);
			throw new CuentaNoEncontradaException(ErrorEnum.CTAS_NO_ENCONTRADA.getDescription());
		}


		ctasClienteService.getCliente(1);
		//TODO: realizar logica necesaria para cumplir la funcionalidad de obtencion de cuenta por id
		
		return cta;
	}


	@Override
	public long create(Cuenta cta) throws LimiteCuentasException {
		//validaciones y reglas de negocio
		if(ctaDao.getCantidadCuentas() > 5){
			logger.info("Limite de cuentas sobrepasado");
			throw new LimiteCuentasException(ErrorEnum.CTAS_LIMITE_ALCANZADO);
		}
		
		long idCuenta = ctaDao.create(cta);

		logger.info("Cuenta {} creada", idCuenta);
		//TODO: Bitacorizar transaccion hecha
		
		return idCuenta;
	}
	
}
