package br.upf.software.testes;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.upf.software.beans.Doenca;
import br.upf.software.jpa.JPAFactory;

public class TesteComJunit {

	@Test
	public void listar() {
		EntityManager em = JPAFactory.getEntityManager();
		List<Doenca> lista = em.createQuery("from Doenca").getResultList();
		System.out.println(lista);	
		em.close();
	}	
	
	@Test
	public void incluir() {
		Doenca r = new Doenca(null, "Hepatite");
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
	}	
	

	@Test
	public void TestGetDescricaEquals(){
		Doenca doenca = new Doenca();
		doenca.setDescricao("doenca");
		
		Assert.assertEquals("doenca", doenca.getDescricao());
	}
	
	@Test 
	public void TestGetDescricaoEmpity(){
		Doenca doenca = new Doenca();
		
		Assert.assertEquals("", doenca.getDescricao());
	}
}
	

