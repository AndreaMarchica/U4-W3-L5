package andreamarchica.entities;

import javax.persistence.*;

@Entity
public class Rivista extends ElementoBibliotecario {

    /*ATTRIBUTI*/

    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    /*COSTRUTTORI*/

    public Rivista() {
    }

    public Rivista(Periodicità periodicità, String titolo, int annoPubblicazione, int numeroPagine, long isbn) {
        super(titolo, annoPubblicazione, numeroPagine, isbn);
        this.periodicità = periodicità;
    }
    /*METODI*/

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                '}';
    }
}
