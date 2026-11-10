public class Circulo extends Figura{

    private double radio;
    private double diametro;

    public Circulo(double radio) {
        super("Circulo", 0);
        this.radio = radio;
        calcularArea();
        calcularPerimetro();
    }

    public double calcularDiametro(){
        diametro = 2 * radio;
        return diametro;
    }

    @Override
    public double calcularArea(){
        area = Math.PI * Math.pow(radio,2);
        return area;
    }

    @Override
    public double calcularPerimetro(){
        perimetro = 2 * Math.PI * radio;
        return perimetro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getDiametro() {
        return diametro;
    }

    @Override
    public String getDatos(){
        return "Radio: " + radio;
    }

    @Override
    public String toString(){
        return "Circulo Radio: " + radio +
                " Diametro: " + String.format("%.2f", calcularDiametro()) +
                " Area: " + String.format("%.2f", area) +
                " Perimetro: " + String.format("%.2f", perimetro) + "\n";
    }
}
