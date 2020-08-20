package com.dummy.myerp.model.bean.comptabilite;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Bean représentant une Écriture Comptable
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EcritureComptable {

	// ==================== Attributs ====================
	/**
	 * The Id.
	 */
	private Integer id;
	/**
	 * Journal comptable
	 */
	@NotNull
	private JournalComptable journal;
	/**
	 * The Reference.
	 * Ex : 12345-1234/12345
	 */
	//fixme
	@Pattern(regexp = "\\w{1,5}-\\d{4}/\\d{5}")
	private String reference;
	/**
	 * The Date.
	 */
	@NotNull
	private Date date;

	/**
	 * The Libelle.
	 */
	@NotNull
	@Size(min = 1, max = 200)
	private String libelle;

	/**
	 * La liste des lignes d'écriture comptable.
	 */
	@Valid
	@Size(min = 2)
	private final List<LigneEcritureComptable> listLigneEcriture = new ArrayList<>();

	// ==================== Méthodes ====================


	/**
	 * Calcul et renvoie le total des montants au débit des lignes d'écriture
	 *
	 * @return {@link BigDecimal}, {@link BigDecimal#ZERO} si aucun montant au débit
	 */
	// TODO à tester
	public BigDecimal getTotalDebit() {
		BigDecimal vRetour = BigDecimal.ZERO;
		for (LigneEcritureComptable vLigneEcritureComptable : listLigneEcriture) {
			if (vLigneEcritureComptable.getDebit() != null) {
				vRetour = vRetour.add(vLigneEcritureComptable.getDebit());
			}
		}
		return vRetour;
	}

	/**
	 * Calcul et renvoie le total des montants au crédit des lignes d'écriture
	 *
	 * @return {@link BigDecimal}, {@link BigDecimal#ZERO} si aucun montant au crédit
	 */
	public BigDecimal getTotalCredit() {
		BigDecimal vRetour = BigDecimal.ZERO;
		for (LigneEcritureComptable vLigneEcritureComptable : listLigneEcriture) {
			if (vLigneEcritureComptable.getCredit() != null) {
				vRetour = vRetour.add(vLigneEcritureComptable.getCredit());
			}
		}
		return vRetour;
	}

	/**
	 * Renvoie si l'écriture est équilibrée (TotalDebit = TotalCrédit)
	 *
	 * @return boolean
	 */
	public boolean isEquilibree() {
		boolean vRetour = this.getTotalDebit().compareTo(getTotalCredit()) == 0;
		return vRetour;
	}
}
