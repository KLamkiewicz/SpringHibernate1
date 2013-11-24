package com.example.shdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Jednorozec;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class JednorozecManagerTest {
	
	@Autowired
	JednorozecManagerIn jednorozecManager;
	
	private final String IMIE_JEDNOROZCA1 = "Jarek";
	private final int rokUrodzeniaJednorozca1 = 1990;
	private final int wagaJednorozca1 = 400;
	
	private final String imieJednorozca2 = "Jakub";
	private final int rokUrodzeniaJednorozca2 = 1990;
	private final int wagaJednorozca2 = 300;
	
	private final String imieJednorozca3 = "Michal";
	private final int rokUrodzeniaJednorozca3 = 1990;
	private final int wagaJednorozca3 = 5376;
	
	@Test
	public void getAllJednorozce(){
		assertEquals(0, jednorozecManager.getAllJednorozce().size());
		
		Jednorozec jednorozec = new Jednorozec();
		jednorozec.setImieJednorozca(IMIE_JEDNOROZCA1);
		jednorozec.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca1);
		jednorozec.setWagaJednorozca(wagaJednorozca1);
		
		Jednorozec jednorozec2 = new Jednorozec();
		jednorozec.setImieJednorozca(imieJednorozca2);
		jednorozec.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca2);
		jednorozec.setWagaJednorozca(wagaJednorozca2);
		
		jednorozecManager.addJednorozec(jednorozec);
		jednorozecManager.addJednorozec(jednorozec2);
		
		assertEquals(2, jednorozecManager.getAllJednorozce().size());
	}
	
	@Test
	public void addJednorozec(){
		Jednorozec jednorozec = new Jednorozec();
		jednorozec.setImieJednorozca(IMIE_JEDNOROZCA1);
		jednorozec.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca1);
		jednorozec.setWagaJednorozca(wagaJednorozca1);
		
		Jednorozec jednorozec2 = new Jednorozec();
		jednorozec2.setImieJednorozca(imieJednorozca2);
		jednorozec2.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca2);
		jednorozec2.setWagaJednorozca(wagaJednorozca2);

		jednorozecManager.addJednorozec(jednorozec);
		jednorozecManager.addJednorozec(jednorozec2);
		
		assertEquals(2, jednorozecManager.getAllJednorozce().size());
		assertEquals(IMIE_JEDNOROZCA1, jednorozecManager.getAllJednorozce().get(0).getImieJednorozca());
		assertEquals(rokUrodzeniaJednorozca1, jednorozecManager.getAllJednorozce().get(0).getRokUrodzeniaJednorozca());
		assertEquals(wagaJednorozca1, jednorozecManager.getAllJednorozce().get(0).getWagaJednorozca());
		assertEquals(imieJednorozca2, jednorozecManager.getAllJednorozce().get(1).getImieJednorozca());
		assertEquals(rokUrodzeniaJednorozca2, jednorozecManager.getAllJednorozce().get(1).getRokUrodzeniaJednorozca());
		assertEquals(wagaJednorozca2, jednorozecManager.getAllJednorozce().get(1).getWagaJednorozca());
	}
	
	@Test
	public void deleteJednorozec(){
		Jednorozec jednorozec = new Jednorozec();
		jednorozec.setImieJednorozca(IMIE_JEDNOROZCA1);
		jednorozec.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca1);
		jednorozec.setWagaJednorozca(wagaJednorozca1);
		
		Jednorozec jednorozec2 = new Jednorozec();
		jednorozec2.setImieJednorozca(imieJednorozca2);
		jednorozec2.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca2);
		jednorozec2.setWagaJednorozca(wagaJednorozca2);
		
		Jednorozec jednorozec3 = new Jednorozec();
		jednorozec3.setImieJednorozca(imieJednorozca3);
		jednorozec3.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca3);
		jednorozec3.setWagaJednorozca(wagaJednorozca3);
		
		jednorozecManager.addJednorozec(jednorozec);
		jednorozecManager.addJednorozec(jednorozec2);
		jednorozecManager.addJednorozec(jednorozec3);
		assertEquals(3, jednorozecManager.getAllJednorozce().size());
		
		//Long id = jednorozecManager.getAllJednorozce().get(1).getId();
		Long id2 = jednorozec2.getId();
		Long id3 = jednorozec3.getId();
		jednorozecManager.deleteJednorozec(jednorozec2);
		assertEquals(2, jednorozecManager.getAllJednorozce().size());
		
		assertNull(jednorozecManager.getJednorozecById(id2));
		assertNotNull(jednorozecManager.getJednorozecById(id3));
	}

	@Test
	public void deleteJednorozecById(){
		Jednorozec jednorozec = new Jednorozec();
		jednorozec.setImieJednorozca(IMIE_JEDNOROZCA1);
		jednorozec.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca1);
		jednorozec.setWagaJednorozca(wagaJednorozca1);
		
		Jednorozec jednorozec2 = new Jednorozec();
		jednorozec2.setImieJednorozca(imieJednorozca2);
		jednorozec2.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca2);
		jednorozec2.setWagaJednorozca(wagaJednorozca2);
		
		Jednorozec jednorozec3 = new Jednorozec();
		jednorozec3.setImieJednorozca(imieJednorozca3);
		jednorozec3.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca3);
		jednorozec3.setWagaJednorozca(wagaJednorozca3);
		
		jednorozecManager.addJednorozec(jednorozec);
		jednorozecManager.addJednorozec(jednorozec2);
		jednorozecManager.addJednorozec(jednorozec3);
		assertEquals(3, jednorozecManager.getAllJednorozce().size());
		
		Long id = jednorozec2.getId();
		Long id3 = jednorozec3.getId();
		jednorozecManager.deleteJednorozecById(id);
		assertEquals(2, jednorozecManager.getAllJednorozce().size());
		
		assertNull(jednorozecManager.getJednorozecById(id));
		assertNotNull(jednorozecManager.getJednorozecById(id3));
	}
	
	@Test
	public void getJednorozecById(){
		Jednorozec jednorozec = new Jednorozec();
		jednorozec.setImieJednorozca(IMIE_JEDNOROZCA1);
		jednorozec.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca1);
		jednorozec.setWagaJednorozca(wagaJednorozca1);
		
		Jednorozec jednorozec2 = new Jednorozec();
		jednorozec2.setImieJednorozca(imieJednorozca2);
		jednorozec2.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca2);
		jednorozec2.setWagaJednorozca(wagaJednorozca2);
		
		jednorozecManager.addJednorozec(jednorozec);
		jednorozecManager.addJednorozec(jednorozec2);

		Long id = jednorozecManager.getJednorozecById(jednorozecManager.getAllJednorozce().get(0).getId()).getId();	
		assertEquals(jednorozecManager.getAllJednorozce().get(0).getId(), id);
	}
	
	@Test 
	public void updateJednorozec(){
		Jednorozec jednorozec = new Jednorozec();
		jednorozec.setImieJednorozca(IMIE_JEDNOROZCA1);
		jednorozec.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca1);
		jednorozec.setWagaJednorozca(wagaJednorozca1);
		
		Jednorozec jednorozec2 = new Jednorozec();
		jednorozec2.setImieJednorozca(imieJednorozca2);
		jednorozec2.setRokUrodzeniaJednorozca(rokUrodzeniaJednorozca2);
		jednorozec2.setWagaJednorozca(wagaJednorozca2);
		
		jednorozecManager.addJednorozec(jednorozec);
		jednorozecManager.addJednorozec(jednorozec2);
		
		String changed = "Changed";
		Long id = jednorozec.getId();
		assertEquals(IMIE_JEDNOROZCA1, jednorozecManager.getJednorozecById(id).getImieJednorozca());
		jednorozecManager.updateJednorozec(id, changed);
		assertEquals(changed, jednorozecManager.getJednorozecById(id).getImieJednorozca());
		assertEquals(imieJednorozca2, jednorozecManager.getAllJednorozce().get(1).getImieJednorozca());
	}
}
