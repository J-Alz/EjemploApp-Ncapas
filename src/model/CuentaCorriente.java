package modelo;

import java.util.Scanner;
/**
 * @author John Hilasaca
 * @code 6608
 */

public class CuentaCorriente extends Cuenta {
    private float costoMantenimiento;

    public CuentaCorriente(){
    }
    
    public float getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(float costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }
    
    @Override
    public void leer(){
        Scanner input = new Scanner(System.in);
        super.leer();
        System.out.print("Costo de mantenimiento: ");
        setCostoMantenimiento(input.nextFloat());
    } 

    @Override
    public String toString(){
        return super.toString()+ " Corriente {Costo Mantenimiento = "+ costoMantenimiento + ")";
    }

    @Override
    public void calcularValoresFinales() {
        this.setSaldoInicial(this.getSaldoInicial() - this.getCostoMantenimiento());
    }
}

