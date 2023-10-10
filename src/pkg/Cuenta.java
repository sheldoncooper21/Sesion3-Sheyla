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
        
    	 if(saldo-x <500) {
    		 return false;
    	 }else {
    		 return true;
    	 }
     }

     public double getSaldo() {
         return saldo;
     }


}
