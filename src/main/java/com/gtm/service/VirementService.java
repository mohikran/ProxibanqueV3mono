package com.gtm.service;

import org.apache.log4j.Logger;

import com.gtm.domaine.Compte;
import com.gtm.domaine.CompteCourant;
import com.gtm.domaine.CompteEpargne;
import com.gtm.exception.SaisieException;
/**
 * Service dedie aux methodes de virement
 * @author Stagiaire
 *
 */
public class VirementService {

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

	/**
	 * M�thode permettant de effectuer un virement entre deux compte
	 * @param compteDebite
	 * @param compteCredite
	 * @param montant du virement
	 * @return un boolean pour pouvoir tester la m�thode
	 * @throws SaisieException
	 */
	public boolean EffectuerVirement(Compte compteDebite, Compte compteCredite, long montant) throws SaisieException{
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
