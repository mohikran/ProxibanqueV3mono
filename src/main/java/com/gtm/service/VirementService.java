package com.gtm.service;

import com.gtm.domaine.Compte;
import com.gtm.exception.SaisieException;

public class VirementService {

	public boolean EffectuerVirement(Compte compteDebite, Compte compteCredite, double montant) throws SaisieException{
		if(montant>compteDebite.getSolde())throw SaisieException("Le solde du compte d�bit� n'est pas assez �lev� pour effectuer ce virement")
		
	}
}
