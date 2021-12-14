package ec.edu.ups.EvaluacionU2Cardenas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.EvaluacionU2Cardenas.model.Libro;

@Stateless
public class LibroDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Libro op) {
		em.persist(op);
	}
	
	public Libro update (Libro op) {
		return em.merge(op);
	}
	
	public Libro read (int codigo) {
		Libro op = em.find(Libro.class, codigo);
		return op;
	}
	
	public void delete(int id) {
		Libro op = em.find(Libro.class, id);
		em.remove(op);
	}
	
	
	public List<Libro> getList(){
		List<Libro> listado = new ArrayList<Libro>();
		
		//JPQL  -> SQL
		String jpql = "SELECT op FROM Libro op";
	
		
		Query query = em.createQuery(jpql,Libro.class);

		listado = query.getResultList();
		
		return listado;
		
	}

}
