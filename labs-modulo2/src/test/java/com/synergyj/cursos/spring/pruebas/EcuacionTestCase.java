/**
 * Fecha de creación: 16/11/2013 10:50:19
 *
 * Copyright (c) 2012 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.cursos.spring.pruebas;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
public class EcuacionTestCase {

	@Test
	public void resuelveEcuacion() {

		ExpressionParser parser;
		Expression exp;
		Double x1 = 0.0, x2 = 0.0;

		parser = new SpelExpressionParser();

		// la ecuacion es x^2+10x+21

		// para x1
		// TODO, completar este test case para obtener X1

		exp = parser.parseExpression("(10+T(Math).sqrt(10^2-(4*(1*21))))/2");
		x1 = exp.getValue(Double.class);
		Assert.assertEquals(new Double(7), x1);

		// para x2
		// TODO, completar este test case para obtener X2
		exp = parser.parseExpression("(10-T(Math).sqrt(10^2-(4*(1*21))))/2");
		x2 = exp.getValue(Double.class);
		Assert.assertEquals(new Double(3), x2);

	}

}
