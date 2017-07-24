package com.gtm.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gtm.domaine.Client;
import com.gtm.domaine.Compte;
import com.gtm.exception.SaisieException;
import com.gtm.service.IntClientCrudService;
import com.gtm.service.IntCompteCrudService;
import com.gtm.service.VirementService;

@Named
@SessionScoped
public class CompteBean implements Serializable {

	private Compte compte;
	private int numerocompte1; 
	private int numerocompte2;
	private int montant;
	
	@Inject
	IntCompteCrudService compteservice;
	
	@Inject
	VirementService virementservice;
	
	@PostConstruct
	public void init(){
		numerocompte1 = 1;
		montant = 5;
	}

	//Getter Compte
	public Compte getCompte() {
		return compte;
	}

	// Setter Compte
	public void Compte(Compte compte) {
		this.compte = compte;
	}
	
	public CompteBean() {
		compte = new Compte();
	}
	
	
	public int getNumerocompte1() {
		return numerocompte1;
	}

	public void setNumerocompte1(int numerocompte1) {
		this.numerocompte1 = numerocompte1;
	}

	public int getNumerocompte2() {
		return numerocompte2;
	}

	public void setNumerocompte2(int numerocompte2) {
		this.numerocompte2 = numerocompte2;
	}
	
	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public List<Compte> getListeCompte() {
		List<Compte> listeCompte = null;
		listeCompte = compteservice.lireTous();
		return listeCompte;

	}
	
	public String virement(){
		System.out.println("je suis la");
		Compte compteDebite = compteservice.lireById(numerocompte1);
		Compte compteCredite = compteservice.lireById(numerocompte2);

		try {
			virementservice.EffectuerVirement(compteDebite, compteCredite, montant);
			
			return "listeclient";
		} catch (SaisieException e) {
			
		}
		return "page404"; 
	}
}
