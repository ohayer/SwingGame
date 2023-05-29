package repository;

import entity.User;
import javax.persistence.*;


public class UserRepository {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
    private static final EntityManager em = factory.createEntityManager();

    public void createNewUser(String name, int points) {
        User user = new User(name, points);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(user);
        System.out.println(user.getId());
        transaction.commit();
    }
}
