package com.biblio.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.biblio.pojo.valid.PersistenceGroup;
import com.biblio.pojo.valid.SpringFormGroup;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@NotEmpty(message = Constants.NOT_EMPTY, groups = { PersistenceGroup.class, SpringFormGroup.class })
	@Size(max = 15, message = Constants.SIZE, groups = { SpringFormGroup.class })
	private String usuario;

	@NotEmpty(message = Constants.NOT_EMPTY, groups = { PersistenceGroup.class, SpringFormGroup.class })
	@Size(max = 20, message = Constants.SIZE, groups = { SpringFormGroup.class })
	private String nombres;

	@NotEmpty(message = Constants.NOT_EMPTY, groups = { PersistenceGroup.class, SpringFormGroup.class })
	@Size(max = 25, message = Constants.SIZE, groups = { SpringFormGroup.class })
	private String apellidos;

	@NotEmpty(message = Constants.NOT_EMPTY, groups = { PersistenceGroup.class, SpringFormGroup.class })
	@Size(max = 100, message = Constants.SIZE, groups = { SpringFormGroup.class })
	private String password;

	public Usuario() {

	}

	public Usuario(int idUsuario, String usuario, String nombres, String apellidos, String password) {
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.password = password;
	}

	public Usuario(String usuario, String nombres, String apellidos, String password) {
		this.usuario = usuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.password = password;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario + ", nombres=" + nombres + ", apellidos="
				+ apellidos + ", password=" + password + "]";
	}

}
