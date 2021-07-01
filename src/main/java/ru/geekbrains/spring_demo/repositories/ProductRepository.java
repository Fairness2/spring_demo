package ru.geekbrains.spring_demo.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_demo.model.HiProduct;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private SessionFactory factory;


    @PostConstruct
    public void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        try {
            String sql = Files.lines(Paths.get("init.sql")).collect(Collectors.joining(" "));
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            //session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void preDestroy() {
        factory.close();
    }

    public boolean add(HiProduct product) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();

        return product.getId() != null;
    }

    public boolean delete(Integer id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        HiProduct product = session.get(HiProduct.class, id);
        session.delete(product);
        session.getTransaction().commit();

        return product.getId() != null;
    }

    public List<HiProduct> getAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<HiProduct> list = session.createQuery("from HiProduct").getResultList();
        session.getTransaction().commit();

        return list;
    }

    public HiProduct getOne(Integer id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        HiProduct product = session.get(HiProduct.class, id);
        session.getTransaction().commit();

        return product;
    }

    public HiProduct create(String title, int cost) {
        HiProduct product = new HiProduct();
        product.setTitle(title);
        product.setCost(cost);

        return this.add(product) ? product : null;
    }

    public HiProduct update(Integer id, String title, int cost) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        HiProduct product = session.get(HiProduct.class, id);
        product.setTitle(title);
        product.setCost(cost);
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        return product;
    }


}
