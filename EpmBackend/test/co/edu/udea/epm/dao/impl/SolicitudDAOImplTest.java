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

import co.edu.udea.epm.dao.SolicitudDAO;
import co.edu.udea.epm.dto.Empleado;
import co.edu.udea.epm.dto.Sector;
import co.edu.udea.epm.dto.Solicitud;
import co.edu.udea.epm.dto.TipoEmpleado;
import co.edu.udea.epm.dto.Usuario;
import co.edu.udea.epm.exception.EpmDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.cfg.xml")
@Transactional
public class SolicitudDAOImplTest {

	@Autowired
	private SolicitudDAO solicitudDAO;
	
	@Test
	public void testObtenerSolicitudes() {
		List<Solicitud> solicitudes = null;
		try{
			solicitudes = new ArrayList<Solicitud>();
			solicitudes = solicitudDAO.obtenerSolicitudes();
			assertTrue(solicitudes.size()>0);	
		}catch(EpmDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testObtenerPorSector() {
		List<Solicitud> solicitudes = null;
		Sector sector = null;
		try{
			sector = new Sector(1, "Castilla", "Medellín");
			solicitudes = new ArrayList<Solicitud>();
			solicitudes = solicitudDAO.obtenerPorSector(sector);
			assertTrue(solicitudes.size()>0);	
		}catch(EpmDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerPorEstado() {
		List<Solicitud> solicitudes = null;
		try{
			solicitudes = new ArrayList<Solicitud>();
			solicitudes = solicitudDAO.obtenerPorEstado("En curso");
			assertTrue(solicitudes.size()>0);	
		}catch(EpmDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testObtenerPorUsuario() {
		List<Solicitud> solicitudes = null;
		try{
			solicitudes = new ArrayList<Solicitud>();
			solicitudes = solicitudDAO.obtenerPorUsuario(new Usuario(1,"rgr2228@gmail.com","12345"));
			assertTrue(solicitudes.size()>0);	
		}catch(EpmDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testObtenerPorCodigo() {
		Solicitud solicitud = null;
		try{
			solicitud = solicitudDAO.obtenerPorCodigo(1);
			assertNotNull(solicitud);
		}catch(EpmDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCrearSolicitud() {
		Solicitud solicitud = null;
		try{
			solicitud = new Solicitud(new Sector(1,"Castilla","Medellín"), new Usuario(1, "rgr2228@gmail.com", "12345"), 
					"En curso", "Eléctrico", '1', "Se incendió la cocina");
			solicitudDAO.crearSolicitud(solicitud);
		}catch(EpmDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testModificarSolicitud() {
		Solicitud solicitud = null;
		try{
			solicitud = new Solicitud(new Sector(1,"Castilla","Medell�n"), new Usuario(1, "rgr2228@gmail.com", "12345"), 
					"En curso", "El�ctrico", '1', "Se incendi� la cocina");
			solicitud.setCalificacion("Excelente");
			solicitudDAO.modificarSolicitud(solicitud);
		}catch(EpmDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
}
