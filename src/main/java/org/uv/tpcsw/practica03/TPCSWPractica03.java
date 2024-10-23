package org.uv.tpcsw.practica03;

import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author harlock024
 *
 */
public class TPCSWPractica03 {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Empleado emp2 = new Empleado();
        emp2.setClave(05);
        emp2.setNombre("Victor hirbenate");
        emp2.setDireccion("av 6");
        emp2.setTelefono("27215455");

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        Transaction t = s.beginTransaction();

        Departamento depto = s.get(Departamento.class, 1L);
        if (depto != null) {
            System.out.println("Clave:" + depto.getClave() + "Nombre:" + depto.getNombre());
            Set<Empleado> empleados = depto.getEmpleados();

            for (Empleado empleado : empleados) {
                System.out.println("clave:" + empleado.getNombre());
            }
        }
        
        
        Empleado empleadoExiste = s.get(Empleado.class, emp2.getClass());
        if(emp2!=null){
            emp2.setNombre("hadith ");
            s.update(empleadoExiste);
            System.out.println("Empleado update: "+ empleadoExiste.getNombre());
         }
        
        
        if(empleadoExiste!=null){
            s.delete(empleadoExiste);
            System.out.println("Empleado delete: "+ emp2.getNombre());
        }
        
        List<Empleado> ListE = s.createQuery("from Empleado").list();
        System.out.println("Empleados");
        for (Empleado emp : ListE) {
            System.out.println("Nombre:" +emp.getNombre());
           
        }
        
        t.commit();
        

    }
}
