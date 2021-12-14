package ec.edu.ups.EvaluacionU2Cardenas.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.EvaluacionU2Cardenas.dao.LibroDAO;
import ec.edu.ups.EvaluacionU2Cardenas.model.Libro;

@Stateless
public class LibroON implements LibroONRemote{
	
	@Inject
	private LibroDAO libDAO;
	
	public void insertarLibro(Libro lib) throws Exception {
		libDAO.insert(lib);	
	}
	
	public List<Libro> getProductos(){
		return libDAO.getList();
	}
	
	public Libro buscarP(int id) {
		Libro p = libDAO.read(id);
		return p;
	}
	
	public Libro actualizar(Libro lib) {
		System.out.println(lib.toString());
		return libDAO.update(lib);
	}

}
