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

import co.edu.udea.epm.bl.SolicitudBL;
import co.edu.udea.epm.dto.Solicitud;
import co.edu.udea.epm.exception.EpmDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.cfg.xml")
@Transactional
public class SolicitudBLImplTest {
	
	@Autowired
	private SolicitudBL solicitudBL;
	
	@Test
	public void testObtenerPorSector() {
		List<Solicitud> solicitudes = null;
		try{
			solicitudes = new ArrayList<Solicitud>();
			solicitudes = solicitudBL.obtenerPorSector("Castilla");
			assertTrue(solicitudes.size()>0);
		}catch(EpmDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerSolicitudes() {
		List<Solicitud> solicitudes = null;
		try{
			solicitudes = new ArrayList<Solicitud>();
			solicitudes = solicitudBL.obtenerSolicitudes();
			assertTrue(solicitudes.size()>0);
		}
		catch(EpmDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
