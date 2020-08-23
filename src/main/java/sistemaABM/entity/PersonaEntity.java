package sistemaABM.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "Persona", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")})

public class PersonaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer PersonaId;
	
	@Column(name = "NOMBRE", unique = false, nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "EDAD", unique = false, nullable = false, length = 2)
	private Integer edad;
	
	@Column(name = "FECHA_NACIMIENTO", unique = false, nullable = false, length = 100)
	private Date fechaNacimiento;

	public Integer getPersonaId() {
		return PersonaId;
	}

	public void setPersonaId(Integer personaId) {
		PersonaId = personaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getId() {
		return PersonaId;
	}
}
