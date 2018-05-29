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

import co.edu.udea.epm.bl.UsuarioBL;
import co.edu.udea.epm.dto.Usuario;
import co.edu.udea.epm.exception.EpmDaoException;

@Path("Usuario")
@Component
public class ServicioUsuario {
	
	@Autowired
	private UsuarioBL usuarioBL;
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@POST
	@Path("/crear")
	public Usuario crearUsuario(
			@QueryParam("documento")String documento,@QueryParam("nombre")String nombre,@QueryParam("direccion")String direccion,
			@QueryParam("telefono")String telefono,@QueryParam("email")String email,@QueryParam("password")String password)throws RemoteException{
			Usuario usuario = null;
		try{
			usuario = usuarioBL.crearUsuario(documento, nombre, direccion, telefono, email, password);
		}catch(EpmDaoException e){
			throw new RemoteException(e.getMessage());
		}
		return usuario;
	}
	
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Usuario login(@QueryParam("email")String email,@QueryParam("password")String password)throws RemoteException{
		Usuario usuario = null;
		try{
			usuario = usuarioBL.login(email, password);
		}catch(EpmDaoException e){
			throw new RemoteException(e.getMessage());
		}
		return usuario;
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@POST
	public List<Usuario> obtenerUsuarios()throws RemoteException{
		List<Usuario> usuarios = null;
		try {
			usuarios = new ArrayList<Usuario>();
			usuarios =usuarioBL.obtenerUsuarios();
		}catch(EpmDaoException e) {
			throw new RemoteException(e.getMessage());
		}
		return usuarios;
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@POST
	@Path("/email")
	public Usuario obtenerPorEmail(@QueryParam("email")String email)throws RemoteException{
		Usuario usuario = null;
		try {
			usuario = usuarioBL.obtenerPorEmail(email);
		}catch(EpmDaoException e) {
			throw new RemoteException(e.getMessage());
		}
		return usuario;
	}
	
}
