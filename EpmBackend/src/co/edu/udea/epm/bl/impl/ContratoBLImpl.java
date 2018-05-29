package co.edu.udea.epm.bl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.epm.bl.ContratoBL;
import co.edu.udea.epm.dao.ContratoDAO;
import co.edu.udea.epm.dto.Contrato;
import co.edu.udea.epm.exception.EpmDaoException;

@Transactional
public class ContratoBLImpl implements ContratoBL {

	@Autowired
	private ContratoDAO contratoDAO;
	
	@Override
	public List<Contrato> obtenerContratos() throws EpmDaoException {
		return contratoDAO.obtenerContratos();
	}
}
