package mx.isban.formacionplataformadigital.cuentas.dao;

import mx.isban.formacionplataformadigital.cuentas.model.Cuenta;


public interface ICuentasDAO {

	public Cuenta getPorId(long id);
	
	public long create(Cuenta prod);

	public int getCantidadCuentas();
}
