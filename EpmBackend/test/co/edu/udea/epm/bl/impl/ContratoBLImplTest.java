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

import co.edu.udea.epm.bl.ContratoBL;
import co.edu.udea.epm.dto.Contrato;
import co.edu.udea.epm.exception.EpmDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.cfg.xml")
@Transactional
public class ContratoBLImplTest {

	@Autowired
	private ContratoBL contratoBL;
	
	@Test
	public void testObtenerContratos() {
		List<Contrato> contratos = null;
		try{
			contratos = new ArrayList<Contrato>();
			contratos = contratoBL.obtenerContratos();
			assertTrue(contratos.size()>0);
		}
		catch(EpmDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
