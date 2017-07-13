package com.gtm.service;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.gtm.domaine.Compte;
import com.gtm.domaine.CompteCourant;
import com.gtm.domaine.CompteEpargne;
import com.gtm.exception.SaisieException;

@Named
@SessionScoped
public class VirementService implements Serializable{

	private final static Logger log = Logger.getLogger(VirementService.class);

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

	public boolean EffectuerVirement(Compte compteDebite, Compte compteCredite, int montant) throws SaisieException{
			if(montant>compteDebite.getSolde())throw new SaisieException("Le solde du compte "
					+ "d�bit� n'est pas assez �lev� pour effectuer ce virement");
			else{long SoldeCD = compteDebite.getSolde();
				long SoldeCC = compteCredite.getSolde();
				compteDebite.setSolde(SoldeCD - montant);
				compteCredite.setSolde(SoldeCC + montant);
				log.info("Virement [Numero CompteD�bit� = " + compteDebite.getIdCompte() + ", Numero CompteCr�dit� = " + 
				compteCredite.getIdCompte() + ", Montant = " + montant + ", Nouveau solde du CompteD�bit� = "
				+ compteDebite.getSolde() + " �, Nouveau solde du Compte Cr�dit� = " +compteCredite.getSolde() +" � ]" );
				return true;
			}
		
	}
}
