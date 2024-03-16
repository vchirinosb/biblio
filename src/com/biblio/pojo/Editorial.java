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
@Table(name = "editorial")
public class Editorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEditorial;

	@NotEmpty(message = Constants.NOT_EMPTY, groups = { PersistenceGroup.class, SpringFormGroup.class })
	@Size(max = 150, message = Constants.SIZE, groups = { SpringFormGroup.class })
	private String editorial;

	@OneToMany(mappedBy = "editorial")
	private Set<Libro> libros;

	public Editorial() {

	}

	public Editorial(int idEditorial, String editorial) {
		this.idEditorial = idEditorial;
		this.editorial = editorial;
	}

	public Editorial(String editorial) {
		this.editorial = editorial;
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Editorial [idEditorial=" + idEditorial + ", editorial=" + editorial + "]";
	}

}
