package AccesoDatos;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.CuentaAhorro;
import modelo.CuentaCorriente;
/**
 * @author John Hilasaca
 * @code 6608
 */

public class Operaciones<T> {
    private final Scanner input = new Scanner(System.in);
    private ArrayList<T> listaCuentas = new ArrayList<>();
    
    public Operaciones() {
    }
    
    public ArrayList<T> getLista() {
        return listaCuentas;
    }

    public void setLista(ArrayList<T> lista) {
        this.listaCuentas = lista;
    }
    
    public void agregarCuenta(int opcion){
        if(opcion == 1){
            CuentaAhorro cuentaAhorro = new CuentaAhorro();
            cuentaAhorro.leer();
            cuentaAhorro.calcularValoresFinales();
            listaCuentas.add((T) cuentaAhorro);
            System.out.println("\nUna cuenta de Ahorros ha sido creada...");
        } else if (opcion == 2){
            CuentaCorriente cuentaCorriente = new CuentaCorriente();
            cuentaCorriente.leer();
            cuentaCorriente.calcularValoresFinales();
            listaCuentas.add((T) cuentaCorriente);
            System.out.println("\nUna cuenta Corriente ha sido creada...");
        }
        
    }
    
    public int buscar(int opcion, String numeroCuenta){
        int posicion = -1;
        int indice = 0;
        if(opcion == 1){
            for (T cuenta : listaCuentas){
                if(cuenta instanceof CuentaAhorro){
                    CuentaAhorro cuentaAhorro;
                    cuentaAhorro = (CuentaAhorro) cuenta;
                    if(numeroCuenta.equals(cuentaAhorro.getNumero())){
                        posicion = indice;
                        break;
                    }
                }
                indice++;
            }
        } else if (opcion == 2){
            for (T cuenta : listaCuentas){
                if(cuenta instanceof CuentaCorriente){
                    CuentaCorriente cuentaCorriente;
                    cuentaCorriente = (CuentaCorriente) cuenta;
                    if(numeroCuenta.equals(cuentaCorriente.getNumero())){
                        posicion = indice;
                        break;
                    }
                }
                indice++;
            }
        }
        return posicion;
    }
    
    public void buscarCuenta(int opcion){
        int posicion;
        System.out.println("\nBUSQUEDA (Cuentas bancarias)");
        System.out.print("Ingrese numero de cuenta: ");
        posicion = buscar(opcion, input.nextLine());
        if(opcion == 1){
            if(posicion >= 0){ 
                System.out.println("La cuenta ha sido encontrada...");
                System.out.println(listaCuentas.get(posicion).toString());
            } else{
                System.out.println("La cuenta no existe...");
            }
        } else if (opcion == 2){
            if(posicion >= 0){
                System.out.println("La cuenta ha sido encontrada...");
                System.out.println(listaCuentas.get(posicion).toString());
            } else{
                System.out.println("La cuenta no existe...");
            }
        }
    }
    
    public void modificarCuenta(int opcion){
        int posicion;
        System.out.println("\nMODIFICACION (Cuentas Bancarias)");
        System.out.print("Ingrese numero de cuenta: ");
        
        posicion = buscar(opcion, input.nextLine());
        if(opcion == 1){
            if(posicion >= 0){
                CuentaAhorro cuentaAhorro = new CuentaAhorro();
                cuentaAhorro.leer();
                listaCuentas.set(posicion, (T) cuentaAhorro);
                System.out.println("La cuenta ha sido modificada...");
            }
            else{
                System.out.println("La cuenta no existe");
            }
        } else if (opcion == 2){
            if(posicion >= 0){
                CuentaCorriente cuentaCorriente = new CuentaCorriente();
                cuentaCorriente.leer();
                listaCuentas.set(posicion, (T) cuentaCorriente);
                System.out.println("La cuenta ha sido modificada...");
            }
            else{
                System.out.println("La cuenta no existe");
            }
        }
        
    }
    
    
    public void eliminarCuenta(int opcion){
        int posicion;
        System.out.println("\nELIMINACION (Cuenta Bancaria)");
        System.out.print("Ingrese el numero de cuenta: ");
        posicion = buscar(opcion, input.nextLine());
        
        if(posicion >= 0){
            System.out.println("Cuenta encontrada...");
            System.out.println(listaCuentas.get(posicion).toString());
            listaCuentas.remove(posicion);
            listarCuenta(opcion);
            System.out.println("La cuenta ha sido eliminada");
        } else{
            System.out.println("La cuenta no existe..."); 
        }
    }
    
    public void listarCuenta(int opcion){
        if(opcion == 1){
            System.out.println("****Datos de cuenta de ahorros****");
            for (T cuenta :listaCuentas){
                if(cuenta instanceof CuentaAhorro){
                    CuentaAhorro cuentaAhorro;
                    cuentaAhorro = (CuentaAhorro) cuenta;
                    System.out.println(cuentaAhorro.toString());
                }
            }
        } else if (opcion == 2){
            System.out.println("****Datos de cuenta corriente****");
            for (T cuenta :listaCuentas){
                if(cuenta instanceof CuentaCorriente){
                    CuentaCorriente cuentaCorriente;
                    cuentaCorriente = (CuentaCorriente) cuenta;
                    System.out.println(cuentaCorriente.toString());
                }
            }
        }
    }
    
}