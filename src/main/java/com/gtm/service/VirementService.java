package com.gtm.service;

import org.apache.log4j.Logger;

import com.gtm.domaine.Compte;
import com.gtm.domaine.CompteCourant;
import com.gtm.domaine.CompteEpargne;
import com.gtm.exception.SaisieException;

public class VirementService {

	private final static Logger log = Logger.getLogger(VirementService.class);

	/*public boolean EffectuerVirement(CompteCourant compteDebite, Compte compteCredite, long montant) throws SaisieException{
		if(montant>(compteDebite.getSolde()+compteDebite.getPlafondDeDecouvert()))throw SaisieException("Le solde du compte "
				+ "d�bit� n'est pas assez �lev� pour effectuer ce virement");
		else{long SoldeCD = compteDebite.getSolde();
			long SoldeCC = compteCredite.getSolde();
			compteDebite.setSolde(SoldeCD - montant);
			compteCredite.setSolde(SoldeCC + montant);
			log.info("Virement [Numero CompteD�bit� = " + compteDebite.getIdCompte() + ", Numero CompteCr�dit� = " + 
			compteCredite.getIdCompte() + ", Montant = " + montant + ", Nouveau solde du CompteD�bit� = "
			+ compteDebite.getSolde() + " �, Nouveau solde du Compte Cr�dit� = " +compteCredite.getSolde() +" � ]" );
		}}

	public boolean EffectuerVirement(CompteEpargne compteDebite, Compte compteCredite, long montant) throws SaisieException{
			if(montant>compteDebite.getSolde())throw SaisieException("Le solde du compte "
					+ "d�bit� n'est pas assez �lev� pour effectuer ce virement");
			else{long SoldeCD = compteDebite.getSolde();
				long SoldeCC = compteCredite.getSolde();
				compteDebite.setSolde(SoldeCD - montant);
				compteCredite.setSolde(SoldeCC + montant);
				log.info("Virement [Numero CompteD�bit� = " + compteDebite.getIdCompte() + ", Numero CompteCr�dit� = " + 
				compteCredite.getIdCompte() + ", Montant = " + montant + ", Nouveau solde du CompteD�bit� = "
				+ compteDebite.getSolde() + " �, Nouveau solde du Compte Cr�dit� = " +compteCredite.getSolde() +" � ]" );
			}
		
	}*/
}
