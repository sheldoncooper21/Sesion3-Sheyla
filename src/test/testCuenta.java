package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import pkg.Cuenta;

class testCuenta {
	
	private Cuenta cuenta12345;
    private Cuenta cuenta67890;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cuenta12345 = new Cuenta("12345", 50);
        cuenta67890 = new Cuenta("67890", 0);
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
		 boolean resultado1 = cuenta12345.retirar(200);
		 assertFalse(resultado1); // Debe devolver false ya que no hay saldo suficiente(50€)

		 boolean resultado2 = cuenta67890.retirar(350);
		 assertFalse(resultado2); // Debe devolver false ya que no hay saldo suficiente (0€)
	}
	

}
