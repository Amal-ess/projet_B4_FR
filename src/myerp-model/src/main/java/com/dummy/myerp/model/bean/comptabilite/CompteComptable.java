package com.dummy.myerp.model.bean.comptabilite;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;


/**
 * Bean représentant un Compte Comptable
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CompteComptable {
	// ==================== Attributs ====================
	/**
	 * The Numero.
	 */
	@NotNull
	private Integer numero;

	/**
	 * The Libelle.
	 */
	@NotNull
	@Size(min = 1, max = 150)
	private String libelle;


	// ==================== Constructeurs ====================

	/**
	 * Instantiates a new Compte comptable.
	 *
	 * @param pNumero the numero
	 */
	public CompteComptable(Integer pNumero) {
		numero = pNumero;
	}

	/**
	 * Instantiates a new Compte comptable.
	 *
	 * @param pNumero  the numero
	 * @param pLibelle the libelle
	 */
	public CompteComptable(Integer pNumero, String pLibelle) {
		numero = pNumero;
		libelle = pLibelle;
	}


	// ==================== Méthodes ====================

	// ==================== Méthodes STATIC ====================

	/**
	 * Renvoie le {@link CompteComptable} de numéro {@code pNumero} s'il est présent dans la liste
	 *
	 * @param pList   la liste où chercher le {@link CompteComptable}
	 * @param pNumero le numero du {@link CompteComptable} à chercher
	 * @return {@link CompteComptable} ou {@code null}
	 */
	public static CompteComptable getByNumero(List<? extends CompteComptable> pList, Integer pNumero) {
		CompteComptable vRetour = null;
		for (CompteComptable vBean : pList) {
			if (vBean != null && Objects.equals(vBean.getNumero(), pNumero)) {
				vRetour = vBean;
				break;
			}
		}
		return vRetour;
	}
}
