package co.edu.udea.epm.bl;

import java.util.List;

import co.edu.udea.epm.dto.Usuario;
import co.edu.udea.epm.exception.EpmDaoException;

public interface UsuarioBL {

	public Usuario crearUsuario(String documento, String nombre, String direccion,
			String telefono, String email, String password) throws EpmDaoException;
	
	public Usuario login(String email, String password)throws EpmDaoException;
	
	public List<Usuario> obtenerUsuarios() throws EpmDaoException;
	
	public Usuario obtenerPorEmail(String email) throws EpmDaoException;
	
}
