/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.cursos.spring.pruebas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.synergyj.cursos.spring.beans.UserInfo;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
public class VariablesYColeccionesSpELTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(VariablesYColeccionesSpELTestCase.class);

	private List<UserInfo> userList;

	@Before
	public void buildList() {
		userList = new ArrayList<UserInfo>();
		userList.add(new UserInfo("Paco"));
		userList.add(new UserInfo("Luis"));
		userList.add(new UserInfo("Pedro"));
		userList.add(new UserInfo("Lucas"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void makeSubListWithSpEL() {
		ExpressionParser parser;
		Expression exp;
		List<UserInfo> list;
		UserInfo userInfo;
		parser = new SpelExpressionParser();

		// TODO A) generar una expresión que regrese a todos los nombres que
		// inicien con 'P'
		exp = parser.parseExpression("?[username.startsWith('P')]");

		list = (List<UserInfo>) exp.getValue(userList);
		logger.debug("Lista filtrada {}", list);
		for (UserInfo user : list) {
			Assert.assertTrue(user.getUsername().startsWith("P"));
		}
		// TODO B) generar una expresión que regrese el primer elemento que
		// inicie con 'P'
		exp = parser.parseExpression("^[username.startsWith('P')]");

		userInfo = exp.getValue(userList, UserInfo.class);
		logger.debug("El primer valor: {}", userInfo);
		Assert.assertEquals("Paco", userInfo.getUsername());
	}

	/**
	 * Este tescase hace uso de SpEL para construir un Map (directorio
	 * telefonico) y después a través del uso de otra expresion, se obtiene otro
	 * Map pero solamente con los telefonos del DF, osea que inician con 55. Se
	 * hace uso de variables, y de la variable #this, la cual apunta al objeto
	 * actual (elemento del mapa) al que se le esta aplicando la expresion que
	 * esta entre corchetes.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void showTelephones() {
		Map<String, String> telephones;
		Map<String, String> submap;

		Expression exp;
		StandardEvaluationContext context;

		context = new StandardEvaluationContext();
		ExpressionParser parser = new SpelExpressionParser();
		// observar la construccion de un mapa.
		exp = parser
				.parseExpression("{casa:'55992930239',oficina:'557838493',vallarta:'3392983023'}");
		telephones = exp.getValue(Map.class);

		context.setVariable("map", telephones);

		// observar el uso de #this
		exp = parser
				.parseExpression("#map.?[#this.getValue().startsWith('55')]");
		submap = exp.getValue(context, Map.class);

		logger.debug("Telefonos del DF: {}", submap);
		for (Entry<String, String> entry : submap.entrySet()) {
			Assert.assertTrue(entry.getValue().startsWith("55"));
		}
		// TODO C) generar una expresion que obtenga los telefonos que sean de
		// casa.
		exp = parser.parseExpression("#map.?[#this.getKey().equals('casa')]");
		submap = exp.getValue(context, Map.class);

		logger.debug("Telefonos de casa: {}", submap);
		for (Entry<String, String> entry : submap.entrySet()) {
			Assert.assertTrue(entry.getKey().equals("casa"));
		}

		logger.debug("validando el objeto root.");
		exp = parser.parseExpression("#root.length()");
		String root = "Root Object";
		context.setRootObject(root);
		Assert.assertTrue(exp.getValue(context, Integer.class) == 11);
	}
}
