package co.edu.udea.epm.rest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.epm.bl.SolicitudBL;
import co.edu.udea.epm.dto.Solicitud;
import co.edu.udea.epm.exception.EpmDaoException;

@Path("Solicitud")
@Component
public class ServicioSolicitud {
	
	@Autowired
	private SolicitudBL solicitudBL;

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@POST
	@Path("/sector")
	public List<Solicitud> obtenerPorSector(@QueryParam("sector")String sector)throws RemoteException{
		List<Solicitud> solicitudes = null;
		try {
			solicitudes = new ArrayList<Solicitud>();
			solicitudes = solicitudBL.obtenerPorSector(sector);
		}catch(EpmDaoException e) {
			throw new RemoteException(e.getMessage());
		}
		return solicitudes;
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@GET
	public List<Solicitud> obtenerSolicitudes()throws RemoteException{
		List<Solicitud> solicitudes = null;
		try {
			solicitudes = new ArrayList<Solicitud>();
			solicitudes = solicitudBL.obtenerSolicitudes();
		}catch(EpmDaoException e) {
			throw new RemoteException(e.getMessage());
		}
		return solicitudes;
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@GET
	@Path("/crear")
	public Solicitud crearSolicitud(@QueryParam("sector")String sector,@QueryParam("usuario")String usuario,
			@QueryParam("estado")String estado,@QueryParam("tipoDano")String tipoDaño,
			@QueryParam("prioridad")String prioridad,@QueryParam("descripcion")String descripcion)throws RemoteException{
		Solicitud solicitud = null;
		try {
			solicitud = solicitudBL.crearSolicitud(sector, usuario, estado, tipoDaño, prioridad, descripcion);
		}catch(EpmDaoException e) {
			throw new RemoteException(e.getMessage());
		}
		return solicitud;
	}
	
}
