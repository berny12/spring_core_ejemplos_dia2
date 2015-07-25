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
		// para x1
		// TODO, completar este test case para obtener X1
		Assert.assertEquals(new Double(7), x1);

		// para x2
		// TODO, completar este test case para obtener X2
		Assert.assertEquals(new Double(3), x2);

	}

}
