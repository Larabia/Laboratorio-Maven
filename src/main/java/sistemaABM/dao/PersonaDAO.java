package sistemaABM.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import sistemaABM.entity.PersonaEntity;
import sistemaABM.service.SistemaABMUtil;

public class PersonaDAO {

	public static void saveOrUpdatePersona(PersonaEntity per) {

		Session session = SistemaABMUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(per);
		session.getTransaction().commit();
		SistemaABMUtil.shutdown();

	}

	public static void deletePersona(PersonaEntity per) {

		Session session = SistemaABMUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(per);
		session.getTransaction().commit();
		SistemaABMUtil.shutdown();

	}

	public static PersonaEntity getPerXid(int id) {

		Session session = SistemaABMUtil.getSessionFactory().openSession();
		session.beginTransaction();
		PersonaEntity per = (PersonaEntity) session.get(PersonaEntity.class, id);
		SistemaABMUtil.shutdown();
		return per;

	}
	
	public static List getPerXnombre(String busqueda) {

		Session session = SistemaABMUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(PersonaEntity.class);
		cr.add(Restrictions.like("nombre", busqueda +"%"));
		List results = cr.list();
		SistemaABMUtil.shutdown();
		return results;

	}


	public static List<PersonaEntity> getAllPersona() {
		Session session = SistemaABMUtil.getSessionFactory().openSession();	
		List<PersonaEntity> listadoPer = new ArrayList<PersonaEntity>();
		listadoPer = session.createQuery("From PersonaEntity").list();
		session.close();
		SistemaABMUtil.shutdown();
		return listadoPer;
	}

}