package com.gtm.dao;

import java.io.Serializable;

import javax.swing.InputVerifier;

import com.gtm.domaine.Conseiller;
import com.gtm.domaine.Virement;

public class VirementDao extends GenericCrudDao<Virement> implements Serializable, IntVirement{

	@Override
	public
	Class<Virement> getClazz() {
		// TODO Auto-generated method stub
		return null;
	}

}
