
package modelo;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author John Hilasaca
 * @code 6608
 */
@XmlRootElement(name="Titulares")
public class Titulares {
    private ArrayList<Titular> titulares = null; 
    
    public Titulares(){ }

    public void setTitulares(ArrayList<Titular> titulares) {
        this.titulares = titulares;
    }

    @XmlElement(name="Titular")
    public ArrayList<Titular> getTitulares() {
        return titulares;
    }
    
    
}
