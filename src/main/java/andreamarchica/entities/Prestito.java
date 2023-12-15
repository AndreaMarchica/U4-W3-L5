package andreamarchica.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Prestiti")
public class Prestito {

    /*ATTRIBUTI*/

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "n_tessera_utente")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "isbn")
    private ElementoBibliotecario elementoBibliotecario;
    @Column(name = "Data_di_inizio_del_prestito")
    private LocalDate dataInizioPrestito;
    @Column(name = "Data_di_restituzione_del_prestito_prevista")
    private LocalDate dataDiRestituzionePrevista;
    @Column(name = "Data_di_restituzione_del_prestito_effettiva")
    private LocalDate dataDiRestituzioneEffettiva;


    /*COSTRUTTORI*/

    public Prestito() {
    }

    public Prestito(LocalDate dataInizioPrestito, LocalDate dataDiRestituzioneEffettiva) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataDiRestituzionePrevista = dataInizioPrestito; //+30gg
        this.dataDiRestituzioneEffettiva = dataDiRestituzioneEffettiva;
    }


    /*METODI*/

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataDiRestituzionePrevista() {
        return dataDiRestituzionePrevista;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDataDiRestituzionePrevista(LocalDate dataDiRestituzionePrevista) {
        this.dataDiRestituzionePrevista = dataDiRestituzionePrevista;
    }

    public LocalDate getDataDiRestituzioneEffettiva() {
        return dataDiRestituzioneEffettiva;
    }

    public void setDataDiRestituzioneEffettiva(LocalDate dataDiRestituzioneEffettiva) {
        this.dataDiRestituzioneEffettiva = dataDiRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", dataInizioPrestito='" + dataInizioPrestito + '\'' +
                ", dataDiRestituzionePrevista='" + dataDiRestituzionePrevista + '\'' +
                ", dataDiRestituzioneEffettiva='" + dataDiRestituzioneEffettiva + '\'' +
                '}';
    }
}
