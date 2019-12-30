
package pkgfinal;
import java.util.ArrayList;
public class Libro {
    String titulo,tipo,editorial,anio;
    ArrayList <Autor> x;

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", tipo=" + tipo + ", editorial=" + editorial + ", anio=" + anio + ", x=" + x + '}';
    }
 
    
}
