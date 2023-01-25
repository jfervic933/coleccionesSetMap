
package set;

import java.time.LocalDate;
import java.time.Month;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class ConjuntoPersonasOrdenado {
    public static void main(String[] args) {
	
        // Si queremos un set ordenado, entonces usamos TreeSet
        // En este ejemplo se ordenan las personas por NIF y no permite
        // duplicados de NIF
        // Es necesario que Persona tenga los métodos equals y hashcode implementados
        // Persona debe implementar <<Comparable>>
        SortedSet<Persona> juntaDirectiva = new TreeSet<>();

        // Se añaden los elementos al set, sin ordenar
        juntaDirectiva.add(new Persona("42345678A", "Pepe", "Perez", LocalDate.of(1990, 1, 2)));
        juntaDirectiva.add(new Persona("33456789B", "Juan", "Martínez", LocalDate.of(1991, 2, 3)));
        juntaDirectiva.add(new Persona("14567890C", "Ana", "Ramírez", LocalDate.of(1992, 3, 4)));
        juntaDirectiva.add(new Persona("25678901D", "María", "López", LocalDate.of(1993, 4, 5)));

        // Si tratamos de añadir un elemento con un nif ya insertado entonces
        // no se inserta, el set queda como estaba y el método devuelve false
        juntaDirectiva.add(new Persona("42345678A", "Luz", "López", LocalDate.of(1993, 4, 5)));

        // Comprobamos que al listarlos todos, no aparecen nif duplicados
        // El orden lo define el nif
        for (Persona p : juntaDirectiva) {
            System.out.println(p);
        }
        
        juntaDirectiva.add(new Persona("33678551D", "Lucas", "Vázquez", LocalDate.of(1988, Month.DECEMBER, 5)));
        
        System.out.printf("Ahora el set contiene %d elementos", juntaDirectiva.size());
        System.out.println(" ------------------");
        
        juntaDirectiva.forEach(System.out::println);
        
        // El borrado, independientemente del valor de atributos del objeto
        // Persona se hace usando exclusivamente el atributo nif
        // En este caso se borra a María López
        juntaDirectiva.remove(new Persona("25678901D", "", "", LocalDate.now()));
        
        System.out.println("----- Después del borrado de María López ------------");
        juntaDirectiva.forEach(System.out::println);

    }

    
}
