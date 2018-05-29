package co.edu.udea.epm.dao;

import java.util.List;

import co.edu.udea.epm.dto.Contrato;
import co.edu.udea.epm.exception.EpmDaoException;

public interface ContratoDAO {

	public List<Contrato> obtenerContratos() throws EpmDaoException;
}
