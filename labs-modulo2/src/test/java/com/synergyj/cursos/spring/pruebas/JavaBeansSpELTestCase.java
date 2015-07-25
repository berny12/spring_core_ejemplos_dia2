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

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.synergyj.cursos.spring.beans.Gasto;
import com.synergyj.cursos.spring.beans.Nombre;
import com.synergyj.cursos.spring.beans.Persona;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
public class JavaBeansSpELTestCase {
	private Persona persona;

	@Before
	public void initPersona() {
		persona = new Persona();
		Nombre nombre = new Nombre();
		nombre.setNombre("Benito");
		nombre.setApellidoPaterno("Juarez");
		nombre.setApellidoMaterno("Garcia");

		persona.setNombre(nombre);
		persona.setFechaDeNacimiento(new Date());
		persona.setNacionalidad("Mexicana");
	}

	@Test
	public void shouldAccessProperties() throws Exception {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("nacionalidad");

		// empleo de un EvaluationContext
		StandardEvaluationContext context = new StandardEvaluationContext();
		context.setRootObject(persona);
		String nacionalidad = exp.getValue(context, String.class);
		assertEquals("Mexicana", nacionalidad);

		// sin evaluation context
		nacionalidad = exp.getValue(persona, String.class);
		assertEquals("Mexicana", nacionalidad);

		// validando apellido paterno
		// TODO A) Generar una expresion que obtenga el apellido paterno
		exp = parser.parseExpression("<poner expresion aqui>");
		String apellidoPaterno = exp.getValue(context, String.class);
		assertEquals("Juarez", apellidoPaterno);

		exp = parser.parseExpression("nacionalidad.equals('Mexicana')");
		Assert.assertTrue(exp.getValue(context, Boolean.class));

		// TODO B) Escribir una expresión que compare la literal 'Mexicana' con el atributo
		// nacionalidad pero ahora empleando el operador ==, validar el resultado con su aserción
		// correspondiente.
		exp = parser.parseExpression("<poner expresion aqui>");
		// poner assert aqui.
	}

	/**
	 * Uso de setValue
	 */
	@Test
	public void setValueExample() {

		ExpressionParser parser;
		Expression exp;
		StandardEvaluationContext context;
		Gasto gasto;
		// inicializa la lista con un valor.
		persona.setUltimosGastos(new ArrayList<Gasto>());
		gasto = new Gasto();
		gasto.setDescripcion("Bebidas de fin de semana");
		gasto.setImporte(2300.35);
		persona.getUltimosGastos().add(gasto);
		context = new StandardEvaluationContext(persona);
		parser = new SpelExpressionParser();

		// TODO C), generar una expresion para obtener el valor del atributo importe que corresponde
		// al primer elemento de la lista. Manejar a la lista de ultimos gastos como si fuera un
		// arreglo.
		exp = parser.parseExpression("<poner expresión aquí>");

		// TODO D) actualizar el valor de los gastos a 5500.54 empleando el métod setValue del
		// objeto exp

		assertEquals(new Double(persona.getUltimosGastos().get(0).getImporte()),
				new Double(5500.54));
	}

	/**
	 * Uso de SpelParserConfiguration, observar que ya no se requiere instanciar la colección ni
	 * inicializarla a traves de las banderas autoGrowNullReferences y autoGrowCollections
	 */
	@Test
	public void parserConfigurationExample() {

		ExpressionParser parser;
		Expression exp;
		StandardEvaluationContext context;
		SpelParserConfiguration config = null;

		context = new StandardEvaluationContext(persona);

		// TODO E) Agregar aqui la configuracion de SpelParserConfiguration (inicializar variable
		// config)

		parser = new SpelExpressionParser(config);
		exp = parser.parseExpression("ultimosGastos[5].descripcion");
		exp.setValue(context, "gastos de vacaciones");
		exp = parser.parseExpression("ultimosGastos[5].importe");
		exp.setValue(context, 19456.3);

		Assert.assertEquals(persona.getUltimosGastos().get(5).getDescripcion(),
				"gastos de vacaciones");
		Assert.assertEquals(new Double(persona.getUltimosGastos().get(5).getImporte()),
				new Double(19456.3));

	}
}
