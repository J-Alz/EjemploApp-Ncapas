package view;

import AccesoDatos.Operaciones;
import AccesoDatos.CRUDtitularesXML;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.bind.JAXBException;
import modelo.Cuenta;

/**
 * @author John Hilasaca
 * @code 6608
 */

public class Cuentas {
    private final Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException, InterruptedException, JAXBException {
        Operaciones<Cuenta> oOperaciones = new Operaciones();
        Cuentas prog = new Cuentas(); 
        prog.menu(oOperaciones); 
    }
    
    public void menu(Operaciones<Cuenta> oOperaciones) throws JAXBException, IOException{
        int opcion;
        System.out.println(); 
        System.out.println("Gestión de cuentas bancarias"); 
        System.out.println("1. Cuenta de Ahorros"); 
        System.out.println("2. Cuenta  Corriente");
        System.out.println("3. Titulares");
        System.out.println("0. Salir ");
        do{
            System.out.print("\nOpcion: ");
            opcion = input.nextInt();
            if(opcion == 0){
                System.out.println("Hasta luego...");
                System.exit(opcion);
                break;
            } else if(opcion < 1 || opcion > 3){
                System.out.println("La opcion ingresada no es valida");
            }
        }while(opcion < 0 || opcion > 3);
        menuCuentasTitular(opcion);
    }
    
    public void menuCuentasTitular(int opTipo) throws JAXBException, IOException{
        Operaciones opera = new Operaciones();
        CRUDtitularesXML operaXml = new CRUDtitularesXML();
        int opcion;
        boolean salir = false;
        String tipo;
        
        tipo = switch (opTipo) {
            case 1 -> "Cuenta de Ahorros";
            case 2 -> "Cuenta Corriente";
            default -> "Titular";
        };
        try{
            System.out.println();
            System.out.println("Opciones de " + tipo); 
            System.out.println("1. Agregar " + tipo); 
            System.out.println("2. Modificar " + tipo);
            System.out.println("3. Buscar " + tipo);
            System.out.println("4. Eliminar " + tipo);
            System.out.println("5. Listar " + tipo);
            System.out.println("0. Regresar al menu principal");
            do{
                System.out.print("\nOpcion: ");
                opcion = input.nextInt();
                switch (opcion){
                    case 0 -> menu(opera);
                    case 1 -> {
                        if(opTipo == 1 || opTipo == 2)
                            opera.agregarCuenta(opTipo);
                        else
                            operaXml.agregarTitular();
                        salir = false;
                    }   
                    case 2 -> {
                        if(opTipo == 1 || opTipo == 2)
                            opera.modificarCuenta(opTipo);
                        else
                            operaXml.modificarTitular();
                        salir = false;
                    }
                    case 3 -> {
                        if(opTipo == 1 || opTipo == 2)
                            opera.buscarCuenta(opTipo);
                        else
                            operaXml.buscarTitular();
                        salir = false;
                    }
                    case 4 -> {
                        if(opTipo == 1 || opTipo == 2)
                            opera.eliminarCuenta(opTipo);
                        else
                            operaXml.eliminarTitular();
                        salir = false;
                    }
                    case 5 -> {
                        if(opTipo == 1 || opTipo == 2)
                            opera.listarCuenta(opTipo);
                        else
                            operaXml.listarTitular();
                        salir = false;
                    }
                }
            }while(!salir);
        } catch(IOException | JAXBException e){
            System.out.println("Ingrese solo numeros");
        }
    }
}