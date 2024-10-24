package org.uv.tpcsw.practica03;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author harlock024
 */
@Entity
@Table(name = "empleado2")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado2_clave_seq")
    @SequenceGenerator(name = "empleado2_clave_seq", sequenceName = "empleado2_clave_seq", initialValue = 1, allocationSize = 1)
    @Column
    private long clave;
    @Column
    private String nombre;
    @Column
    private String direccion;
    @Column
    private String telefono;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "depto_clave")
    private Departamento depto;

    public Empleado() {
    }

    public Empleado(long clave, String nombre, String direccion, String telefono, Departamento depto) {
        this.clave = clave;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.depto = depto;
    }
    
    
    
    
    
    

    public long getClave() {
        return clave;
    }
    
    public void setDepto(Departamento depto){
      this.depto = depto;
      if (!depto.getEmpleados().contains(this)){
          depto.getEmpleados().add(this);
      }
    }
     public Departamento getDepto() {
        return depto;
    }
   

    public void setClave(long clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String dirreccion) {
        this.direccion = dirreccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    

}
