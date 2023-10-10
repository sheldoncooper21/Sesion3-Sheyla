package pkg;
import java.util.ArrayList;
import java.util.List;


public class Cuenta {

	 private String mNumero; 
     private String nTitular; 
     private double saldo;
     private List <Movimiento> mMovimientos;
     
     public Cuenta(String numero, double saldoInicial) {
         this.mNumero = numero;
         this.saldo = saldoInicial;
         this.mMovimientos = new ArrayList<>();
     }

     public void ingresar(double x) {
         saldo=saldo + x; //aumentamos el saldo actual
         Movimiento movimiento = new Movimiento(x, "Ingreso"); //registramos el movimiento
         mMovimientos.add(movimiento); //añadimos a la lista
     }
     
     public boolean retirar(double x) {
        
    	 if (saldo - x >= -500) { //Si la condición se cumple, significa que la cuenta tiene suficiente saldo para permitir el retiro sin exceder el límite de descubierto de 500 euros
    		 saldo -= x;
    		 Movimiento movimiento = new Movimiento(x, "Reintegro");
    		 mMovimientos.add(movimiento);
    		 return true;
    	 } else {
    		 return false; // Fondos insuficientes
    	 }
     }

     public double getSaldo() {
         return this.saldo;
     }

	public void setSaldo(int i) {
		this.saldo = i;
	}


}
