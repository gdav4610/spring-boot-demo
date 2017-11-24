package mx.isban.formacionplataformadigital.cuentas.service;

import mx.isban.formacionplataformadigital.cuentas.exception.CuentaNoEncontradaException;
import mx.isban.formacionplataformadigital.cuentas.exception.LimiteCuentasException;
import mx.isban.formacionplataformadigital.cuentas.model.Cuenta;

public interface ICuentasService {

	public Cuenta getPorId(long id) throws CuentaNoEncontradaException;

	public long create(Cuenta prod) throws LimiteCuentasException;
	
}
