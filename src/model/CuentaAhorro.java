package modelo;

import java.util.Scanner;
/**
 * @author John Hilasaca
 * @code 6608
 */
public class CuentaAhorro extends Cuenta {
    private float interes;

    public CuentaAhorro() {
    }

    public CuentaAhorro(float interes) {
        this.interes = interes;
    }

    public CuentaAhorro(float interes, String numero, Titular propietario, float saldoInicial) {
        super(numero, propietario, saldoInicial);
        this.interes = interes;
    }

    
    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }
    
    @Override
    public void leer(){
        super.leer();
        Scanner entrada=new Scanner(System.in);
        System.out.print("Interes: ");
        setInteres(entrada.nextInt());
    }
    
    @Override
    public String toString() {
        return super.toString() + " CAO {" + "Interes = " + interes + '}';
    }

    @Override
    public void calcularValoresFinales() {
        this.setSaldoInicial(this.getSaldoInicial()*(1+this.getInteres()/100));
    }
    
}
