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
 * Bean représentant un Journal Comptable
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class JournalComptable {

	// ==================== Attributs ====================
	/**
	 * code
	 */
	@NotNull
	@Size(min = 1, max = 5)
	private String code;

	/**
	 * libelle
	 */
	@NotNull
	@Size(min = 1, max = 150)
	private String libelle;


	// ==================== Constructeurs ====================

	/**
	 * Instantiates a new Journal comptable.
	 *
	 * @param pCode    the p code
	 * @param pLibelle the p libelle
	 */
	public JournalComptable(String pCode, String pLibelle) {
		code = pCode;
		libelle = pLibelle;
	}


	// ==================== Méthodes ====================


	// ==================== Méthodes STATIC ====================

	/**
	 * Renvoie le {@link JournalComptable} de code {@code pCode} s'il est présent dans la liste
	 *
	 * @param pList la liste où chercher le {@link JournalComptable}
	 * @param pCode le code du {@link JournalComptable} à chercher
	 * @return {@link JournalComptable} ou {@code null}
	 */
	public static JournalComptable getByCode(List<? extends JournalComptable> pList, String pCode) {
		JournalComptable vRetour = null;
		for (JournalComptable vBean : pList) {
			if (vBean != null && Objects.equals(vBean.getCode(), pCode)) {
				vRetour = vBean;
				break;
			}
		}
		return vRetour;
	}
}
