import java.io.*;
import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) throws IOException {
        //Atributos
        boolean run = true;
        int opcion;
        long isbn;
        String titulo, autor;
        Libro libro = new Libro();

        Scanner scanner = new Scanner(System.in);

        File fichero = new File("C:\\Users\\usuario\\Desktop\\Fichero.dat");

        //Declaracion de DataOutputStream
        FileOutputStream fileout = new FileOutputStream(fichero, true);
        DataOutputStream dataOS = new DataOutputStream(fileout);



        //Programa
        while (run){

            System.out.println("Escoja una opcion:" +
                    "\n1. Escribir libros." +
                    "\n2. Mostrar libros." +
                    "\n3. Salir.");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    isbn = 0; //Restablece isbn
                    while (isbn != -1) {
                        System.out.println("*******************************");
                        System.out.println("Escriba el ISBN (-1 para detenerse):");
                        isbn = scanner.nextInt();
                        scanner.nextLine(); //Retorno de carro

                        if (isbn != -1) {
                            System.out.println("Escriba el titulo:");
                            titulo = scanner.nextLine();

                            System.out.println("Escriba el autor:");
                            autor = scanner.nextLine();
                            System.out.println("*******************************");


                            libro = new Libro(isbn, titulo, autor);
                            libro.grabarLibro(dataOS);
                        }
                    }
                    break;
                case 2:

                    FileInputStream filein = new FileInputStream(fichero);
                    DataInputStream dataIS = new DataInputStream(filein);

                    try {
                        while (true) {
                            libro.leerLibro(dataIS);
                            libro.mostrarLibro();
                        }
                    } catch (EOFException e) {
                        System.out.println("Fin de lectura");
                    }

                    filein.close();
                    dataIS.close();
                    break;
                case 3:
                    run = false;
                    break;
                default:
                    break;
            }
        }
        fileout.close();
        dataOS.close();
    }
}