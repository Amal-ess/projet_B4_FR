package com.dummy.myerp.consumer.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>Classe d'accès aux datasource</p>
 */
public class DbConsumer {

// ==================== Attributs Static ====================
	/**
	 * Logger Log4j pour la classe
	 */
	private static final Logger LOGGER = LogManager.getLogger(DbConsumer.class);
	/**
	 * Map des DataSources
	 */
	private Map<DataSourcesEnum, DataSource> mapDataSource = new HashMap<>(DataSourcesEnum.values().length);

	/**
	 * Méthode de configuration de la classe
	 *
	 * @param pMapDataSource -
	 */
	public DbConsumer(Map<DataSourcesEnum, DataSource> pMapDataSource) {
		// On pilote l'ajout avec l'Enum et on ne rajoute pas tout à l'aveuglette...
		//   ( pas de AbstractDbDao.mapDataSource.putAll(...) )
		DataSourcesEnum[] vDataSourceIds = DataSourcesEnum.values();
		for (DataSourcesEnum vDataSourceId : vDataSourceIds) {
			DataSource vDataSource = pMapDataSource.get(vDataSourceId);
			// On test si la DataSource est configurée
			// (NB : elle est considérée comme configurée si elle est dans pMapDataSource mais à null)
			if (vDataSource == null) {
				if (!pMapDataSource.containsKey(vDataSourceId)) {
					LOGGER.error("La DataSource " + vDataSourceId + " n'a pas été initialisée !");
				}
			} else {
				mapDataSource.put(vDataSourceId, vDataSource);
			}
		}
	}

	// ==================== Méthodes ====================

	/**
	 * Renvoie le {@link DataSource} associé demandée
	 *
	 * @param pDataSourceId -
	 * @return SimpleJdbcTemplate
	 */
	public DataSource getDataSource(DataSourcesEnum pDataSourceId) {
		DataSource vRetour = this.mapDataSource.get(pDataSourceId);
		if (vRetour == null) {
			throw new UnsatisfiedLinkError("La DataSource suivante n'a pas été initialisée : " + pDataSourceId);
		}
		return vRetour;
	}


	/**
	 * Renvoie le dernière valeur utilisé d'une séquence
	 *
	 * <p><i><b>Attention : </b>Méthode spécifique au SGBD PostgreSQL</i></p>
	 *
	 * @param <T>            : La classe de la valeur de la séquence.
	 * @param pDataSourcesId : L'identifiant de la {@link DataSource} à utiliser
	 * @param pSeqName       : Le nom de la séquence dont on veut récupérer la valeur
	 * @param pSeqValueClass : Classe de la valeur de la séquence
	 * @return la dernière valeur de la séquence
	 */
	public  <T> T queryGetSequenceValuePostgreSQL(DataSourcesEnum pDataSourcesId,
													String pSeqName, Class<T> pSeqValueClass) {

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource(pDataSourcesId));
		String vSeqSQL = "SELECT last_value FROM " + pSeqName;
		T vSeqValue = vJdbcTemplate.queryForObject(vSeqSQL, pSeqValueClass);

		return vSeqValue;
	}

}
