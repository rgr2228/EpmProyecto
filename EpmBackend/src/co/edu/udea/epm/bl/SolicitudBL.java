package co.edu.udea.epm.bl;

import java.util.List;

import co.edu.udea.epm.dto.Sector;
import co.edu.udea.epm.dto.Solicitud;
import co.edu.udea.epm.exception.EpmDaoException;

public interface SolicitudBL {

	public List<Solicitud> obtenerPorSector(String sector)throws EpmDaoException;
	public List<Solicitud> obtenerSolicitudes() throws EpmDaoException;
	
}
