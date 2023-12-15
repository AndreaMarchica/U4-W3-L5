package andreamarchica;

import andreamarchica.DAO.CatalogoBibliotecarioDAO;
import andreamarchica.entities.ElementoBibliotecario;
import andreamarchica.entities.Libro;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Locale;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogoBibliotecario");
    CatalogoBibliotecarioDAO eb = new CatalogoBibliotecarioDAO(em);

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        UUID uuid = UUID.randomUUID();

        Libro libro = new Libro(faker.book().author(), faker.book().title(), faker.book().genre(), 1997, 452, uuid);
        eb.save(libro);
        System.out.println("Hello World!");


        em.close();
        emf.close();
    }

}
