package knazanga.spring.dao;

import java.util.List;

public interface IEntityRepository<T> {
	
	T save(T entity);
	
	T delete(Class<T> objClass,Long id);
	
	T update(T entity);
	
	T findById(Class<T> objClass, Long id);
	
	List<T> findAll(Class<T> objClass);
	
	

}
