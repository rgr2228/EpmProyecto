package co.edu.udea.epm.rest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.epm.bl.ContratoBL;
import co.edu.udea.epm.dto.Contrato;
import co.edu.udea.epm.exception.EpmDaoException;

@Path("Contrato")
@Component
public class ServicioContrato {
	
	@Autowired
	private ContratoBL contratoBL;

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@POST
	public List<Contrato> obtenerContratos()throws RemoteException{
		List<Contrato> contratos = null;
		try {
			contratos = new ArrayList<Contrato>();
			contratos = contratoBL.obtenerContratos();
		}catch(EpmDaoException e) {
			throw new RemoteException(e.getMessage());
		}
		return contratos;
	}
	
}
