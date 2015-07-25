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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
public class OperadoresSpELTestCase {

	@Test
	public void testRelationalOperators() {
		ExpressionParser parser = new SpelExpressionParser();
		assertTrue(parser.parseExpression("2==2").getValue(boolean.class));
		assertTrue(parser.parseExpression("2<3").getValue(boolean.class));
		assertTrue(parser.parseExpression("3>2").getValue(boolean.class));
		// TODO A) generar un assert para evaluar esta expresión: 0!=1
		// para agregar operadores relacionales
		assertTrue(parser.parseExpression("0!=1").getValue(boolean.class));

	}

	@Test
	public void testLogicalOperators() {
		ExpressionParser parser = new SpelExpressionParser();
		assertTrue(parser.parseExpression("true and true").getValue(
				boolean.class));
		assertTrue(parser.parseExpression("true or true").getValue(
				boolean.class));
		assertTrue(parser.parseExpression("!false").getValue(boolean.class));
		assertTrue(parser.parseExpression("not false").getValue(boolean.class));
		// TODO B) generar un assert para evaluar esta expresión: true and
		// notfalse
		assertTrue(parser.parseExpression("true and not false").getValue(
				boolean.class));
	}

	@Test
	public void testMathematicalOperators() {
		ExpressionParser parser = new SpelExpressionParser();
		assertSame(2, parser.parseExpression("1+1").getValue(int.class));
		assertSame(0, parser.parseExpression("1-1").getValue(int.class));
		assertSame(1, parser.parseExpression("1/1").getValue(int.class));
		assertSame(1, parser.parseExpression("1*1").getValue(int.class));
		// TODO C) generar un assert para evaluar esta expresión: 3^3
		assertSame(27, parser.parseExpression("3^3").getValue(int.class));

		assertTrue(1D == parser.parseExpression("1e0").getValue(double.class));
		// TODO D) generar un assert para evaluar esta expresión: 'foo'+'bar'
		assertEquals("foobar",
				parser.parseExpression("'foo'+'bar'").getValue(String.class));
	}

	/**
	 * Operador Elvis ?: Es muy similar al ternario de Java, pero hace la
	 * evaluacion y regresa el valor por defecto si la expresion es nula.
	 * 
	 * <pre>
	 *  Operador ternario
	 *  val = something==true ? something : defaultValue 
	 * 
	 * Operador Elvis
	 * val = something ?: defaultValue
	 * </pre>
	 * 
	 * Operador de navegacion segura Previene los NullPointerException, basado
	 * en el lenguaje Groovy Se usa para evitar escribir:
	 * 
	 * <pre>
	 * if(variable != null) { //usar variable una vez que no es nulo 
	 *    variable.metodo() 
	 * } 
	 * En Groovy se usa asi: variable?.metodo()
	 * </pre>
	 */
	@Test
	public void testTernaryElvisAndSafeNavigationOperators() {
		ExpressionParser parser = new SpelExpressionParser();
		// Operador ternario, disponible en Java
		assertEquals("foo", parser.parseExpression("true ? 'foo' : 'bar'")
				.getValue(String.class));

		// operador elvis
		// TODO E) generar un assertequals para evaluar esta expresión:
		// null?:'es nulo'
		assertEquals("es nulo", parser.parseExpression("null?:'es nulo'")
				.getValue(String.class));
		// TODO F) generar un assertequals para evaluar esta expresión:
		// 'hola'?:'hello'
		assertEquals("hola", parser.parseExpression("'hola'?:'hello'")
				.getValue(String.class));
		// TODO G) generar un assertequals para evaluar esta expresión:
		// 3>4?:'suma'
		assertEquals(false, parser.parseExpression("3>4?:'suma'").getValue());
		// navegacion segura, se intenta invocar al metodo foo de un objeto
		// nulo, no lanza
		// NullPointerException.
		assertEquals(null,
				parser.parseExpression("null?.foo()").getValue(String.class));

		// TODO H) Construir un assertEquals para evaluar la expresion:
		// new
		// com.synergyj.cursos.spring.beans.UserInfo().password?.toUpperCase()
		assertEquals(
				null,
				parser.parseExpression(
						"new com.synergyj.cursos.spring.beans.UserInfo().password?.toUpperCase()")
						.getValue(String.class));
	}
}
