package sistemaABM.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import sistemaABM.entity.PersonaEntity;
import sistemaABM.entity.VentasEntity;
import sistemaABM.service.SistemaABMUtil;

public class VentasDAO {

	public static void saveOrUpdateVenta(VentasEntity venta) {

		Session session = SistemaABMUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(venta);
		session.getTransaction().commit();
		SistemaABMUtil.shutdown();

	}
	
	public static List<VentasEntity> getAllVentas() {
		Session session = SistemaABMUtil.getSessionFactory().openSession();	
		List<VentasEntity> listadoVentas = new ArrayList<VentasEntity>();
		listadoVentas = session.createQuery("From VentasEntity").list();
		session.close();
		SistemaABMUtil.shutdown();
		return listadoVentas;
	}
}
