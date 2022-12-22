package com.ipartek.formacion.hibernate.hibernatedao.dal;

import com.ipartek.formacion.hibernate.hibernatedao.entidades.Colectivo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoHibernateColectivo implements Dao<Colectivo> {

	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.hibernate.hibernatedao.entidades");

	// SINGLETON
	private DaoHibernateColectivo() {
	}

	private static final DaoHibernateColectivo INSTANCIA = new DaoHibernateColectivo();

	public static Dao<Colectivo> getInstancia() {
		return INSTANCIA;
	}
	// END SINGLETON

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Colectivo> obtenerTodos() {
		// "from Colectivo c join fetch c.personas" Si queremos todas las personas de todos los colectivos
		return (Iterable<Colectivo>) eet(em -> em.createQuery("from Colectivo", Colectivo.class).getResultList());
	}

	@Override
	public Colectivo obtenerPorId(Long id) {
		return (Colectivo) eet(em -> em.createQuery("from Colectivo c join fetch c.personas where c.id = " + id, Colectivo.class).getSingleResult());//em.find(Colectivo.class, id));
	}

	@Override
	public Colectivo insertar(Colectivo colectivo) {
		return (Colectivo) eet(em -> {
			em.persist(colectivo);
			return colectivo;
		});
	}

	@Override
	public Colectivo modificar(Colectivo colectivo) {
		return (Colectivo) eet(em -> em.merge(colectivo));
	}

	@Override
	public void borrar(Long id) {
		eet(em -> {
			em.remove(em.find(Colectivo.class, id));
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
