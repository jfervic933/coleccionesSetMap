package set;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class ConjuntoPersonas {

    public static void main(String[] args) {

        // Una HashSet no permite duplicados
        // Es necesario que Persona tenga los métodos equals y hashcode implementados
        Set<Persona> juntaDirectiva = new HashSet<>();

        juntaDirectiva.add(new Persona("12345678A", "Pepe", "Perez", LocalDate.of(1990, 1, 2)));
        juntaDirectiva.add(new Persona("23456789B", "Juan", "Martínez", LocalDate.of(1991, 2, 3)));
        juntaDirectiva.add(new Persona("34567890C", "Ana", "Ramírez", LocalDate.of(1992, 3, 4)));
        juntaDirectiva.add(new Persona("45678901D", "María", "López", LocalDate.of(1993, 4, 5)));

        //Si tratamos de añadir un elemento repetido...
        //El set queda como estaba y el método devuelve false
        juntaDirectiva.add(new Persona("45678901D", "María", "López", LocalDate.of(1993, 4, 5)));

        //Comprobamos que al listarlos todos, no aparece duplicado
        //No hay orden aparante, ni siquiera el orden de inserción
        for (Persona p : juntaDirectiva) {
            System.out.println(p);
        }

        // Esta persona se añade
        juntaDirectiva.add(new Persona("33678551D", "Lucas", "Vázquez", LocalDate.of(1988, Month.DECEMBER, 5)));

        System.out.printf("Ahora el set contiene %d elementos", juntaDirectiva.size());
        System.out.println("------------------");

        juntaDirectiva.forEach(System.out::println);

        // Se borra una persona. Con proporcionar el NIF es suficiente, ya que equals, hashcode usan nif
        juntaDirectiva.remove(new Persona("45678901D", "", "", LocalDate.now()));

        System.out.println("----- Después del borrado de María López ------------");
        juntaDirectiva.forEach(System.out::println);

        // Se puede obtener una  lista a partir del set
        List<Persona> lista = new ArrayList<>(juntaDirectiva);
        
        System.out.println("Recorrido del set con un iterador -----------------");
        // Se puede recorrer el set con un iterador
        Iterator<Persona> iterador = juntaDirectiva.iterator();
        
        while(iterador.hasNext()){ // No existe orden 
            Persona p = iterador.next();
            System.out.println(p);
        }
        System.out.println("Recorrido con un foreach ---------------");
        // Un foreach es equivalente a usar un iterador para recorrer el set
        for (Persona p : juntaDirectiva) {
            System.out.println(p);
        }
    }
}
