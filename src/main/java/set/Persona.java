
package set;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class Persona implements Comparable<Persona>{

    private String nif;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String nif, String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Persona{" + "nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.nif);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nif, other.nif)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Persona o) {
        return this.nif.compareToIgnoreCase(o.nif);
    }
    
}
