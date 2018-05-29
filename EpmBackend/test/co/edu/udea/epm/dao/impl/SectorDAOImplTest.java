package co.edu.udea.epm.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.epm.dao.SectorDAO;
import co.edu.udea.epm.dto.Sector;
import co.edu.udea.epm.exception.EpmDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.cfg.xml")
@Transactional
public class SectorDAOImplTest {

	@Autowired
	private SectorDAO sectorDAO;
	
	@Test
	public void testObtenerPorNombre() {
		Sector sector = null;
		try {
			sector = sectorDAO.obtenerPorNombre("Castilla");
			assertNotNull(sector);
		}catch(EpmDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
