package co.edu.udea.epm.dto;
// Generated 27-may-2018 20:11:32 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado implements java.io.Serializable {

	private int documento;
	private Equipo equipo;
	private Sector sector;
	private TipoEmpleado tipoEmpleado;
	private String nombre;
	private String email;
	private String telefono;

	public Empleado() {
	}

	public Empleado(int documento, TipoEmpleado tipoEmpleado) {
		this.documento = documento;
		this.tipoEmpleado = tipoEmpleado;
	}

	public Empleado(int documento, Equipo equipo, Sector sector, TipoEmpleado tipoEmpleado, String nombre, String email,
			String telefono) {
		this.documento = documento;
		this.equipo = equipo;
		this.sector = sector;
		this.tipoEmpleado = tipoEmpleado;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	public int getDocumento() {
		return this.documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Sector getSector() {
		return this.sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public TipoEmpleado getTipoempleado() {
		return this.tipoEmpleado;
	}

	public void setTipoempleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
