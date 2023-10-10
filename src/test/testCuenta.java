package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import pkg.Cuenta;

class testCuenta {
	Cuenta ctaPruebas;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ctaPruebas.setSaldo(0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIngresar() {
		ctaPruebas.ingresar(3000);
		assertEquals(3000, ctaPruebas.getSaldo());
	}
	
	@Test
	void testRetirar() {
		ctaPruebas.retirar(2500);
		assertEquals(500, ctaPruebas.getSaldo());
	}
	
	@Test
	void testRetirarSinSaldo() {
		ctaPruebas.retirar(2500);
		assertEquals(0, ctaPruebas.getSaldo());
	}
	

}
