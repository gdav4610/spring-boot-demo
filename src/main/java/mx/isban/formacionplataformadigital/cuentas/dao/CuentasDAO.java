package mx.isban.formacionplataformadigital.cuentas.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import mx.isban.formacionplataformadigital.cuentas.model.Cuenta;


@Repository
public class CuentasDAO implements ICuentasDAO{

	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Cuenta> ctas;
	

	static{
		ctas = llenarCuentasDummy();
	}
	

    
	public Cuenta getPorId(long id) {
		for(Cuenta cta : ctas){
			if(cta.getId() == id){
				return cta;
			}
		}
		return null;
	}


	public long create(Cuenta cta) {
		cta.setId(counter.incrementAndGet());
		ctas.add(cta);
		return cta.getId();
	}


	public int getCantidadCuentas(){
		return ctas.size();
	}
	

	private static List<Cuenta> llenarCuentasDummy(){
		List<Cuenta> ctas = new ArrayList<Cuenta>();
		ctas.add(new Cuenta(1, "12090294110", "CUENTA NOMINA", 1000));
		ctas.add(new Cuenta(2, "11570293210", "CUENTA NOMINA PREFERENCIAL", 3500));
		ctas.add(new Cuenta(3, "16090273112", "CUENTA NOMINA PREFERENCIAL", 5000));
		ctas.add(new Cuenta(4, "18090293114", "CUENTA NOMINA", 2000));
		return ctas;
	}
	



}
