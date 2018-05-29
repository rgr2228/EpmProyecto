package co.edu.udea.epm.dto;
// Generated 27-may-2018 20:11:32 by Hibernate Tools 5.2.3.Final

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Contrato generated by hbm2java
 */
@XmlRootElement
public class Contrato implements java.io.Serializable {

	private int codigo;
	private Sector sector;
	private Usuario usuario;

	public Contrato() {
	}

	public Contrato(int codigo, Sector sector, Usuario usuario) {
		this.codigo = codigo;
		this.sector = sector;
		this.usuario = usuario;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Sector getSector() {
		return this.sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
