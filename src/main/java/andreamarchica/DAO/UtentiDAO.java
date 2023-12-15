package andreamarchica.DAO;

import andreamarchica.entities.ElementoBibliotecario;
import andreamarchica.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.UUID;

public class UtentiDAO {
    private final EntityManager em;

    public UtentiDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente u) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(u);
        transaction.commit();
        System.out.println("Nuovo utente salvato correttamente");
    }

    public Utente findById(UUID numeroTessera) {
        return em.find(Utente.class, numeroTessera);
    }

    public void findByIdAndDelete(UUID numeroTessera) {

        ElementoBibliotecario found = em.find(ElementoBibliotecario.class, numeroTessera);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("L'utente è stato cancellato correttamente");
        } else {
            System.err.println("L'utente con la tessera " + numeroTessera + " non è stato trovato");
        }

    }

}