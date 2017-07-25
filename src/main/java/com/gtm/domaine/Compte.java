package com.gtm.domaine;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/**
 * 
 * Classe abstraire domaine Compte avec ses parametres, constructeurs getters et setters
 * 
 *
 */
@Entity
public  class Compte {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private long solde;
	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name= "client_id")
	private Client client;
	/**
	 * 
	 * @param solde Fixe lors de la creation du compte
	 */
	public Compte(long solde) {
		super();
		this.solde = solde;
	}

	public Compte() {
		super();
	}

	public long getSolde() {
		return solde;
	}

	public void setSolde(long solde) {
		this.solde = solde;
	}

	public int getIdCompte() {
		return id;
	}

}
