/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Mensalidade;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paulo
 */
public class TestePersistirAluguel {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    
    public TestePersistirAluguel() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-Modelo3Model");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void testar(){
        boolean exception = false;
        try {
            Aluguel a = new Aluguel();
            Locatario l = em.find(Locatario.class, 1);
            Mensalidade m = em.find(Mensalidade.class, 2);
            a.setValor(550.0);
            a.setInicioContrato(Calendar.getInstance());
            a.setFimContrato(Calendar.getInstance());
            a.setDiaVencimento(10);
            a.setLocatario(l);
            
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se ao resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
    
}
