/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.cursos.spring.beans;

import java.net.URL;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
// TODO F) Anotar este Bean
public class UserInfoAnotaciones {

	// TODO G) inyectar el valor con el property user.username
	private String username;

	// TODO H) inyectar el valor con el property user.password
	private String password;

	@Value("#{settings['user.sitio.web']}")
	private URL sitioWeb;

	@Value("#{settings['user.edad']}")
	private int edad;

	@Value("#{systemProperties['os.name']}")
	private String sistemaOperativo;

	@Value("#{systemProperties['os.version']}")
	private String versionSO;

	@Value("#{systemProperties['user.home']}")
	private String userHome;

	@Value(value = "#{userB.fechaLogin}")
	private Date fechaLogin;

	public Date getFechaLogin() {
		return fechaLogin;
	}

	public void setFechaLogin(Date fechaLogin) {
		this.fechaLogin = fechaLogin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public URL getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(URL sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public String getVersionSO() {
		return versionSO;
	}

	public void setVersionSO(String versionSO) {
		this.versionSO = versionSO;
	}

	public String getUserHome() {
		return userHome;
	}

	public void setUserHome(String userHome) {
		this.userHome = userHome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + ((fechaLogin == null) ? 0 : fechaLogin.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sistemaOperativo == null) ? 0 : sistemaOperativo.hashCode());
		result = prime * result + ((sitioWeb == null) ? 0 : sitioWeb.hashCode());
		result = prime * result + ((userHome == null) ? 0 : userHome.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((versionSO == null) ? 0 : versionSO.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfoAnotaciones other = (UserInfoAnotaciones) obj;
		if (edad != other.edad)
			return false;
		if (fechaLogin == null) {
			if (other.fechaLogin != null)
				return false;
		} else if (!fechaLogin.equals(other.fechaLogin))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sistemaOperativo == null) {
			if (other.sistemaOperativo != null)
				return false;
		} else if (!sistemaOperativo.equals(other.sistemaOperativo))
			return false;
		if (sitioWeb == null) {
			if (other.sitioWeb != null)
				return false;
		} else if (!sitioWeb.equals(other.sitioWeb))
			return false;
		if (userHome == null) {
			if (other.userHome != null)
				return false;
		} else if (!userHome.equals(other.userHome))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (versionSO == null) {
			if (other.versionSO != null)
				return false;
		} else if (!versionSO.equals(other.versionSO))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserInfo [username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", sitioWeb=");
		builder.append(sitioWeb);
		builder.append(", edad=");
		builder.append(edad);
		builder.append(", sistemaOperativo=");
		builder.append(sistemaOperativo);
		builder.append(", versionSO=");
		builder.append(versionSO);
		builder.append(", userHome=");
		builder.append(userHome);
		builder.append(", fechaLogin=");
		builder.append(fechaLogin);
		builder.append("]");
		return builder.toString();
	}

}
