/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tecnicas.hightide;

import com.tecnicas.hightide.model.models.Musica;
import static com.tecnicas.hightide.model.models.Musica.Genero.*;
import com.tecnicas.hightide.model.models.Playlist;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
        
/**
 *
 * @author Victor Moreno
 */
public class Hightide {

    public static void main(String[] args) {
        Musica m1 = new Musica(null, "Capa", "Música Rap1", "Rivânio", "url", RAP);
        Musica m2 = new Musica(null, "Capa", "Música Rap2", "Rivânio", "url", RAP);
        Musica m3 = new Musica(null, "Capa", "Música Pop1", "Rivânio", "url", POP);
        
        List rivasRaps = new ArrayList();
        rivasRaps.add(m1);
        rivasRaps.add(m2);
        
        List rivasPop = new ArrayList();
        rivasPop.add(m3);

        Playlist raps = new Playlist(null, "Raps do Rivas", rivasRaps);
        Playlist pops = new Playlist(null, "Pop kkk", rivasPop);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence.xml");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(m1);
        em.persist(m2);
        em.persist(m3);
        em.persist(raps);
        em.persist(pops);
        em.getTransaction().commit();
        emf.close();
        System.out.println("Pronto!");
    }
}
