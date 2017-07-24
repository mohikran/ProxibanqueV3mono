package com.gtm.presentation;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gtm.domaine.Client;
import com.gtm.domaine.Conseiller;
import com.gtm.service.IntClientCrudService;
import com.gtm.service.IntConseillerCrudService;

/**
 * Classe du package presentation. Est un bean gerant les actions sur les
 * Conseillers depuis la partie web et appelant les classes metiers
 * Ce bean a comme parametre SessionScoped
 *
 */

@Named
@SessionScoped
public class ConseillerBean implements Serializable {

	@Inject
	IntConseillerCrudService conseillerService;

	private Conseiller conseiller;

	public Conseiller getConseiller() {
		return conseiller;
	}

	// Setter conseiller
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	// Crée instanciation conseiller
	public ConseillerBean() {
		conseiller = new Conseiller();
	}

	/**
	 * Methode getListeConseiller servant a obtenir la liste de tous les clients
	 * en appelant la couche Service. Cette methode n'a pas de parametre
	 * 
	 * @return a liste de Conseil+ler qui lui a ete retourne par la couche
	 *         service
	 */
	public List<Conseiller> getListeConseiller() {
		List<Conseiller> listeConseiller = conseillerService.lireTous();
		return listeConseiller;

	}

	/**
	 * 
	 * Methode servant a rajouter un conseiller de la base de donnee en appelant
	 * la couche service IntConseillerCrudService N'a pas de parametre mais
	 * envoie un conseiller comme parametre en appelant la couche service
	 * 
	 * @return Un String renvoyant sur la page d'affichage de la liste des
	 *         conseillers : listeconseiller.xhtml
	 */
	public String addConseiller() {
		conseillerService.sauverEnBase(conseiller);
		return "listeconseiller";
	}

	/**
	 * Methode servant a supprimer un conseiller de la base de donnee en
	 * appelant la couche service IntConseillerCrudService N'a pas de parametre
	 * mais envoie un conseiller comme parametre en appelant la couche service
	 * 
	 */
	public void removeConseiller() {
		conseillerService.supprimer(conseiller.getIdConseiller());
	}

}
