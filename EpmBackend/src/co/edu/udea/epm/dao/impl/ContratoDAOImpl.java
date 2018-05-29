package co.edu.udea.epm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.epm.dao.ContratoDAO;
import co.edu.udea.epm.dto.Contrato;
import co.edu.udea.epm.exception.EpmDaoException;

public class ContratoDAOImpl extends HibernateDaoSupport implements ContratoDAO {

	@Override
	public List<Contrato> obtenerContratos() throws EpmDaoException {
		Session session = null;
		List<Contrato> contratos = null;
		try{
			session = this.getSessionFactory().getCurrentSession();
			contratos = new ArrayList<Contrato>();
			Criteria criteria =session.createCriteria(Contrato.class);
			contratos = criteria.list();
		}catch(HibernateException e){
			throw new EpmDaoException(e);
		}
		return contratos;
	}

}
