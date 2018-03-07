package co.edu.javeriana.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import co.edu.javeriana.Persistencia_Biblioteca.dao.LibroDAO;
import co.edu.javeriana.Persistencia_Biblioteca.dao.SessionHandler;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLibro {
	LibroDAO dao;

	@Before
	public void setUp() throws Exception {
		dao = LibroDAO.getInstance();
		dao.setFactory(SessionHandler.getInstance().getFactory());
	}

	@Test
	public void testAInsertar() {
		boolean result = dao.insertarLibro("nuevo libro", "123", "yo, yo");
		assertTrue(result);
	}
	
	@Test
	public void testBActualizar() {
		boolean result = dao.actualizarLibro("123", "nuevo libro act", "yo");
		assertTrue(result);
	}
	
	@Ignore
	@Test
	public void testCeliminar() {
		boolean result = dao.eliminarLibro("123");
		assertTrue(result);
	}
}
