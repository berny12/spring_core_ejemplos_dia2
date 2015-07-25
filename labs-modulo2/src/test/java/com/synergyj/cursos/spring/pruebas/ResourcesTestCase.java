/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.cursos.spring.pruebas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileCopyUtils;

import com.synergyj.cursos.spring.beans.ResourceBean;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
@ContextConfiguration("/resourcesAppContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourcesTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(ResourcesTestCase.class);

	@Resource
	ResourceBean bean;

	/**
	 * A) TODO inyectar el atributo <code>classpathPropertiesFile</code> con un resource ubicado en
	 * uno de los jars del JDK: /javax/sql/rowset/rowset.properties. Probar con y sin le prefijo
	 * classpath para validar que el recurso se busca en el classpath ya que el appContext fue
	 * creado via busqueda en classpath
	 * @throws IOException
	 */
	@Test
	public void getClassPathResource() throws IOException {
		ClassPathResource classPathResource;
		Properties p;

		classPathResource = (ClassPathResource) bean.getClasspathPropertiesFile();

		// B) TODO, ¿cuál de estas 2 líneas funciona sin problema?, Descomentar la correcta.
		// logger.debug("File: {}", classPathResource.getFile());
		// logger.debug("URL: {}", classPathResource.getURL());

		p = new Properties();
		p.load(classPathResource.getInputStream());

		logger.debug("property file: {}", p);
		logger.debug("salvando el archivo ");
		File file = new File("bin", classPathResource.getFilename());
		logger.debug("Ruta en donde guardara la informacion {}", file.getAbsolutePath());
		FileOutputStream salida = new FileOutputStream(file);
		FileCopyUtils.copy(classPathResource.getInputStream(), salida);
	}

	/**
	 * C) TODO Inyectar el atributo <code>expandedClasspathPropertiesFile</code> con un resource que
	 * se encuentra en el classpath en so forma expandida. El archivo está en
	 * src/main/resources/settings.properties
	 * @throws IOException
	 */
	@Test
	public void getExpendedClassPathResource() throws IOException {
		ClassPathResource classPathResource;
		Properties p;

		classPathResource = (ClassPathResource) bean.getExpandedClasspathPropertiesFile();

		// D) TODO, ¿cuál de estas 2 líneas funciona sin problema?, Descomentar la correcta.
		// logger.debug("File: {}", classPathResource.getFile());
		// logger.debug("URL: {}", classPathResource.getURL());

		p = new Properties();
		p.load(classPathResource.getInputStream());

		logger.debug("property file: {}", p);
		logger.debug("salvando el archivo ");
		File file = new File("bin", classPathResource.getFilename());
		logger.debug("Ruta en donde guardara la informacion {}", file.getAbsolutePath());
		FileOutputStream salida = new FileOutputStream(file);
		FileCopyUtils.copy(classPathResource.getInputStream(), salida);
	}

	/**
	 * E) TODO Inyectar el atributo <code>webPage</code> con el siguiente recurso:
	 * http://www.synergyj.com/spring/index.html
	 * @throws IOException
	 */
	@Test
	public void getURLResource() throws IOException {
		UrlResource urlResource;

		urlResource = (UrlResource) bean.getWebPage();
		String contenido;
		contenido = new String(FileCopyUtils.copyToByteArray(urlResource.getInputStream()));
		logger.debug("contenido de la pagina web: {}", contenido);
		logger.debug("salvando archivo");
		FileCopyUtils.copy(urlResource.getInputStream(),
				new FileOutputStream(new File("bin", urlResource.getFilename())));
	}

	/**
	 * TODO, inyectar el atributo <code>image</code> con la siguiente imágen que se encuentra en
	 * labs-modulo2/img/synergyj.jpg. <br>
	 * F) emplear una ruta relativa. <br>
	 * G) Emplear una ruta absoluta.
	 * @throws IOException
	 */
	@Test
	public void getImage() throws IOException {
		UrlResource fileResource;

		fileResource = (UrlResource) bean.getImage();
		logger.debug(" Salvando imagen: {}", fileResource.getURI());
		FileCopyUtils.copy(fileResource.getInputStream(),
				new FileOutputStream(new File("bin", fileResource.getFilename())));
	}
}
