package com.dummy.myerp.business.impl.manager;

import com.dummy.myerp.business.contrat.manager.ComptabiliteManager;
import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;


/**
 * Classe de test de l'initialisation du contexte Spring
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:bootstrapContext.xml")
public class InitSpringIT {

	@Autowired
	private ComptabiliteManager comptabiliteManager;

	@Autowired
	private ComptabiliteDao comptabiliteDao;

	/**
	 * Teste l'initialisation du contexte Spring
	 */
	@Test
	public void testInit() {
		assertThat(comptabiliteDao).isNotNull();
		assertThat(comptabiliteManager).isNotNull();
	}
}
