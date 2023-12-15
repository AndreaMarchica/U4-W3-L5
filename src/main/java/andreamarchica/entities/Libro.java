package andreamarchica.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Libro extends ElementoBibliotecario {

    /*ATTRIBUTI*/

    @Column(name = "Autore")
    private String autore;
    @Column(name = "Genere")
    private String genere;


    /*COSTRUTTORI*/


    public Libro() {
    }
    public Libro(String autore, String titolo, String genere, int annoPubblicazione, int numeroPagine, long isbn) {
        super(titolo, annoPubblicazione, numeroPagine, isbn);
        this.autore = autore;
        this.genere = genere;
    }

    /*METODI*/

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
