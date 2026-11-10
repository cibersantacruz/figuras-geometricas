public class Triangulo extends Figura{

    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        super("Triangulo", 3);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        calcularArea();
        calcularPerimetro();
    }


    public static boolean esValido(double a, double b, double c){
        return a + b > c && a + c > b && b + c > a;
    }

    @Override
    public double calcularArea(){
        double s = (lado1 + lado2 + lado3) / 2;
        area = Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
        return area;
    }

    @Override
    public double calcularPerimetro(){
        perimetro = lado1 + lado2 + lado3;
        return perimetro;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    @Override
    public String getDatos(){
        return "Lados: " + lado1 + ", " + lado2 + ", " + lado3;
    }

    @Override
    public String toString(){
        return "Triangulo Lados: " + lado1 + ", " + lado2 + ", " + lado3 +
                " Area: " + String.format("%.2f", area) +
                " Perimetro: " + String.format("%.2f", perimetro) + "\n";
    }
}
