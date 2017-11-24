package mx.isban.formacionplataformadigital.cuentas.service;

import mx.isban.formacionplataformadigital.cuentas.model.Cliente;

public interface IClienteService {
	
	public Cliente getCliente(long idCliente);
	
	public Cliente getFallbackCliente(long idCliente );

}
