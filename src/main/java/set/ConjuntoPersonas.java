package set;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        juntaDirectiva.add(new Persona("33678551D", "Lucas", "Vázquez", LocalDate.of(1988, Month.DECEMBER, 5)));

        System.out.printf("Ahora el set contiene %d elementos", juntaDirectiva.size());
        System.out.println("------------------");

        juntaDirectiva.forEach(System.out::println);

        juntaDirectiva.remove(new Persona("45678901D", "María", "López", LocalDate.of(1993, 4, 5)));

        System.out.println("----- Después del borrado de María López ------------");
        juntaDirectiva.forEach(System.out::println);

        List<Persona> lista = new ArrayList<>(juntaDirectiva);

        Map<String, Persona> mapa2 = lista.stream().collect(Collectors.toMap(Persona::getNif, Function.identity()));
        
        Collection<Persona> col = mapa2.values();
        ArrayList<Persona> arraylist = new ArrayList<>(mapa2.values());
        System.out.println("lista desde mapa -------------------");
        for (Persona persona : arraylist) {
            System.out.println("persona lista " + persona);
        }
        
        System.out.println("hashset a partir de mapa ----------------");
        HashSet<Persona> nuevo = new HashSet<>(mapa2.values());
        for (Persona persona : nuevo) {
            System.out.println("persona del hash " + persona);
        }

        Set<Persona> setnuevo = new HashSet(lista);
        System.out.println("Lista");
        lista.forEach(System.out::println);
        Map<String, Persona> mapa = juntaDirectiva.stream().collect(Collectors.toMap(Persona::getNif, Function.identity()));

        for (Map.Entry<String, Persona> entry : mapa.entrySet()) {
            String key = entry.getKey();
            Persona value = entry.getValue();

            System.out.println("Key " + key + " value " + value);

        }

    }
}
