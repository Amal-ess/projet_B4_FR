package com.dummy.myerp.consumeer;

import com.dummy.myerp.consumer.dao.impl.db.dao.ComptabiliteDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:com/dummy/myerp/consumer/applicationContext.xml")
@Transactional
@Rollback
public class ComptabiliteDaoImplIT {

	@Autowired
	private ComptabiliteDaoImpl comptabiliteDaoImpl;

	@Test
	void getInstance() {
		assertThat(comptabiliteDaoImpl).isNotNull();
	}

}
