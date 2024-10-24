/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tpcsw.practica03;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author harlock024
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long> {

    @Override
    public boolean save(Empleado pojo) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(pojo);
        t.commit();
        return true;
    }
    
    @Override
    public List<Empleado> findAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction t = session.beginTransaction();
        var q = session.createQuery("from Empleado", Empleado.class);
        List<Empleado> empleados = q.list();
        t.commit();
        return empleados;
    }

    @Override
    public Empleado findById(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction t = session.beginTransaction();
        Empleado emp = session.get(Empleado.class, id);
        t.commit();
        return emp;
    }

    @Override
    public boolean update(Empleado pojo, Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        Transaction t = s.beginTransaction();
        Empleado emp = s.get(Empleado.class, id);
        if (emp != null) {
            emp.setNombre(pojo.getNombre());
            emp.setTelefono(pojo.getTelefono());
            emp.setDireccion(pojo.getDireccion());
            t.commit();
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        Transaction t = s.beginTransaction();
        Empleado emp = s.get(Empleado.class, id);
        if (emp != null) {
            s.delete(emp);
            t.commit();
            return true;
        }
        t.rollback();
        return false;

    }

}
