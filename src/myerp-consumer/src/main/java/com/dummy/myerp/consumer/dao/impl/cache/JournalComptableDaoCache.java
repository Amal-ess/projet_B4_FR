package com.dummy.myerp.consumer.dao.impl.cache;

import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;

import java.util.List;


/**
 * Cache DAO de {@link JournalComptable}
 */
public class JournalComptableDaoCache {

	// ==================== Attributs ====================
	/**
	 * The List compte comptable.
	 */
	private List<JournalComptable> listJournalComptable;
	private final ComptabiliteDao comptabiliteDao;


	// ==================== Constructeurs ====================

	/**
	 * Instantiates a new Compte comptable dao cache.
	 *
	 * @param comptabiliteDao
	 */
	public JournalComptableDaoCache(ComptabiliteDao comptabiliteDao) {
		this.comptabiliteDao = comptabiliteDao;
	}


	// ==================== Méthodes ====================

	/**
	 * Gets by code.
	 *
	 * @param pCode le code du {@link JournalComptable}
	 * @return {@link JournalComptable} ou {@code null}
	 */
	public JournalComptable getByCode(String pCode) {
		if (listJournalComptable == null) {
			listJournalComptable = comptabiliteDao.getListJournalComptable();
		}

		JournalComptable vRetour = JournalComptable.getByCode(listJournalComptable, pCode);
		return vRetour;
	}
}
