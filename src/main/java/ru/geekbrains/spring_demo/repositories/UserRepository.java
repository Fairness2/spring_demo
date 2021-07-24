package ru.geekbrains.spring_demo.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_demo.model.entity.User;
import ru.geekbrains.spring_demo.model.entity.UserProduct;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Repository
public class UserRepository {
    /*private SessionFactory factory;

    @PostConstruct
    public void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        try {
            String sql = Files.lines(Paths.get("init.sql")).collect(Collectors.joining(" "));
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void preDestroy() {
        factory.close();
    }

    public boolean add(User user) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();

        return user.getId() != null;
    }

    public boolean delete(Integer id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();

        return user.getId() != null;
    }

    public List<User> getAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<User> list = session.createQuery("from User ").getResultList();
        session.getTransaction().commit();

        return list;
    }

    public User getOne(Integer id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();

        return user;
    }

    public User create(String name) {
        User user = new User();
        user.setName(name);

        return this.add(user) ? user : null;
    }

    public User update(Integer id, String name) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        user.setName(name);
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        return user;
    }

    public List<UserProduct> getUserProducts(User user) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        User tempUser = session.get(User.class, user.getId());
        List<UserProduct> list = tempUser.getUserProducts();
        int size = list.size();
        session.getTransaction().commit();
        return list;
    }*/


}
