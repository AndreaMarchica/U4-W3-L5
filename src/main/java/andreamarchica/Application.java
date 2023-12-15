package andreamarchica;

import andreamarchica.DAO.CatalogoBibliotecarioDAO;
import andreamarchica.DAO.UtentiDAO;
import andreamarchica.entities.Libro;
import andreamarchica.entities.Utente;
import com.github.javafaker.Faker;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogoBibliotecario");



    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        CatalogoBibliotecarioDAO eb = new CatalogoBibliotecarioDAO(em);
        UtentiDAO u = new UtentiDAO(em);
        Faker faker = new Faker(Locale.ITALY);
        UUID uuid = UUID.randomUUID();

/*        Libro libro = new Libro(faker.book().author(), faker.book().title(), faker.book().genre(), 1997, 452, uuid);
        eb.save(libro);*/
        System.out.println("Hello World!");

        Utente utente = new Utente(faker.name().firstName(), faker.name().lastName(),  LocalDate. of(2022,11,05));
        u.save(utente);

        em.close();
        emf.close();
    }

}
