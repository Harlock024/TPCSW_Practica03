/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.tpcsw.practica03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**SessionFactory
 *
 * @author harlock024
 */
public class TPCSWPractica03 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
       
        Departamento departamento= new Departamento();
        departamento.setNombre("administracion");

//        Empleado emp= new Empleado();
//        emp.setClave(02);
//        emp.setNombre("hadith hirbenate");
//        emp.setDireccion("av 2");
//        emp.setTelefono("27211234245");
//        
        SessionFactory sf= HibernateUtil.getSessionFactory();
         Session session = sf.getCurrentSession();
        Transaction t= session.beginTransaction();
        
        
       Departamento dep = session.get(Departamento.class,1L);
       
       
     if (dep==null){
         
     }
                
                
        session.save(departamento);
        t.commit();
    }
}

