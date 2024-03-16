package com.biblio.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.biblio.pojo.valid.PersistenceGroup;
import com.biblio.pojo.valid.SpringFormGroup;

@Entity
@Table(name = "libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLibro;

	@NotEmpty(message = Constants.NOT_EMPTY, groups = { PersistenceGroup.class, SpringFormGroup.class })
	@Size(max = 250, message = Constants.SIZE, groups = { SpringFormGroup.class })
	private String titulo;

	@NotNull(message = Constants.NOT_EMPTY, groups = { PersistenceGroup.class, SpringFormGroup.class })
	private int anhoPublicacion;

	@NotEmpty(message = Constants.NOT_EMPTY, groups = { PersistenceGroup.class, SpringFormGroup.class })
	@Size(max = 20, message = Constants.SIZE, groups = { SpringFormGroup.class })
	private String edicion;

	// private String imagenPortada;

	@NotNull(message = Constants.NOT_EMPTY, groups = { PersistenceGroup.class, SpringFormGroup.class })
	private int cantidadEjemplares;

	@ManyToOne
	@JoinColumn(name = "idAutor")
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "idEditorial")
	private Editorial editorial;

	public Libro() {

	}

	public Libro(int idLibro, String titulo, int anhoPublicacion, String edicion, int cantidadEjemplares) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.anhoPublicacion = anhoPublicacion;
		this.edicion = edicion;
		this.cantidadEjemplares = cantidadEjemplares;
	}

	public Libro(String titulo, int anhoPublicacion, String edicion, int cantidadEjemplares) {
		this.titulo = titulo;
		this.anhoPublicacion = anhoPublicacion;
		this.edicion = edicion;
		this.cantidadEjemplares = cantidadEjemplares;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnhoPublicacion() {
		return anhoPublicacion;
	}

	public void setAnhoPublicacion(int anhoPublicacion) {
		this.anhoPublicacion = anhoPublicacion;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public int getCantidadEjemplares() {
		return cantidadEjemplares;
	}

	public void setCantidadEjemplares(int cantidadEjemplares) {
		this.cantidadEjemplares = cantidadEjemplares;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", anhoPublicacion=" + anhoPublicacion
				+ ", edicion=" + edicion + ", cantidadEjemplares=" + cantidadEjemplares + "]";
	}

}
