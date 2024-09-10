/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tecnicas.hightide;

import com.tecnicas.hightide.model.User;
import javax.persistence.*;
        
/**
 *
 * @author Victor Moreno
 */
public class Hightide {

    public static void main(String[] args) {
        User u1 = new User(null, "Teste", "u1", "123");
        User u2 = new User(null, "Teste2", "u2", "123");
        User u3 = new User(null, "Teste3", "u3", "123");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence.xml");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(u1);
        em.persist(u2);
        em.persist(u3);
        em.getTransaction().commit();
        System.out.println("Pronto!");
    }
}
