package com.dummy.myerp.model.bean.comptabilite;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Bean représentant une séquence pour les références d'écriture comptable
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SequenceEcritureComptable {
    // ==================== Attributs ====================
    /** L'année */
    private Integer annee;
    /** La dernière valeur utilisée */
    private Integer derniereValeur;
}
