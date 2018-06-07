package co.edu.udea.epm.bl;

import java.util.List;

import co.edu.udea.epm.dto.Sector;
import co.edu.udea.epm.dto.Solicitud;
import co.edu.udea.epm.exception.EpmDaoException;

public interface SolicitudBL {

	public List<Solicitud> obtenerPorSector(String sector)throws EpmDaoException;
	public List<Solicitud> obtenerSolicitudes() throws EpmDaoException;
	public List<Solicitud> obtenerPorEstado(String estado) throws EpmDaoException;
	public List<Solicitud> obtenerPorUsuario(String usuario) throws EpmDaoException;
	public Solicitud crearSolicitud(String sector, String usuario, String estado, String tipoDaño, String prioridad, String descripcion) throws EpmDaoException;
	public Solicitud calificarSolicitud(String codigo,String usuario, String calificacion)throws EpmDaoException;
	public Solicitud ObtenerPorCodigo(String codigo)throws EpmDaoException;
}
