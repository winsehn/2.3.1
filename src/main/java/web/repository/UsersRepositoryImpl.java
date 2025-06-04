package web.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        User findUser = em.find(User.class, user.getId());
        if (findUser != null) {
            em.remove(findUser);
        }
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Query query = em.createQuery("FROM User", User.class);
        return query.getResultList();
    }
}
