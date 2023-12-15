package andreamarchica.DAO;

import andreamarchica.entities.ElementoBibliotecario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.UUID;

public class CatalogoBibliotecarioDAO {
    private final EntityManager em;

    public CatalogoBibliotecarioDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ElementoBibliotecario eb) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(eb);

        transaction.commit();
        System.out.println("Nuovo elemento bibliotecario salvato correttamente");
    }

    public ElementoBibliotecario findById(UUID isbn) {

        return em.find(ElementoBibliotecario.class, isbn);
    }

    public void findByIdAndDelete(UUID isbn) {

        ElementoBibliotecario found = em.find(ElementoBibliotecario.class, isbn);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("L'elemento bibliotecario è stato cancellato correttamente");
        } else {
            System.err.println("L'elemento bibliotecario con l'isbn " + isbn + " non è stato trovato");
        }

    }

}