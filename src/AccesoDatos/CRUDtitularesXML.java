package AccesoDatos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import modelo.Titular;
import modelo.Titulares;
/**
 * @author John Hilasaca
 * @code 6608
 */

public class CRUDtitularesXML {
    private final Scanner input=new Scanner(System.in);
    public CRUDtitularesXML(){
    
    }
    
    public void agregarTitular() throws JAXBException, IOException{
        Titular titular = new Titular();
        titular.leer();
        JAXBContext contexto = JAXBContext.newInstance(Titulares.class);
        ArrayList<Titular> titulares = new ArrayList<>();
        try{
            Unmarshaller objeto = contexto.createUnmarshaller();
            Titulares objetoTitular = (Titulares)objeto.unmarshal(new File("Titular.xml"));
            titulares = objetoTitular.getTitulares();
            titulares.add(titular);
            objetoTitular.setTitulares(titulares);
            Marshaller mars = contexto.createMarshaller();
            mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mars.marshal(objetoTitular, new FileWriter("Titular.xml"));
        }catch(IOException | JAXBException e){
            titulares.add(titular);
            Titulares objetoTitular = new Titulares();
            objetoTitular.setTitulares(titulares);
            Marshaller mars = contexto.createMarshaller();
            mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mars.marshal(objetoTitular, new FileWriter("Titular.xml"));
        }
        System.out.println("Titular registrado correctamente");
    }
    
    public int buscar(String cedula) throws JAXBException{
        int posicion = -1;
        JAXBContext contexto = JAXBContext.newInstance(Titulares.class);
        ArrayList<Titular>cAT;
        try{
            Unmarshaller objeto=contexto.createUnmarshaller();
            Titulares oTR=(Titulares)objeto.unmarshal(new File("Titular.xml"));
            cAT=oTR.getTitulares();
            for(int i=0;i<cAT.size();i++){
                Titular cT;
                cT = cAT.get(i);
                if(cedula.equals(cT.getCedula())){
                    posicion=i;
                    break;
                }
            }
        }catch(JAXBException e){
            posicion = -1;
        }
        return posicion;
    }
    
    
    public void listarTitular() throws JAXBException, IOException{
        System.out.println("Titular");
        JAXBContext contexto = JAXBContext.newInstance(Titulares.class);
        ArrayList<Titular>cAT;
        try{
            Unmarshaller objeto=contexto.createUnmarshaller();
            Titulares oTR=(Titulares)objeto.unmarshal(new File("Titular.xml"));
            cAT=oTR.getTitulares();
            for(int i=0;i<cAT.size();i++){
                System.out.println(cAT.get(i));
            }
        }catch(JAXBException e){
            System.out.println("No existen titulares registrados");
        }
    }
    
    
    public void modificarTitular() throws JAXBException, IOException{
        int posicion;
        System.out.print("Ingrese cedula para modificar: ");
        posicion=buscar(input.next());
        JAXBContext contexto=JAXBContext.newInstance(Titulares.class);
        ArrayList<Titular>cAT;
        if(posicion>=0){
            Unmarshaller objeto=contexto.createUnmarshaller();
            Titulares oTR=(Titulares)objeto.unmarshal(new File("Titular.xml"));
            cAT=oTR.getTitulares();
            System.out.println("Titular: "+cAT.get(posicion));
            System.out.println("Modificar titular: ");
            Titular oT=new Titular();
            oT.leer();
            cAT.set(posicion, oT);
            oTR.setTitulares(cAT);
            Marshaller mars=contexto.createMarshaller();
            mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mars.marshal(oTR, new FileWriter("Titular.xml"));
            System.out.println("Titular modificado correctamente");
        }
        else
            System.out.println("El titular no existe");
    }
    
    
    public void eliminarTitular() throws JAXBException, IOException{
        int posicion;
        System.out.print("Ingrese cedula para eliminar: ");
        posicion=buscar(input.next());
        JAXBContext contexto=JAXBContext.newInstance(Titulares.class);
        ArrayList<Titular>cAT;
        if(posicion>=0){
            Unmarshaller objeto=contexto.createUnmarshaller();
            Titulares oTR=(Titulares)objeto.unmarshal(new File("Titular.xml"));
            cAT=oTR.getTitulares();
            System.out.println("Titular: "+cAT.get(posicion));
            cAT.remove(posicion);
            oTR.setTitulares(cAT);
            Marshaller mars=contexto.createMarshaller();
            mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mars.marshal(oTR, new FileWriter("Titular.xml"));
            System.out.println("El titular se elimino correctamente");
        }
        else
            System.out.println("El titular no existe");
    }
    
    
    public void buscarTitular() throws JAXBException{
        System.out.print("Ingrese cedula a buscar: ");
        int posicion;
        posicion=buscar(input.next());
        JAXBContext contexto=JAXBContext.newInstance(Titulares.class);
        ArrayList<Titular>cAT;
        if(posicion>=0){
            Unmarshaller objeto=contexto.createUnmarshaller();
            Titulares oTR=(Titulares)objeto.unmarshal(new File("Titular.xml"));
            cAT=oTR.getTitulares();
            System.out.println("Titular: "+cAT.get(posicion));
        }
        else
            System.out.println("El titular no existe");
    }
    
}
