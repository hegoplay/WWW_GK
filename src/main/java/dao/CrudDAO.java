package dao;

import java.util.List;

public interface CrudDAO<T,U> {
	public void insert(T obj);

	public void update(T obj);

	public void delete(T obj);

	public T findById(U id);

	public List<T> getAll();
}
