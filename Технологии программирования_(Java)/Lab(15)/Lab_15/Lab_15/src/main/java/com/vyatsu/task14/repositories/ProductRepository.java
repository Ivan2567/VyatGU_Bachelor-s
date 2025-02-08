package com.vyatsu.task14.repositories;

import com.vyatsu.task14.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepository {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Product.class)
            .buildSessionFactory();

    public void add(String name,Integer price)
    {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Product product = new Product();
            product.setTitle(name);
            product.setPrice(price);
            session.save(product);
            session.getTransaction().commit();
            session.close();
    }

    public void delete(int id)
    {
        Product x;
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        x = session.load(Product.class,id);
        session.delete(x);
        session.getTransaction().commit();
        session.close();
    }

    public void change(Integer id,String name,Integer price)
    {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("update Product set title = :x,price = :y where id = :z")
                .setParameter("x", name)
                .setParameter("y", price)
                .setParameter("z", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public List<Product> findAll(Integer Min,Integer Max,String title)
    {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> prod = session.createQuery("from Product").getResultList();
        if(Min != null)
        {
            prod = prod.stream().filter(p -> p.getPrice() > Min).collect(Collectors.toList());
        }
        if(Max != null)
        {
            prod = prod.stream().filter(p -> p.getPrice() < Max).collect(Collectors.toList());
        }
        if(title != "")
        {
            prod = prod.stream().filter(p -> p.getTitle().contains(title)).collect(Collectors.toList());
        }
        session.getTransaction().commit();
        session.close();
        return prod;
    }
}
