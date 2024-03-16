package com.biblio.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.biblio.pojo.valid.PersistenceGroup;
import com.biblio.pojo.valid.SpringFormGroup;

@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAutor;

	@NotEmpty(message = Constants.NOT_EMPTY, groups = { PersistenceGroup.class, SpringFormGroup.class })
	@Size(max = 150, message = Constants.SIZE, groups = { SpringFormGroup.class })
	private String nombre;

	@Size(max = 450, message = Constants.SIZE, groups = { SpringFormGroup.class })
	private String descripcion;

	@OneToMany(mappedBy = "autor")
	private Set<Libro> libros;

	public Autor() {

	}

	public Autor(int idAutor, String nombre, String descripcion) {
		this.idAutor = idAutor;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Autor(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}
