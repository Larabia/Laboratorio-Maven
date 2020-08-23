package hibernateABM.test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import sistemaABM.dao.PersonaDAO;
import sistemaABM.entity.PersonaEntity;
import sistemaABM.service.DateUtil;
import sistemaABM.service.SistemaABMUtil;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	public void test1() {
		System.out.println("Test getAllPersona");
		List<PersonaEntity> list = PersonaDAO.getAllPersona();
		boolean tieneRegistros = list.size() > 0;
		assertTrue("No devuelve registros", tieneRegistros);
	}

	public void test2() {
		System.out.println("Test saveOrUpdatePersona, currentDate, calcularEdad");
		PersonaEntity perMock = new PersonaEntity();
		
		perMock.setNombre("TEST");
		perMock.setFechaNacimiento(DateUtil.currentDate());
		perMock.setEdad(SistemaABMUtil.calcularEdad(DateUtil.currentDate()));
		
		PersonaDAO.saveOrUpdatePersona(perMock);
		List<PersonaEntity> list = PersonaDAO.getPerXnombre("TEST");
		
		boolean PersonaTESTregistrada = list.size() > 0;
		PersonaDAO.deletePersona(perMock);

		assertTrue("No devuelve registros", PersonaTESTregistrada);
	}

	public void test3() throws ParseException {
		System.out.println("delete, formatParse, getPerXid");
		List<PersonaEntity> list = PersonaDAO.getAllPersona();
		int listaSinMock = list.size();
		
		PersonaEntity perMock = new PersonaEntity();
		String fechaString = "17/06/1986";
		Date fechaDate = DateUtil.formatParse(DateUtil.PATTERN_D2_M2_Y4, fechaString);

		perMock.setNombre("TEST");
		perMock.setFechaNacimiento(fechaDate);
		perMock.setEdad(SistemaABMUtil.calcularEdad(fechaDate));
		
		PersonaDAO.saveOrUpdatePersona(perMock);
		
		int id = perMock.getId();
		
		List<PersonaEntity> list2 = PersonaDAO.getAllPersona();
		int listaMasMock = list.size();
			
		PersonaDAO.deletePersona(PersonaDAO.getPerXid(id));
		
		List<PersonaEntity> list3 = PersonaDAO.getAllPersona();
		int listaMenosMock = list.size();
		
		assertTrue(listaSinMock == listaMenosMock);
	}
}
