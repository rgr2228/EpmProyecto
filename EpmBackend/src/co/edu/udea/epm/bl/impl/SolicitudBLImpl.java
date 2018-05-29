package co.edu.udea.epm.bl.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.epm.bl.SolicitudBL;
import co.edu.udea.epm.dao.SectorDAO;
import co.edu.udea.epm.dao.SolicitudDAO;
import co.edu.udea.epm.dto.Sector;
import co.edu.udea.epm.dto.Solicitud;
import co.edu.udea.epm.exception.EpmDaoException;
import co.edu.udea.epm.validaciones.Validaciones;

@Transactional
public class SolicitudBLImpl implements SolicitudBL {

	@Autowired
	private SolicitudDAO solicitudDAO;
	
	@Autowired
	private SectorDAO sectorDAO;
	
	@Override
	public List<Solicitud> obtenerPorSector(String sector) throws EpmDaoException {
		List<Solicitud> solicitudes = null;
		Sector sector1 = null;
		if(Validaciones.isTextoVacio(sector)){
			throw new EpmDaoException("El sector no puede estar vacío");
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

}
