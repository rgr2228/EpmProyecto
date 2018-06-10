package co.edu.udea.epm.bl.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.epm.bl.SolicitudBL;
import co.edu.udea.epm.dao.SectorDAO;
import co.edu.udea.epm.dao.SolicitudDAO;
import co.edu.udea.epm.dao.UsuarioDAO;
import co.edu.udea.epm.dto.Sector;
import co.edu.udea.epm.dto.Solicitud;
import co.edu.udea.epm.dto.Usuario;
import co.edu.udea.epm.exception.EpmDaoException;
import co.edu.udea.epm.validaciones.Validaciones;

@Transactional
public class SolicitudBLImpl implements SolicitudBL {

	@Autowired
	private SolicitudDAO solicitudDAO;
	
	@Autowired
	private SectorDAO sectorDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public List<Solicitud> obtenerPorSector(String sector) throws EpmDaoException {
		List<Solicitud> solicitudes = null;
		Sector sector1 = null;
		if(Validaciones.isTextoVacio(sector)){
			throw new EpmDaoException("El sector no puede estar vac�o");
		}
		sector1 = sectorDAO.obtenerPorNombre(sector);
		if(sector1 == null){
			throw new EpmDaoException("Sector no encontrado");
		}
		solicitudes = new ArrayList<Solicitud>();
		solicitudes = solicitudDAO.obtenerPorSector(sector1);
		if(solicitudes == null){
			throw new EpmDaoException("Sector sin solicitudes");
		}
		return solicitudes;
	}

	@Override
	public List<Solicitud> obtenerSolicitudes() throws EpmDaoException {
		return solicitudDAO.obtenerSolicitudes();
	}

	@Override
	public List<Solicitud> obtenerPorEstado(String estado) throws EpmDaoException {
		List<Solicitud> solicitudes = null;
		if(Validaciones.isTextoVacio(estado)){
			throw new EpmDaoException("El estado no puede estar vac�o");
		}
		solicitudes = new ArrayList<Solicitud>();
		solicitudes = solicitudDAO.obtenerPorEstado(estado);
		if(solicitudes == null){
			throw new EpmDaoException("No se ha encontrado solicitudes con el estado ingresado");
		}
		return solicitudes;
	}	

	@Override
	public Solicitud crearSolicitud(String sector, String usuario, String estado, String tipoDaño, String prioridad,
			String descripcion) throws EpmDaoException {
		Solicitud solicitud = null;
		Sector sector1 = null;
		Usuario usuario1 = null;
		if(Validaciones.isTextoVacio(sector)){
			throw new EpmDaoException("El sector no puede estar vac�o");
		}
		sector1 = sectorDAO.obtenerPorNombre(sector);
		if(sector1==null){
			throw new EpmDaoException("Sector no encontrado");
		}
		if(Validaciones.isTextoVacio(usuario)){
			throw new EpmDaoException("El usuario no puede estar vac�o");
		}
		usuario1 = usuarioDAO.obtenerPorDocumento(Integer.valueOf(usuario));
		if(usuario1 ==null){
			throw new EpmDaoException("El usuario no v�lido");
		}
		if(Validaciones.isTextoVacio(estado)){
			throw new EpmDaoException("El estado no puede estar vac�o");
		}
		if(Validaciones.isTextoVacio(tipoDaño)){
			throw new EpmDaoException("El tipo de da�o no puede estar vac�o");
		}
		if(Validaciones.isTextoVacio(prioridad)){
			throw new EpmDaoException("La prioridad no puede estar vac�a");
		}
		if(Validaciones.isTextoVacio(descripcion)){
			throw new EpmDaoException("La descripcion no puede estar vac�a");
		}
		solicitud = new Solicitud(sector1, usuario1, estado, tipoDaño, prioridad.charAt(0), descripcion);
		return solicitudDAO.crearSolicitud(solicitud);
	}

	@Override
	public Solicitud calificarSolicitud(String codigo, String usuario, String calificacion) throws EpmDaoException {
		Solicitud solicitud = null;
		solicitud = solicitudDAO.obtenerPorCodigo(Integer.valueOf(codigo));
		if(solicitud == null){
			throw new EpmDaoException("Solicitud no v�lida");
		}
		if(!solicitud.getEstado().equals("Finalizada")){
			throw new EpmDaoException("La solicitud no se ha finalizado");
		}
		if(!usuario.equals(String.valueOf(solicitud.getUsuario().getDocumento()))){
			throw new EpmDaoException("Usuario no v�lido");
		}
		if(Validaciones.isTextoVacio(calificacion)){
			throw new EpmDaoException("La descripcion no puede estar vac�a");
		}
		solicitud.setCalificacion(calificacion);
		return solicitudDAO.modificarSolicitud(solicitud);
	}

	@Override
	public List<Solicitud> obtenerPorUsuario(String usuario) throws EpmDaoException {
		List<Solicitud> solicitudes = null;
		if(Validaciones.isTextoVacio(usuario)){
			throw new EpmDaoException("El usuario no puede estar vac�o");
		}
		Usuario usuario1 = usuarioDAO.obtenerPorDocumento(Integer.valueOf(usuario));
		if(usuario1 == null){
			throw new EpmDaoException("Usuario no encontrado");
		}
		solicitudes = new ArrayList<Solicitud>();
		solicitudes = solicitudDAO.obtenerPorUsuario(usuario1);
		if(solicitudes == null){
			throw new EpmDaoException("No se ha encontrado solicitudes con el usuario ingresado");
		}
		return solicitudes;
	}

	@Override
	public Solicitud ObtenerPorCodigo(String codigo) throws EpmDaoException {
		Solicitud solicitud = null;
		if(Validaciones.isTextoVacio(codigo)){
			throw new EpmDaoException("El c�digo no puede estar vac�o");
		}
		solicitud = solicitudDAO.obtenerPorCodigo(Integer.valueOf(codigo));
		if(solicitud == null){
			throw new EpmDaoException("El c�digo no corresponde a ninguna solicitud");
		}
		return solicitud;
	}
}
