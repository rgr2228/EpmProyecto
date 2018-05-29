package co.edu.udea.epm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.epm.dao.SolicitudDAO;
import co.edu.udea.epm.dto.Sector;
import co.edu.udea.epm.dto.Solicitud;
import co.edu.udea.epm.dto.Usuario;
import co.edu.udea.epm.exception.EpmDaoException;


public class SolicitudDAOImpl extends HibernateDaoSupport implements SolicitudDAO {

	@Override
	public List<Solicitud> obtenerPorSector(Sector sector) throws EpmDaoException {
		Session session = null;
		List<Solicitud> solicitudes = null;
		try {
			solicitudes = new ArrayList<Solicitud>();
			session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from Solicitud where sector=:sector");
			query.setParameter("sector",sector);
			solicitudes = query.list();
		}catch(HibernateException e){
			throw new EpmDaoException(e);
		}
		return solicitudes;
	}

	@Override
	public List<Solicitud> obtenerSolicitudes() throws EpmDaoException {
		Session session = null;
		List<Solicitud> solicitudes = null;
		try{
			session = this.getSessionFactory().getCurrentSession();
			solicitudes = new ArrayList<Solicitud>();
			Criteria criteria =session.createCriteria(Solicitud.class);
			solicitudes = criteria.list();
		}catch(HibernateException e){
			throw new EpmDaoException(e);
		}
		return solicitudes;
	}
}
