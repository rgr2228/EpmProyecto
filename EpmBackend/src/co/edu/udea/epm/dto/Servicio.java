package co.edu.udea.epm.dto;
// Generated 27-may-2018 20:11:32 by Hibernate Tools 5.2.3.Final

import java.util.Date;

/**
 * Servicio generated by hbm2java
 */
public class Servicio implements java.io.Serializable {

	private int codigo;
	private Equipo equipo;
	private Solicitud solicitud;
	private Date fecha;
	private String descripcion;

	public Servicio() {
	}

	public Servicio(int codigo) {
		this.codigo = codigo;
	}

	public Servicio(int codigo, Equipo equipo, Solicitud solicitud, Date fecha, String descripcion) {
		this.codigo = codigo;
		this.equipo = equipo;
		this.solicitud = solicitud;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Solicitud getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
