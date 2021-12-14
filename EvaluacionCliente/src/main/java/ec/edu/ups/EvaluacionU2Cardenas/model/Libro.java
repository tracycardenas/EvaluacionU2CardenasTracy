package ec.edu.ups.EvaluacionU2Cardenas.model;

import java.io.Serializable;

public class Libro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int codigo;
	
	private String nombre;
	
	private String autor;
	
	private int numPag;
	
	private double precio;
	
	

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", nombre=" + nombre + ", autor=" + autor + ", numPag=" + numPag
				+ ", precio=" + precio + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	

}