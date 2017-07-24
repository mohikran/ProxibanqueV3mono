package Proxibanque;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gtm.dao.ClientCrudDao;
import com.gtm.dao.CompteCrudDao;
import com.gtm.dao.ConseillerCrudDao;
import com.gtm.dao.IntClientCrudDao;
import com.gtm.domaine.Client;
import com.gtm.domaine.CompteCourant;
import com.gtm.domaine.CompteEpargne;
import com.gtm.service.ClientCrudService;
import com.gtm.service.VirementService;

public class ClientCrudServiceTest {

//	private final static Logger log = Logger.getLogger(ClientCrudServiceTest.class);
//	private ClientCrudDao clientDao;
//	Client client1;
//	Client client2;
//	CompteCourant compteCClient1;
//	CompteCourant compteCClient2;
//	CompteEpargne compteEClient1;
//	int id;
//	
//	@Before
//	public void initialisationDesDonnées(){
//		clientDao = new ClientCrudDao();
//		compteCClient1 = new CompteCourant(2000);
//		compteEClient1 = new CompteEpargne(50000);
//		compteCClient2 = new CompteCourant(1000);
//		client1 = new Client("Piccini","Alexandre", "5 rue du Grand Boulevard", "APiccini@hotmail.fr", compteCClient1, compteEClient1, 1);
//		client2 = new Client("Dumoulin","Matthieu", "5 petite rue de Monplaisir", "m.dumoulin.ensci@gmail.com", compteCClient2, compteEClient1, 1);
//		clientDao.sauverEnBase(client1);
//		id = clientDao.lireTous().get(0).getIdClient();
//	}
//	
//	@After
//	public void DestructionDesDonnées(){
//		if(!clientDao.lireTous().isEmpty())
//		for(Client client:clientDao.lireTous())
//		{clientDao.supprimer(client.getIdClient());}
//		clientDao = null;
//		compteCClient1 = null;
//		compteEClient1 = null;
//		compteCClient2 = null;
//		client1 = null;
//		client2 = null;
//		id = 0;
//	}
//		
//	
//	@Test
//	public void testSauverEnBase(){
//	
//		assertTrue(clientDao.sauverEnBase(client1));
//	}
//	
//	@Test
//	public void testLireByIdRetourneUnObjet(){
//		assertNotNull(clientDao.lireById(id));
//	}
//	
//	@Test
//	public void testLireByIdRetourneUnClient(){
//		assertTrue(clientDao.lireById(id) instanceof Client);
//	}
//	
//	@Test
//	public void testLireByIdConseillerRetourneUnObjet(){
//		assertNotNull(clientDao.LireByIdConseiller(1));
//	}
//	
//	@Test
//	public void testLireByIdConseillerRetourneUneListeClient(){
//		assertTrue(clientDao.LireByIdConseiller(1).get(0) instanceof Client);
//	}
//	
//	@Test
//	public void testLireTousRetourneUneListeNonNull(){
//		assertNotNull(clientDao.lireTous());
//	}
//	
//	@Test
//	public void testLireTousRetourneUneListeNonVide(){
//		assertFalse(clientDao.lireTous().isEmpty());
//	}
//	
//	@Test
//	public void testLireTousRetourneUneListeQuiContientDesClients(){
//		assertTrue(clientDao.lireTous().get(0) instanceof Client);
//	}
//	
//	@Test
//	public void testModifier(){
//		client1 = client2;
//		assertTrue(clientDao.modifier(client1));
//	}
//	
//	@Test
//	public void testSupprimerClient() {
//		assertTrue(clientDao.supprimer(id));
//	}

}
