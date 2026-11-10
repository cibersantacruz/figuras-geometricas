public class Rectangulo extends Figura{

    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        super("Rectangulo", 4);
        this.base = base;
        this.altura = altura;
        calcularArea();
        calcularPerimetro();
    }

    @Override
    public double calcularArea(){
        area = base * altura;
        return area;
    }

    @Override
    public double calcularPerimetro(){
        perimetro = 2 * (base + altura);
        return perimetro;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String getDatos(){
        return "Base: " + base + "  Altura: " + altura;
    }

    @Override
    public String toString(){
        return "Rectangulo Base: " + base +
                " Altura: " + altura +
                " Area: " + String.format("%.2f", area) +
                " Perimetro: " + String.format("%.2f", perimetro) + "\n";
    }
}
