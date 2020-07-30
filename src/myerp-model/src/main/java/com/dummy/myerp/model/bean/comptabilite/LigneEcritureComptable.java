package com.dummy.myerp.model.bean.comptabilite;

import com.dummy.myerp.model.validation.constraint.MontantComptable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


/**
 * Bean représentant une Ligne d'écriture comptable.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LigneEcritureComptable {

	// ==================== Attributs ====================
	/**
	 * Compte Comptable
	 */
	@NotNull
	private CompteComptable compteComptable;

	/**
	 * The Libelle.
	 */
	@Size(max = 200)
	private String libelle;

	/**
	 * The Debit.
	 */
	@MontantComptable
	private BigDecimal debit;

	/**
	 * The Credit.
	 */
	@MontantComptable
	private BigDecimal credit;

}
