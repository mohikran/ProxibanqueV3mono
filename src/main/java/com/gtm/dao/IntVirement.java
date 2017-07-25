package com.gtm.dao;

import com.gtm.domaine.Conseiller;
import com.gtm.domaine.Virement;

public interface IntVirement extends IntGenericCrudDao<Virement> {

	Class<Virement> getClazz();

}
