package ru.geekbrains.spring_demo.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_demo.model.entity.HiProduct;
import ru.geekbrains.spring_demo.model.entity.User;
import ru.geekbrains.spring_demo.model.entity.UserProduct;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Repository
public class UserProductRepository {
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

    public boolean add(UserProduct userProduct) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(userProduct);
        session.getTransaction().commit();

        return userProduct.getId() != null;
    }

    public boolean delete(Integer id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        UserProduct userProduct = session.get(UserProduct.class, id);
        session.delete(userProduct);
        session.getTransaction().commit();

        return userProduct.getId() != null;
    }

    public List<UserProduct> getAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<UserProduct> list = session.createQuery("from UserProduct ").getResultList();
        session.getTransaction().commit();

        return list;
    }

    public UserProduct getOne(Integer id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        UserProduct userProduct = session.get(UserProduct.class, id);
        session.getTransaction().commit();

        return userProduct;
    }

    public UserProduct create(User user, HiProduct product, Integer currentCost) {
        UserProduct userProduct = new UserProduct();
        userProduct.setUser(user);
        userProduct.setProduct(product);
        userProduct.setCurrentCost(currentCost);

        return this.add(userProduct) ? userProduct : null;
    }

    public UserProduct update(Integer id, User user, HiProduct product, Integer currentCost) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        UserProduct userProduct = session.get(UserProduct.class, id);
        userProduct.setUser(user);
        userProduct.setProduct(product);
        userProduct.setCurrentCost(currentCost);
        session.saveOrUpdate(userProduct);
        session.getTransaction().commit();
        return userProduct;
    }*/


}
