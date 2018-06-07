package co.edu.udea.epm.bl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.epm.bl.UsuarioBL;
import co.edu.udea.epm.dao.UsuarioDAO;
import co.edu.udea.epm.dto.Usuario;
import co.edu.udea.epm.exception.EpmDaoException;
import co.edu.udea.epm.validaciones.Validaciones;

@Transactional
public class UsuarioBLImpl implements UsuarioBL {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	private final String MENSAJE_AUTENTICA = "Usuario y/o contraseña inválida";
	
	@Override
	public Usuario crearUsuario(String documento, String nombre, String direccion, String telefono, String email,
			String password) throws EpmDaoException {
		Usuario usuario = null;
		if(!Validaciones.isEmail(email)) {
			throw new EpmDaoException("El email debe tener el formato correcto");
		}
		usuario = usuarioDAO.obtenerPorEmail(email);
		if(usuario != null){
			throw new EpmDaoException("Usuario ya existente en el sistema");
		}
		if(Validaciones.isTextoVacio(documento)){
			throw new EpmDaoException("El documento no puede estar vacío");
		}
		usuario = usuarioDAO.obtenerPorDocumento(Integer.valueOf(documento));
		if(usuario != null){
			throw new EpmDaoException("Usuario ya existente en el sistema");
		}
		if(Validaciones.isTextoVacio(direccion)){
			throw new EpmDaoException("La dirección no puede estar vacía");
		}
		if(Validaciones.isTextoVacio(telefono)){
			throw new EpmDaoException("El teléfono no puede estar vacío");
		}
		if(Validaciones.isTextoVacio(password)){
			throw new EpmDaoException("La contraseña no puede estar vacía");
		}
		usuario = new Usuario(Integer.valueOf(documento), nombre, direccion, telefono, email, password);
		return usuarioDAO.crearUsuario(usuario);
	}

	@Override
	public Usuario login(String documento, String password) throws EpmDaoException {
		Usuario usuario = null;
		if(Validaciones.isTextoVacio(documento)) {
			throw new EpmDaoException(MENSAJE_AUTENTICA);
		}
		usuario = usuarioDAO.obtenerPorDocumento(Integer.valueOf(documento));
		if(usuario == null){
			throw new EpmDaoException(MENSAJE_AUTENTICA);
		}
		if(!usuario.getPassword().equals(password)){
			throw new EpmDaoException(MENSAJE_AUTENTICA);
		}
		return usuario;
	}

	@Override
	public List<Usuario> obtenerUsuarios() throws EpmDaoException {
		return usuarioDAO.obtenerUsuarios();
	}

	@Override
	public Usuario obtenerPorEmail(String email) throws EpmDaoException {
		Usuario usuario = null;
		if(!Validaciones.isEmail(email)){
			throw new EpmDaoException("Email no válido");
		}
		if(Validaciones.isTextoVacio(email)){
			throw new EpmDaoException("El email no puede estar vacío");
		}
		usuario = usuarioDAO.obtenerPorEmail(email);
		if(usuario == null){
			throw new EpmDaoException("Usuario no encontrado");
		}
		return usuario;
	}

	@Override
	public Usuario obtenerPorDocumento(String documento) throws EpmDaoException {
		Usuario usuario = null;
		if(Validaciones.isTextoVacio(documento)){
			throw new EpmDaoException("El documento no puede estar vacío");
		}
		usuario = usuarioDAO.obtenerPorDocumento(Integer.valueOf(documento));
		if(usuario == null){
			throw new EpmDaoException("Usuario no encontrado");
		}
		return usuario;
	}
}
