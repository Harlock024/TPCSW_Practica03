package org.uv.tpcsw.practica03;

import java.util.List;

/**
 *
 * @author harlock024
 */
public interface IDAOGeneral<T, ID> {
    

    public boolean save(T pojo);

    public boolean delete(ID id);

    public boolean update(T pojo, ID id);

    public List<T> findAll();

    public T findById(ID id);

}
