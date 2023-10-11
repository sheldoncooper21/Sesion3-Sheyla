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
		 cuenta12345.ingresar(100);
		 assertEquals(150, cuenta12345.getSaldo()); // El saldo debe ser 150€ después del ingreso de 100€
	}
	
	@Test
	void testRetirarConSaldoSuficiente() {
	    boolean resultado = cuenta12345.retirar(25);
	    assertTrue(resultado);
	    assertEquals(25, cuenta12345.getSaldo()); // El saldo debe ser 25€ después del retiro
	}
	
	@Test
	void testRetirarExcedeLimiteDescubierto() {
	    boolean resultado = cuenta12345.retirar(600);
	    assertFalse(resultado); 
	    assertEquals(50, cuenta12345.getSaldo()); // El saldo debe permanecer en 50€
	}
	
	@Test
	void testIngresarEnCuentaConSaldoNegativo() {
	    cuenta67890.ingresar(100);
	    assertEquals(100, cuenta67890.getSaldo()); // El saldo debe ser 100€ después del ingreso
	}
	
	@Test
	void testMovimientosCuenta() {
	    cuenta12345.ingresar(200);
	    cuenta12345.retirar(150);
	    cuenta12345.ingresar(100);
	    List<Movimiento> movimientos = cuenta12345.getMovimientos();
	    assertEquals(3, movimientos.size()); // Deben existir 3 movimientos
	}

	
	@Test
	void testRetirarSinSaldo() {
		 boolean resultado1 = cuenta12345.retirar(200);
		 assertFalse(resultado1); // Debe devolver false ya que no hay saldo suficiente(50€)

		 boolean resultado2 = cuenta67890.retirar(350);
		 assertFalse(resultado2); // Debe devolver false ya que no hay saldo suficiente (0€)*/
	}
	
	@Test
	void testRetirarSinSaldoCuenta67890() {
	    boolean resultado = cuenta67890.retirar(100);
	    assertFalse(resultado); 
	    assertEquals(0, cuenta67890.getSaldo()); // El saldo debe permanecer en 0€
	}

	@Test
	void testRetirarConSaldoSuficienteCuenta67890() {
	    cuenta67890.ingresar(200);
	    boolean resultado = cuenta67890.retirar(100);
	    assertTrue(resultado); 
	    assertEquals(100, cuenta67890.getSaldo()); // El saldo debe ser 100€ después del retiro
	}
	

}
