package co.edu.udea.epm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.epm.dao.SectorDAO;
import co.edu.udea.epm.dto.Sector;
import co.edu.udea.epm.exception.EpmDaoException;

public class SectorDAOImpl extends HibernateDaoSupport implements SectorDAO {

	@Override
	public Sector obtenerPorNombre(String nombre) throws EpmDaoException {
		Session session = null;
		Sector sector = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from Sector where nombre=:nombre");
			query.setParameter("nombre",nombre);
			sector = (Sector) query.uniqueResult();
		}catch(HibernateException e){
			throw new EpmDaoException(e);
		}
		return sector;
	}

}
