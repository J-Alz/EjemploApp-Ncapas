package modelo;

import java.util.Scanner;
/**
 * @author John Hilasaca
 * @code 6608
 */

public abstract class Cuenta {
    private String numero;
    private Titular propietario;
    private float saldoInicial;

    public Cuenta(){
    
    }

    public Cuenta(String numero, Titular propietario, float saldoInicial) {
        this.numero = numero;
        this.propietario = propietario;
        this.saldoInicial = saldoInicial;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPropietario(Titular propietario) {
        this.propietario = propietario;
    }

    public void setSaldoInicial(float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    public Titular getPropietario() {
        return propietario;
    }

    public float getSaldoInicial() {
        return saldoInicial;
    }
    
    public void leer(){
        Titular titular = new Titular();
        Scanner input = new Scanner(System.in);
        System.out.println("\nINGRESO (Datos cuenta bancaria)");
        System.out.print("Numero de cuenta: ");
        setNumero(input.nextLine());
        titular.leer();
        setPropietario(titular);
        System.out.print("Saldo inicial: ");
        setSaldoInicial(input.nextFloat());
    }
    
    public abstract void calcularValoresFinales();

    @Override
    public String toString() {
        return "Cuenta {" + "numero = " + numero + ", propietario = " + propietario.toString() + ", saldoInicial = " + saldoInicial + '}';
    }
    
    
    
}
