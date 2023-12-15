package andreamarchica.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Tipologia")
@Table(name = "Elementi_bibliotecari")
public abstract class ElementoBibliotecario {
    /*ATTRIBUTI*/


    @Id
    @GeneratedValue
    private UUID isbn;
    @Column(name = "Id")
    private String titolo;
    @Column(name = "Anno_di_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "Numero_di_pagine")
    private int numeroPagine;
    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti = new ArrayList<>();

    /*COSTRUTTORI*/

    public ElementoBibliotecario(){}
    public ElementoBibliotecario(String titolo, int annoPubblicazione, int numeroPagine, UUID isbn) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.isbn = isbn;
    }

    /*METODI*/


    public UUID getIsbn() {
        return isbn;
    }

    public void setIsbn(UUID isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "ElementoBibliotecario{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione='" + annoPubblicazione + '\'' +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
