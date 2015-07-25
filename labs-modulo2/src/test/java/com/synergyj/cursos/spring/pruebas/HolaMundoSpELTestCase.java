/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.cursos.spring.pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
public class HolaMundoSpELTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(HolaMundoSpELTestCase.class);

	@Test
	public void testSpel() throws Exception {
		String message = null;
		// TODO, evaluar una expresion con SpEL empleando los siguientes puntos
		// para que la prueba
		// sea exitosa.

		// 1) Creae una instancia de ExpressionParser para procesar las
		// expresiones

		ExpressionParser expressionParser = new SpelExpressionParser();

		// 2) Crear un objeto Expression lista para ser evaluada a partir de una
		// cadena entre
		// comillas que será parseada.

		Expression exp = expressionParser.parseExpression("'SynergyJ'");

		// 3) evaluar la expresion y mostrar su resultado a través del método
		// getValue()

		message = (String) exp.getValue();
		// 4) Evaluar la expresión recuperando el resultado con el uso de
		// Genericos.

		message = exp.getValue(String.class);

		assertEquals("SynergyJ", message);

		logger.debug("{}", message);

	}
}
