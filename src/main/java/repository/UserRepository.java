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

    public User findUserByName(String username) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void updatePoints(User user, int newPoints) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        user.setMaxPoints(newPoints);
        transaction.commit();
    }
}
