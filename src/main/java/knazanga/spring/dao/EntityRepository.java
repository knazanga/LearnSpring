 package knazanga.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository //
@Transactional // Oblige spring to use transaction on every query
public class EntityRepository<T> implements IEntityRepository<T>{

	@PersistenceContext //delegate the manager life cycle to spring
	private EntityManager manager;
	
	@Override
	public T save(T entity) {
		manager.persist(entity);
		return entity;
	}

	@Override
	public T delete(Class<T> objClass, Long id) {
		T obj = manager.find(objClass, id);
		manager.remove(obj);
		return obj;
	}

	@Override
	public T update(T entity) {
		manager.merge(entity);
		return entity;
	}

	@Override
	public T findById(Class<T> objClass,Long id) {
		T obj=manager.find(objClass, id);
		return obj;
	}

	@SuppressWarnings("unchecked") //Disable warning on result type casting
	@Override
	public List<T> findAll(Class<T> objClass) {
		Query query=manager.createQuery("From "+objClass.getName());
		return query.getResultList();
	}

}
