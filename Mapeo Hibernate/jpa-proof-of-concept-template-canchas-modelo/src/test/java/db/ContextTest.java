package db;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import canchas.Color;
import canchas.Marca;
import canchas.Paleta;

public class ContextTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

	@Test
	public void contextUp() {
		assertNotNull(entityManager());
	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		withTransaction(() -> {});
	}
	
	@Test
	public void traerColores() throws Exception{
		/*List<Color> colores = entityManager().createQuery("from Color", Color.class).getResultList();
		
		colores.forEach(c -> System.out.println(c.getDescripcion()));*/
		
		EntityManager em = entityManager();
		
		//cuando se trae de la base, hibernate ya lo conoce (no hace falta poner persist)
		Color otroVerde = entityManager().createQuery("from Color", Color.class).getResultList().get(0);
		Color verde = entityManager().createQuery("from Color", Color.class).getResultList().get(0);
		//System.out.println(verde == otroVerde);
		
		verde.setOtraCosa("algo");
		
		Color blanco = new Color("blanco");
		blanco.setHexa("FFFFFF");
		
		em.persist(blanco);
		
		/////////////////////////////////
		
		Paleta paletaVerde = new Paleta();
		em.persist(paletaVerde);
		
		Color negro = new Color("negro");
		
		Paleta paletaNegra = new Paleta();
		em.persist(paletaNegra);
		
		withTransaction(()->{
			paletaVerde.setColor(verde);
			verde.setHexa("00FF00");
			paletaNegra.setColor(negro);
		});
		
		
		
		int a = 1;
	}
	
	@Test
	public void test4() throws Exception{
		
		Color verde = entityManager().createQuery("from Color", Color.class).getResultList().get(0);
		
		Paleta paleta = entityManager().createQuery("from Paleta where paletaId = 1", Paleta.class).getResultList().get(0);
		
		withTransaction(()->{
			paleta.setMarca(Marca.HEAD);
		});
		
		
		
		int a = 1;
	}

}
