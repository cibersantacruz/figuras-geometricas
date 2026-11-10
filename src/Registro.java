import java.util.ArrayList;
import java.util.List;

public class Registro {

    private List<Figura> figuras = new ArrayList<>();

    public void crearFigura(Figura figura){
        figuras.add(figura);
    }

    public List<Figura> getFiguras() {
        return figuras;
    }

    @Override
    public String toString(){
        String texto = "";
        for (Figura f : figuras){
            texto += f;
        }
        return texto;
    }
}
