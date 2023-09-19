package com.example.prison_management.classes;

import javax.persistence.*;
import java.util.List;

public class PrisonDAO {
    private EntityManagerFactory emf;

    public void addPrisoner(Prisoner prisoner) {
        emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(prisoner);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    public List<Prisoner> getAllPrisoners() {
        emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Prisoner p");
        List<Prisoner> prisoners = query.getResultList();
        em.close();

        return prisoners;
    }

    public void delete(Prisoner prisoner) {
        emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Prisoner managedPrisoner = em.find(Prisoner.class, prisoner.getId());
            em.remove(managedPrisoner);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void update(Prisoner prisoner, long id) {
        emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Prisoner managedPrisoner = em.find(Prisoner.class, id);
            if (managedPrisoner != null) {
                managedPrisoner.setName(prisoner.getName());
                managedPrisoner.setFathersName(prisoner.getFathersName());
                managedPrisoner.setGrandFathersName(prisoner.getGrandFathersName());
                managedPrisoner.setSex(prisoner.getSex());
                managedPrisoner.setAge(prisoner.getAge());
                em.merge(managedPrisoner);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
