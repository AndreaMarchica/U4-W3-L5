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
        // 1. Inizio la transazione
        transaction.begin();

        // 2. Aggiungo il nuovo oggetto al Persistence Context (ma non è ancora salvato a DB in questo momento)
        em.persist(eb);

        // 3. Termino la transazione col salvataggio effettivo di una nuova riga nella tabella students
        transaction.commit();
        System.out.println("Nuovo elemento bibliotecario salvato correttamente");
    }

    public ElementoBibliotecario findById(UUID isbn) {
        // SELECT * FROM students WHERE students.isbn=1
        return em.find(ElementoBibliotecario.class, isbn);
    }

    public void findByIdAndDelete(UUID isbn) {

        // 1. Faccio una find per cercare lo studente
        ElementoBibliotecario found = em.find(ElementoBibliotecario.class, isbn);

        if (found != null) {
            // 2. Se lo studente c'è, lo elimino

            // 2.1 Ottengo la transazione
            EntityTransaction transaction = em.getTransaction();

            // 2.2 Faccio partire la transazione
            transaction.begin();

            // 2.3 Rimuovo l'oggetto dal persistence context
            em.remove(found);

            // 2.4 Faccio il commit della transazione per persistere a db l'operazione
            transaction.commit();
            System.out.println("L'elemento bibliotecario è stato cancellato correttamente");
        } else {
            // 3. Altrimenti --> "Student not found"
            System.err.println("L'elemento bibliotecario con l'isbn " + isbn + " non è stato trovato");
        }

    }

/*    public List<BlogPost> getAllBlogsByCategoryId(long categoryId) {
        ElementoBibliotecario category = this.findById(categoryId);

        return category.getBlogPostList();
    }*/
}