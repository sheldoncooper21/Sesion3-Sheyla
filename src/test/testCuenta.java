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
    void testRetirosEIngresos12345() {
        // Retirar 200 euros, saldo inicial 50
        boolean resultado1 = cuenta12345.retirar(200);
        assertEquals(-50, cuenta12345.getSaldo());

        // Ingresar 200 euros, saldo después del retiro -150
        cuenta12345.ingresar(200);
        assertEquals(50, cuenta12345.getSaldo());

        // Ingresar 100 euros, saldo después del ingreso 150
        cuenta12345.ingresar(100);
        assertEquals(150, cuenta12345.getSaldo());

        // Retirar 200 euros, saldo después del retiro -50
        boolean resultado2 = cuenta12345.retirar(200);
        assertTrue(resultado2);
        assertEquals(-50, cuenta12345.getSaldo());

        // Saldo final después de todas las operaciones -50 - 250
        boolean resultado3 = cuenta12345.retirar(250);
        assertTrue(resultado3);
        assertEquals(-300, cuenta12345.getSaldo());
    }
    
    @Test
    void testRetirosEIngresos67890() {
        // Reintegro de 350 euros, saldo inicial 0
        boolean resultado1 = cuenta67890.retirar(350);
        assertEquals(-50, cuenta67890.getSaldo());

        // Ingreso de 150 euros, saldo después del ingreso -350 + 150 = -200
        cuenta67890.ingresar(150);
        assertEquals(-200, cuenta67890.getSaldo());

        // Ingreso de 50 euros, saldo después del ingreso -200 + 50 = -150
        cuenta67890.ingresar(50);
        assertEquals(-150, cuenta67890.getSaldo());

        // Saldo final después de todas las operaciones -150
        boolean resultado2 = cuenta67890.retirar(200);
        assertTrue(resultado2);
        assertEquals(-350, cuenta67890.getSaldo());

        // Saldo final después de todas las operaciones -350 - 100
        boolean resultado3 = cuenta67890.retirar(100);
        assertTrue(resultado3);
        assertEquals(-450, cuenta67890.getSaldo());
    }

	 

	 

	
	

}
