package com.gtm.presentation;

import java.io.Serializable;
import java.util.List;

import com.gtm.domaine.Client;

public class ClientBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Client domaine
	private Client client;

	// Getter client
	public Client getClient() {
		return client;
	}

	// Setter client
	public void setClient(Client client) {
		this.client = client;
	}

	// Cr�e instanciation client
	public void ClientBeans() {
		client = new Client();
	}

	public List<Client> getListeClient() {
		System.out.println("Debut de la getListeClient");
		List<Client> ListeClient = null; // Pas encore de service
		return ListeClient;

	}

	public void addClient() {
		System.out.println("addClient bean");
		// APPEL DU SERVICE en utilisant client en parametre
	}

	public void removeClient() {
		System.out.println("RemoveClient bean");
		// APPEL DU SERVICE en utilisant client en parametre
	}
}
