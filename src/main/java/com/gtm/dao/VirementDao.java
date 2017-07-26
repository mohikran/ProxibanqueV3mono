package com.gtm.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.InputVerifier;

import com.gtm.domaine.Conseiller;
import com.gtm.domaine.Virement;
@Named
@SessionScoped
public class VirementDao extends GenericCrudDao<Virement> implements Serializable, IntVirement{

	@Override
	public
	Class<Virement> getClazz() {
		// TODO Auto-generated method stub
		return Virement.class;}
		
		
	@Override
	public List<Virement> lireTous(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque-pu");
		EntityManager em = emf.createEntityManager();
			
		
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(getClazz()));
		List<Virement> maList 	= em.createQuery(cq).getResultList();
		
		
		em.close();
		emf.close();
		
		return maList;
	}

}
