package co.edu.udea.epm.dao;

import java.util.List;

import co.edu.udea.epm.dto.Sector;
import co.edu.udea.epm.dto.Solicitud;
import co.edu.udea.epm.dto.Usuario;
import co.edu.udea.epm.exception.EpmDaoException;

public interface SolicitudDAO {
	
	public Solicitud obtenerPorCodigo(int codigo)throws EpmDaoException;
	public List<Solicitud> obtenerPorSector(Sector sector)throws EpmDaoException;
	public List<Solicitud> obtenerSolicitudes() throws EpmDaoException;
	public List<Solicitud> obtenerPorEstado(String estado)throws EpmDaoException;
	public List<Solicitud> obtenerPorUsuario(Usuario usuario) throws EpmDaoException;
	public Solicitud crearSolicitud(Solicitud solicitud) throws EpmDaoException;
	public Solicitud modificarSolicitud(Solicitud solicitud) throws EpmDaoException;
}
