import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Libro {
    //Atributos
    private long isbn;
    private String titulo;
    private String autor;

    //Constructor
    public Libro(long isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    //Metodos
    public void grabarLibro(DataOutputStream fich) throws IOException{
        fich.writeLong(isbn);
        fich.writeUTF(titulo);
        fich.writeUTF(autor);
    }

    public void leerLibro(DataInputStream fich) throws IOException{
        isbn = fich.readLong();
        titulo = fich.readUTF();
        autor = fich.readUTF();
    }

    public void mostrarLibro(){
        System.out.println("ISBN: " + isbn +
                "\nTitulo: " + titulo +
                "\nAutor: " + autor);
    }

    //Getters
    public long getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
