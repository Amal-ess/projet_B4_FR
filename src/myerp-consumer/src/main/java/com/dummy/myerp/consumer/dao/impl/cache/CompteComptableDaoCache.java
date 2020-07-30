package com.dummy.myerp.consumer.dao.impl.cache;

import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;

import java.util.List;


/**
 * Cache DAO de {@link CompteComptable}
 */
public class CompteComptableDaoCache {

	// ==================== Attributs ====================
	/**
	 * The List compte comptable.
	 */
	private List<CompteComptable> listCompteComptable;
	private final ComptabiliteDao comptabiliteDao;


	// ==================== Constructeurs ====================

	/**
	 * Instantiates a new Compte comptable dao cache.
	 *
	 * @param comptabiliteDao
	 */
	public CompteComptableDaoCache(ComptabiliteDao comptabiliteDao) {
		this.comptabiliteDao = comptabiliteDao;
	}


	// ==================== Méthodes ====================

	/**
	 * Gets by numero.
	 *
	 * @param pNumero the numero
	 * @return {@link CompteComptable} ou {@code null}
	 */
	public CompteComptable getByNumero(Integer pNumero) {
		if (listCompteComptable == null) {
			listCompteComptable = comptabiliteDao.getListCompteComptable();
		}

		CompteComptable vRetour = CompteComptable.getByNumero(listCompteComptable, pNumero);
		return vRetour;
	}
}
