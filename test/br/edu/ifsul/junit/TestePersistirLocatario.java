package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Locatario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Paulo
 */
public class TestePersistirLocatario {
    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirLocatario() {
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
            Locatario l = new Locatario();
            Aluguel a = em.find(Aluguel.class, 1);
            l.setNome("Paulo");           
            l.setCpf("69923949087");
            l.setTelefone("999414401");
            l.setEmail("paulo@paulo.com.br");
            l.setLocalTrabalho("Zaffari");
            l.setRenda(2500.00);
            l.setTelefoneTrabalho("999414402");
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se ao resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
}
