package mx.isban.formacionplataformadigital.cuentas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import mx.isban.formacionplataformadigital.cuentas.model.Cliente;



@Service
public class ClienteService implements IClienteService {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@HystrixCommand(fallbackMethod = "getFallbackCliente")
	public Cliente getCliente(long idCliente) {
		Cliente r =  restTemplate.getForObject("http://localhost:8080/clientes/{id}/datos_basicos", 
				Cliente.class, idCliente);
		 return r;
	}
	

    public Cliente getFallbackCliente(long idCliente ) {
    	Cliente cte = new Cliente();
		return cte;
	}

}
