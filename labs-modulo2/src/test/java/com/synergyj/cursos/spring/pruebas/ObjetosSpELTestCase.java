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
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
public class ObjetosSpELTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(ObjetosSpELTestCase.class);

	/**
	 * Creación y modificación de objetos.
	 * @throws Exception
	 */
	@Test
	public void creaYmodificaObjetos() throws Exception {
		ExpressionParser parser = new SpelExpressionParser();

		// TODO, A) crear una expresion que genere on objeto Long con el valor 6
		Expression exp = parser.parseExpression("<poner la expresión aquí>");

		assertTrue(exp.getValue() instanceof Long);
		assertEquals(6L, exp.getValue());

		// TODO, B) Crear una expresion que obtenga en número de bytes que ocupa la cadena
		// 'SynergyJ'. Tip: invocar a getBytes de la clase String y obtener el tamaño del arreglo de
		// bytes.
		exp = parser.parseExpression("<poner la expresión aquí>");
		int numBytes = exp.getValue(Integer.class);

		assertEquals("SynergyJ".getBytes().length, numBytes);

		// TODO, C) Crear una expresion que obtenga un arreglo de caracteres a partir de la literal
		// 'SynergyJ'
		exp = parser.parseExpression("<poner la expresión aquí>");
		char[] charArray = exp.getValue(char[].class);
		assertEquals("SynergyJ", new String(charArray));
	}

	/**
	 * Invocación de métos estaticos.
	 * @throws Exception
	 */
	@Test
	public void shouldInvoqueStaticMethods() throws Exception {
		ExpressionParser parser = new SpelExpressionParser();
		// TODO D), generar una expresion que invoque al método de clase random() de la clase Math
		// para generar un número aleatorio entre 0 y 99, emplear el prefijo 'T' que indica el tipo,
		// en este caso la clase Math
		Expression exp = parser.parseExpression("<poner la expresión aquí>");

		int value = exp.getValue(int.class);
		assertTrue(value >= 0 && value <= 99);
		logger.debug(" Valor aleatorio: {}", value);
	}

}
