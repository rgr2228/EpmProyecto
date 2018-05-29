package co.edu.udea.epm.bl;

import java.util.List;

import co.edu.udea.epm.dto.Contrato;
import co.edu.udea.epm.exception.EpmDaoException;

public interface ContratoBL {

	public List<Contrato> obtenerContratos() throws EpmDaoException;
	
}
