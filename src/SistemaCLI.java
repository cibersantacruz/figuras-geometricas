import java.util.Scanner;

public class SistemaCLI {

    Registro registro = new Registro();
    Scanner sc;

    public SistemaCLI(){
        sc = new Scanner(System.in);
    }

    public void menu(){
        int opc, opc2;
        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1.Crear figura");
            System.out.println("2.Ver figuras");
            System.out.println(">>");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    crearFigura();
                    break;
                case 2:
                    System.out.println(registro);
                    break;
                default:
                    System.out.println("No existe la opcion");
                    break;
            }
            System.out.println("Desea seleccionar otra opcion 1.Si/2.No");
            opc2 = sc.nextInt();
        }while(opc2==1);
    }

    public void crearFigura(){
        System.out.println("Seleccione la figura a crear:");
        System.out.println("1.Circulo");
        System.out.println("2.Rectangulo");
        System.out.println("3.Triangulo");
        System.out.println(">> ");
        int tipo = sc.nextInt();
        Figura figura;
        switch (tipo) {
            case 1:
                System.out.println("Ingrese el radio: ");
                double radio = sc.nextDouble();
                if (radio <= 0) {
                    System.out.println("El radio debe ser positivo");
                    return;
                }
                figura = new Circulo(radio);
                break;
            case 2:
                System.out.println("Ingrese la base: ");
                double base = sc.nextDouble();
                System.out.println("Ingrese la altura: ");
                double altura = sc.nextDouble();
                if (base <= 0 || altura <= 0) {
                    System.out.println("La base y la altura deben ser positivas");
                    return;
                }
                figura = new Rectangulo(base, altura);
                break;
            case 3:
                System.out.println("Ingrese el lado 1: ");
                double l1 = sc.nextDouble();
                System.out.println("Ingrese el lado 2: ");
                double l2 = sc.nextDouble();
                System.out.println("Ingrese el lado 3: ");
                double l3 = sc.nextDouble();
                if (l1 <= 0 || l2 <= 0 || l3 <= 0 || !Triangulo.esValido(l1, l2, l3)) {
                    System.out.println("Los lados no forman un triangulo");
                    return;
                }
                figura = new Triangulo(l1, l2, l3);
                break;
            default:
                System.out.println("No existe la opcion");
                return;
        }
        registro.crearFigura(figura);
        System.out.println(figura);
    }

}
