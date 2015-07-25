/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.cursos.spring.pruebas;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.synergyj.cursos.spring.beans.UserInfo;
import com.synergyj.cursos.spring.beans.UserInfoAnotaciones;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
@ContextConfiguration("/XMLAnotacionesSpELAppContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class XMLAnotacionesSpELTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(XMLAnotacionesSpELTestCase.class);

	@Resource
	private UserInfo userA;

	@Resource
	private UserInfo userB;

	// TODO I) Inyectar la referencia de este bean.
	@Resource
	private UserInfoAnotaciones userC;

	@Test
	public void userInfoExample() throws IllegalAccessException,
			InvocationTargetException {
		logger.debug("user A {}", userA);
		logger.debug("user B {}", userB);
		Assert.assertEquals(userA, userB);
		logger.debug("valudando user C {}", userC);
		Assert.assertNotNull(userC);
		Assert.assertNotNull(userC.getUsername());
		Assert.assertNotNull(userC.getPassword());
	}

	@Test
	public void mytest() {

	}

}
