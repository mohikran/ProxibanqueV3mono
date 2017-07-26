package com.gtm.domaine;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Virement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private Compte comptedebite;
	@OneToOne
	private Compte compteCredite;

	@Temporal(TemporalType.DATE)
	private Date date;
	
	int montant;

	public Virement(Compte comptedebite, Compte compteCredite, int montant) {
		super();
		this.comptedebite = comptedebite;
		this.compteCredite = compteCredite;
		this.montant = montant;
		this.date = new Date();
	}

	public Virement() {
		super();
	}

	public Virement(int id, Compte comptedebite, Compte compteCredite, int montant) {
		super();
		this.id = id;
		this.comptedebite = comptedebite;
		this.compteCredite = compteCredite;
		this.montant = montant;
	}

	
	public Virement(int id, Compte comptedebite, Compte compteCredite, Date date, int montant) {
		super();
		this.id = id;
		this.comptedebite = comptedebite;
		this.compteCredite = compteCredite;
		this.date = date;
		this.montant = montant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Compte getComptedebite() {
		return comptedebite;
	}

	public void setComptedebite(Compte comptedebite) {
		this.comptedebite = comptedebite;
	}

	public Compte getCompteCredite() {
		return compteCredite;
	}

	public void setCompteCredite(Compte compteCredite) {
		this.compteCredite = compteCredite;
	}

	@Override
	public String toString() {
		return "Virement [id=" + id + ", comptedebite=" + comptedebite + ", compteCredite=" + compteCredite + "]";
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

}
