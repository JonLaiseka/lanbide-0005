package com.ipartek.formacion.hibernate.hibernatedao.dal;

import com.ipartek.formacion.hibernate.hibernatedao.entidades.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoHibernatePersona implements Dao<Persona> {

	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.hibernate.hibernatedao.entidades");

	// SINGLETON
	private DaoHibernatePersona() {
	}

	private static final DaoHibernatePersona INSTANCIA = new DaoHibernatePersona();

	public static Dao<Persona> getInstancia() {
		return INSTANCIA;
	}
	// END SINGLETON

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Persona> obtenerTodos() {
		return (Iterable<Persona>) eet(em -> em.createQuery("from Persona p join fetch p.colectivo", Persona.class).getResultList());
	}

	@Override
	public Persona obtenerPorId(Long id) {
		return (Persona) eet(em -> em.createQuery("from Persona p join fetch p.colectivo where p.id = " + id, Persona.class).getSingleResult());// em.find(Persona.class, id));
	}

	@Override
	public Persona insertar(Persona persona) {
		return (Persona) eet(em -> {
			em.persist(persona);
			return persona;
		});
	}

	@Override
	public Persona modificar(Persona persona) {
		return (Persona) eet(em -> em.merge(persona));
	}

	@Override
	public void borrar(Long id) {
		eet(em -> {
			em.remove(em.find(Persona.class, id));
			return null;
		});
	}

	private Object eet(java.util.function.Function<EntityManager, Object> codigo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Object resultado = codigo.apply(em);

		em.getTransaction().commit();
		em.close();

		return resultado;
	}
}
