import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

public class persistence {
    private static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("tuUnidadDePersistencia");
    private EntityManager entityManager = emFactory.createEntityManager();

    // Tus métodos que usan entityManager aquí
}
