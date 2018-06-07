package co.edu.udea.epm.bl.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.epm.bl.UsuarioBL;
import co.edu.udea.epm.dto.Usuario;
import co.edu.udea.epm.exception.EpmDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.cfg.xml")
@Transactional
public class UsuarioBLImplTest {
	
	@Autowired
	private UsuarioBL usuarioBL;
	
	@Test
	public void testCrearUsuario() {
		try{
			usuarioBL.crearUsuario("4", "Carolina", "Castilla", "5461234", "copito22@gmail.com","12345");
		}
		catch(EpmDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testLogin() {
		try{
			usuarioBL.login("1","12345");
		}
		catch(EpmDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerUsuarios() {
		List<Usuario> usuarios = null;
		try{
			usuarios = new ArrayList<Usuario>();
			usuarios = usuarioBL.obtenerUsuarios();
			assertTrue(usuarios.size()>0);
		}
		catch(EpmDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerPorEmail() {
		Usuario usuario = null;
		try{
			usuario = usuarioBL.obtenerPorEmail("rgr2228@gmail.com");
			assertNotNull(usuario);
		}
		catch(EpmDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerPorDocumento() {
		Usuario usuario = null;
		try{
			usuario = usuarioBL.obtenerPorDocumento("1");
			assertNotNull(usuario);
		}
		catch(EpmDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
}
