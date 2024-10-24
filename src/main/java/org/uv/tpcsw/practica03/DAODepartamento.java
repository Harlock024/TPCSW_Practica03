package org.uv.tpcsw.practica03;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author harlock024
 */
public class DAODepartamento implements IDAOGeneral<Departamento, Long> {

    @Override
    public boolean save(Departamento pojo) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.save(pojo);
        t.commit();
        return true;
    }
    @Override
    public boolean delete(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        Transaction t = s.beginTransaction();
        Departamento depto = s.get(Departamento.class, id);
        if (depto != null) {
            s.delete(depto);
            t.commit();
            return true;
        }
        t.rollback();
        return false;
    }
    @Override
    public boolean update(Departamento pojo, Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        Transaction t = s.beginTransaction();
        Departamento depto = s.get(Departamento.class, id);
        if (depto != null) {
            depto.setNombre(pojo.getNombre());

            t.commit();
            return true;
        }
        return false;

    }
    @Override
    public List<Departamento> findAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        Transaction t = s.beginTransaction();
       var q = s.createQuery("from Departamento", Departamento.class);
       List<Departamento> departamentos = q.list();
       t.commit();
       return departamentos;
    }

    @Override
    public Departamento findById(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        Transaction t = s.beginTransaction();
        Departamento depto  = s.get(Departamento.class, id);
        t.commit();
        return depto;
    }
}
