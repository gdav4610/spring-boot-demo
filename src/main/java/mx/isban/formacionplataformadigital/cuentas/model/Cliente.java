package mx.isban.formacionplataformadigital.cuentas.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	private long id;
	
	@NotNull
	@Length(min=1, max=100)
	@Pattern(regexp = "^[ a-zA-Z]*$")
	private String nombre;
	
	@NotNull
	@Length(min=1, max=100)
	@Pattern(regexp = "^[ a-zA-Z]*$")
	private String apellido;
	
	@NotNull
	@Min(value = 0, message = "El valor debe ser positivo")
	private Integer edad;
	
	
	
	public Cliente(){	
	}

	public Cliente(Cliente cliente){
		this.id = cliente.getId();
		this.nombre = cliente.getNombre();
		this.apellido = cliente.getApellido();
		this.edad = cliente.getEdad();
	}
	
	public Cliente(long id, String nombre, String apellido, Integer edad){
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", edad=" + edad + "]";
	}


}
