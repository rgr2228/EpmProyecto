package co.edu.udea.epm.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.epm.dao.UsuarioDAO;
import co.edu.udea.epm.dto.Usuario;
import co.edu.udea.epm.exception.EpmDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.cfg.xml")
@Transactional
public class UsuarioDAOImplTest {

	@Autowired 
	private UsuarioDAO usuarioDAO;
	
	@Test
	public void testCrearUsuario() {
		Usuario usuario = null;
		try{
			usuario = new Usuario(1, "Raul","Plaza", "3133548430", "rgr2228@gmail.com","12345");
			usuarioDAO.crearUsuario(usuario);
		}catch(EpmDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerUsuarios() {
		List<Usuario> usuarios = null;
		try{
			usuarios = new ArrayList<Usuario>();
			usuarios = usuarioDAO.obtenerUsuarios();
			assertTrue(usuarios.size()>0);	
		}catch(EpmDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerPorEmail() {
		Usuario usuario = null;
		try {
			usuario = usuarioDAO.obtenerPorEmail("rgr2228@gmail.com");
			assertNotNull(usuario);
		}catch(EpmDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testObtenerPorDocumento(){
		Usuario usuario = null;
		try {
			usuario = usuarioDAO.obtenerPorDocumento(1);
			assertNotNull(usuario);
		}catch(EpmDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
