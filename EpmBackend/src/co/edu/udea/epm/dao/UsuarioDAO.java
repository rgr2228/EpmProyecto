package co.edu.udea.epm.dao;

import java.util.List;

import co.edu.udea.epm.dto.Usuario;
import co.edu.udea.epm.exception.EpmDaoException;

public interface UsuarioDAO {

	public Usuario crearUsuario(Usuario usuario) throws EpmDaoException;
	public List<Usuario> obtenerUsuarios() throws EpmDaoException;
	public Usuario obtenerPorEmail(String email) throws EpmDaoException;
}
