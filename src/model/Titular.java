package modelo;

import java.util.Scanner;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Titular")
@XmlType(propOrder={"Cedula","Nombre"})
/**
 * @author John Hilasaca
 * @code 6608
 */

public class Titular {
    private String cedula;
    private String nombre;
    
    public Titular() {
        
    }

    public Titular(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @XmlElement(name="cedula")
    public String getCedula() {
        return cedula;
    }

    @XmlElement(name="nombre")
    public String getNombre() {
        return nombre;
    }
    
    public void leer(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nINGRESO (Datos de titular)");
        System.out.print("CI/RUC: ");
        setCedula(input.nextLine());
        System.out.print("Razón social: ");
        setNombre(input.nextLine());
        
    }

    @Override
    public String toString() {
        return "Titular {CI: " + cedula + ", Nombre: " + nombre + "}"; 
    }
}
