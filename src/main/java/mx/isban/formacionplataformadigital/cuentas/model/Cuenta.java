package mx.isban.formacionplataformadigital.cuentas.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class Cuenta implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	private long id;
	
	@NotNull
	@Length(min=1, max=11)
	@Pattern(regexp = "^[0-9]*$")
	private String numero;
	

	@NotNull
	@Length(min=1, max=100)
	private String descripcion;
	
	@NotNull
	@Min(value = 0L, message = "El valor debe ser positivo")
	private double saldo;

	
	public Cuenta(){
		id=0;
	}

	public Cuenta(Cuenta cuenta){
		this.id = cuenta.getId();
		this.numero = cuenta.getNumero();
		this.descripcion = cuenta.getDescripcion();
		this.saldo = cuenta.getSaldo();
	}
	
	public Cuenta(long id, String numero, String descripcion, double saldo){
		this.id = id;
		this.numero = numero;
		this.descripcion = descripcion;
		this.saldo = saldo;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", numero=" + numero + ", descripcion=" + descripcion
				+ ", saldo=" + saldo + "]";
	}


}
