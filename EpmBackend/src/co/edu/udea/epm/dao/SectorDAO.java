package co.edu.udea.epm.dao;

import co.edu.udea.epm.dto.Sector;
import co.edu.udea.epm.exception.EpmDaoException;

public interface SectorDAO {

	public Sector obtenerPorNombre(String nombre)throws EpmDaoException;
	
}
