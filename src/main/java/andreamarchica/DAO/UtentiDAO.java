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
        // 1. Inizio la transazione
        transaction.begin();

        // 2. Aggiungo il nuovo oggetto al Persistence Context (ma non è ancora salvato a DB in questo momento)
        em.persist(u);

        // 3. Termino la transazione col salvataggio effettivo di una nuova riga nella tabella students
        transaction.commit();
        System.out.println("Nuovo utente salvato correttamente");
    }

    public Utente findById(UUID numeroTessera) {
        // SELECT * FROM students WHERE students.isbn=1
        return em.find(Utente.class, numeroTessera);
    }

    public void findByIdAndDelete(UUID numeroTessera) {

        // 1. Faccio una find per cercare lo studente
        ElementoBibliotecario found = em.find(ElementoBibliotecario.class, numeroTessera);

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
            System.out.println("L'utente è stato cancellato correttamente");
        } else {
            // 3. Altrimenti --> "Student not found"
            System.err.println("L'utente con la tessera " + numeroTessera + " non è stato trovato");
        }

    }

/*    public List<BlogPost> getAllBlogsByCategoryId(long categoryId) {
        ElementoBibliotecario category = this.findById(categoryId);

        return category.getBlogPostList();
    }*/
}