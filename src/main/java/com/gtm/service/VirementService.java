package com.gtm.service;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.gtm.dao.IntVirement;
import com.gtm.domaine.Compte;
import com.gtm.domaine.CompteCourant;
import com.gtm.domaine.CompteEpargne;
import com.gtm.domaine.Virement;
import com.gtm.exception.SaisieException;


@Named
@SessionScoped
public class VirementService implements Serializable{

	private final static Logger log = Logger.getLogger(VirementService.class);
	@Inject
	IntCompteCrudService compteservice;
	
	@Inject 
	IntVirement virementdao;

//	public boolean EffectuerVirement(CompteCourant compteDebite, Compte compteCredite, long montant) throws SaisieException{
//		if(montant>(compteDebite.getSolde()+compteDebite.getPlafondDeDecouvert()))throw SaisieException("Le solde du compte "
//				+ "d�bit� n'est pas assez �lev� pour effectuer ce virement");
//		else{long SoldeCD = compteDebite.getSolde();
//			long SoldeCC = compteCredite.getSolde();
//			compteDebite.setSolde(SoldeCD - montant);
//			compteCredite.setSolde(SoldeCC + montant);
//			log.info("Virement [Numero CompteD�bit� = " + compteDebite.getIdCompte() + ", Numero CompteCr�dit� = " + 
//			compteCredite.getIdCompte() + ", Montant = " + montant + ", Nouveau solde du CompteD�bit� = "
//			+ compteDebite.getSolde() + " �, Nouveau solde du Compte Cr�dit� = " +compteCredite.getSolde() +" � ]" );
//		}}

	/**
	 * M�thode permettant de effectuer un virement entre deux compte
	 * @param compteDebite
	 * @param compteCredite
	 * @param montant du virement
	 * @return un boolean pour pouvoir tester la m�thode
	 * @throws SaisieException
	 */

	public boolean EffectuerVirement(Compte compteDebite, Compte compteCredite, int montant) throws SaisieException{

		if(compteDebite.getClass().equals(CompteCourant.class)){
			if(montant>(compteDebite.getSolde()+((CompteCourant) compteDebite).getPlafondDeDecouvert()))throw new SaisieException("Le solde du compte d�bit� n�"
					+ compteDebite.getIdCompte() + " : " + compteDebite.getSolde() + "�, n'est pas assez �lev� pour effectuer un virement de " + montant +"�.");
			else{long SoldeCD = compteDebite.getSolde();
				long SoldeCC = compteCredite.getSolde();
				compteDebite.setSolde(SoldeCD - montant);
				compteCredite.setSolde(SoldeCC + montant);
				compteservice.modifier(compteDebite);
				compteservice.modifier(compteCredite);
				
//				  Calendar cal = Calendar.getInstance();
//				  java.util.Date date2= cal.getTime();
				
				//java.util.Date date = new java.util.Date();
				Virement virement2 = new Virement(compteDebite, compteCredite, montant);
      
//				Virement virement = new Virement(compteDebite, compteCredite, date2, montant); ////ICIIIII

//				virementdao.sauverEnBase(virement);
				virementdao.sauverEnBase(virement2);

				log.fatal("Virement [Numero CompteD�bit� = " + compteDebite.getIdCompte() + ", Numero CompteCr�dit� = " + 
				compteCredite.getIdCompte() + ", Montant = " + montant + ", Nouveau solde du CompteD�bit� = "
				+ compteDebite.getSolde() + " �, Nouveau solde du Compte Cr�dit� = " +compteCredite.getSolde() +" � ]" );
				return true;
			}}
		else{
			if(montant>compteDebite.getSolde())throw new SaisieException("Le solde du compte d�bit� n�"
					+ compteDebite.getIdCompte() + " : " + compteDebite.getSolde() + "�, n'est pas assez �lev� pour effectuer un virement de " + montant +"�.");
			else{long SoldeCD = compteDebite.getSolde();
				long SoldeCC = compteCredite.getSolde();
				compteDebite.setSolde(SoldeCD - montant);
				compteCredite.setSolde(SoldeCC + montant);
				compteservice.modifier(compteDebite);
				compteservice.modifier(compteCredite);
				
				log.fatal("Virement [Numero CompteD�bit� = " + compteDebite.getIdCompte() + ", Numero CompteCr�dit� = " + 
				compteCredite.getIdCompte() + ", Montant = " + montant + ", Nouveau solde du CompteD�bit� = "
				+ compteDebite.getSolde() + " �, Nouveau solde du Compte Cr�dit� = " +compteCredite.getSolde() +" � ]" );
				return true;
			}
		}
		
	}
}
