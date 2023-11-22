import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        boolean run = true;
        int opcion;
        Scanner scanner = new Scanner(System.in);

        while (run){

            System.out.println("Escoja una opcion:" +
                    "\n1. Escribir un libro." +
                    "\n2. Leer libros.");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    run = false;
                    break;
                default:
                    break;
            }
        }
    }
}