package com.biblio.service.dto;

/**
 * @author vchirinosb
 * @since 19/10/2016
 */
public class LibroDTO {

	private int idLibro;
	private String titulo;
	private String autor;
	private String editorial;
	private int anhoPublicacion;
	private String edicion;
	private int cantidadEjemplares;

	public LibroDTO() {

	}

	public LibroDTO(int idLibro, String titulo, String autor, String editorial, int anhoPublicacion, String edicion,
			int cantidadEjemplares) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
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

	@Override
	public String toString() {
		return "LibroDTO [idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", anhoPublicacion=" + anhoPublicacion + ", edicion=" + edicion + ", cantidadEjemplares="
				+ cantidadEjemplares + "]";
	}

}
