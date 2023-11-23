import java.io.*;
import java.util.Scanner;

public class Biblioteca {
    private static final int MAX = 10;

    public static void main(String[] args) throws IOException {
        //Atributos
        boolean run = true;
        int opcion, cont = 0;
        long isbn;
        String titulo, autor;
        String path;

        Scanner scanner = new Scanner(System.in);

        File fichero = new File("C:\\Users\\usuario\\Desktop\\Fichero.dat");

        //Declaracion de DataOutputStream y DataInputStream
        FileOutputStream fileout = new FileOutputStream(fichero);
        DataOutputStream dataOS = new DataOutputStream(fileout);

        FileInputStream filein = new FileInputStream(fichero);
        DataInputStream dataIS = new DataInputStream(filein);

        //Biblioteca
        Libro[] biblioteca = new Libro[MAX];

        //Programa
        while (run){

            System.out.println("Escoja una opcion:" +
                    "\n1. Escribir un libro." +
                    "\n2. Leer libros." +
                    "\n3. Mostrar libros." +
                    "\n4. Salir.");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (cont < MAX) {
                        System.out.println("*******************************");
                        System.out.println("Escriba el ISBN:");
                        isbn =  scanner.nextInt();
                        scanner.nextLine(); //RC

                        System.out.println("Escriba el titulo:");
                        titulo = scanner.nextLine();

                        System.out.println("Escriba el autor:");
                        autor = scanner.nextLine();
                        System.out.println("*******************************");
                        biblioteca[cont] = new Libro(isbn, titulo, autor);
                        biblioteca[cont].grabarLibro(dataOS);
                        cont++;
                    } else
                        System.out.println("Capacidad maxima alcanzada");
                    break;
                case 2:
                    System.out.println("Escriba la ruta del fichero del cual leer:");
                    scanner.nextLine();
                    path = scanner.nextLine();

                    try {
                        File ficheroLectura = new File(path);
                        FileInputStream fileinAdded = new FileInputStream(ficheroLectura);
                        DataInputStream dataISAdded = new DataInputStream(fileinAdded);


                    } catch (IOException e){
                            System.out.println("Hubo un error intentando ubicar el fichero.");
                    }


                    break;
                case 3:
                    for (Libro l:biblioteca) {
                        if (l != null) {
                            System.out.println("*******************************");
                            l.mostrarLibro();
                            System.out.println("*******************************");
                        }
                    }
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    break;
            }
        }
    }
}