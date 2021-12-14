package ec.edu.ups.EvaluacionU2Cardenas.business;

import javax.ejb.Remote;

import ec.edu.ups.EvaluacionU2Cardenas.model.Libro;

@Remote
public interface LibroONRemote {
	
	public void insertarLibro(Libro lib) throws Exception;
	public Libro buscarP(int id);
	public Libro actualizar(Libro lib);

}