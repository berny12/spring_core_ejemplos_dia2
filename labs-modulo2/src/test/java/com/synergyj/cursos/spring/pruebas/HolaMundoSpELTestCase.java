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

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
public class HolaMundoSpELTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(HolaMundoSpELTestCase.class);

	@Test
	public void testSpel() throws Exception {
		String message = null;
		// TODO, evaluar una expresion con SpEL empleando los siguientes puntos para que la prueba
		// sea exitosa.

		// 1) Creae una instancia de ExpressionParser para procesar las expresiones

		// 2) Crear un objeto Expression lista para ser evaluada a partir de una cadena entre
		// comillas que será parseada.

		// 3) evaluar la expresion y mostrar su resultado a través del método getValue()

		// 4) Evaluar la expresión recuperando el resultado con el uso de Genericos.

		assertEquals("SynergyJ", message);

		logger.debug("{}", message);

	}
}
