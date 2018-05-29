package co.edu.udea.epm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.epm.dao.UsuarioDAO;
import co.edu.udea.epm.dto.Usuario;
import co.edu.udea.epm.exception.EpmDaoException;

public class UsuarioDAOImpl extends HibernateDaoSupport implements UsuarioDAO {

	@Override
	public Usuario crearUsuario(Usuario usuario) throws EpmDaoException {
		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();
			session.save(usuario);
		}catch(HibernateException e){
			throw new EpmDaoException(e);
		}
		
		return usuario;
	}

	@Override
	public List<Usuario> obtenerUsuarios() throws EpmDaoException {
		Session session = null;
		List<Usuario> usuarios = null;
		try{
			session = this.getSessionFactory().getCurrentSession();
			usuarios = new ArrayList<Usuario>();
			Criteria criteria =session.createCriteria(Usuario.class);
			usuarios = criteria.list();
		}catch(HibernateException e){
			throw new EpmDaoException(e);
		}
		return usuarios;
	}

	@Override
	public Usuario obtenerPorEmail(String email) throws EpmDaoException {
		Session session = null;
		Usuario usuario = null;
		try{
			session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from Usuario where email=:email");
			query.setParameter("email",email);
			usuario = (Usuario)query.uniqueResult();
		}catch(HibernateException e){
			throw new EpmDaoException(e);
		}
		return usuario;
	}
}
