/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.cursos.spring.beans;

import org.springframework.core.io.Resource;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
public class ResourceBean {

	private Resource classpathPropertiesFile;

	private Resource expandedClasspathPropertiesFile;

	private Resource webPage;

	private Resource image;

	/**
	 * @return the classpathPropertiesFile
	 */
	public Resource getClasspathPropertiesFile() {
		return classpathPropertiesFile;
	}

	/**
	 * @param classpathPropertiesFile the classpathPropertiesFile to set
	 */
	public void setClasspathPropertiesFile(Resource classpathPropertiesFile) {
		this.classpathPropertiesFile = classpathPropertiesFile;
	}

	/**
	 * @return the expandedClasspathPropertiesFile
	 */
	public Resource getExpandedClasspathPropertiesFile() {
		return expandedClasspathPropertiesFile;
	}

	/**
	 * @param expandedClasspathPropertiesFile the expandedClasspathPropertiesFile to set
	 */
	public void setExpandedClasspathPropertiesFile(Resource expandedClasspathPropertiesFile) {
		this.expandedClasspathPropertiesFile = expandedClasspathPropertiesFile;
	}

	/**
	 * @return the webPage
	 */
	public Resource getWebPage() {
		return webPage;
	}

	/**
	 * @param webPage the webPage to set
	 */
	public void setWebPage(Resource webPage) {
		this.webPage = webPage;
	}

	/**
	 * @return the image
	 */
	public Resource getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Resource image) {
		this.image = image;
	}

}
