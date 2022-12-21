/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class AgendaPersonasOrdenada {

    public static void main(String[] args) {

        // En este ejemplo, la clave que no se puede repetir es el NIF de la persona
        // Por cada clave, sólo hay un objeto Persona asociado
        // En el ejemplo AgendaPersona.java se crea un objeto HashMap, que no garantiza
        // ningún orden dentro de las claves NIF (String)
        // En este caso, al crear el map usando la clase TreeMap se garantiza que 
        // cada vez que se inserte un elemento en el map, éste estará ordenado
        // usando una estructura de árbol
        SortedMap<String, Persona> agenda = new TreeMap<>();

        //Insertamos los pares clave, valor
        agenda.put("42345678A", new Persona("12345678A", "Pepe", "Perez", LocalDate.of(1990, 1, 2)));
        agenda.put("93456789B", new Persona("23456789B", "Juan", "Martínez", LocalDate.of(1991, 2, 3)));
        agenda.put("14567890C", new Persona("34567890C", "Ana", "Ramírez", LocalDate.of(1992, 3, 4)));
        agenda.put("55678901D", new Persona("45678901D", "María", "López", LocalDate.of(1993, 4, 5)));

        // La forma más normal de recorrer un Map es tomar su conjunto de claves, iterar por ellas, y
        // para cada una de ellas, obtener el valor.
        // En este caso, se imprimen por orden de la key (String nif)
        for (String key : agenda.keySet()) {
            System.out.printf("Clave %s -- Objeto %s %n", key, agenda.get(key));
        }

        // Si insertamos un elemento con la misma clave, lo sustituimos
        // En este caso Ana Ramírez se sustituye por Martín García
        agenda.put("34567890C", new Persona("34567890C", "Martín", "García", LocalDate.of(1990, 12, 15)));

        // Las claves no tienen por qué coincidir con algún atributo del objeto
        agenda.put("11111111A", new Persona("12345678C", "Julia", "Hernández", LocalDate.of(1990, 12, 15)));

        // Puede haber objetos duplicados
        agenda.put("11111112A", new Persona("12345678C", "Julia", "Hernández", LocalDate.of(1990, 12, 15)));
        System.out.println("------------------------------------------------------------------------");
        agenda.forEach((clave, valor) -> System.out.println("Clave " + clave + " -- Objeto " + valor));

        // Se puede obtener un Set con las claves únicas
        Set<String> conjuntoNif = agenda.keySet();

        System.out.println("  ----  Lista de claves únicas -----");
        // Se imprimen en orden
        conjuntoNif.forEach(System.out::println);

        // Se puede obtener una colección con las personas (puede haber duplicados)
        // Esta colección no tiene orden
        Collection<Persona> cPersonas = agenda.values();
        System.out.println("  ----  Lista de personas a partir del Map -----");
        cPersonas.forEach(System.out::println);

        // Borrado de un elemento por su key (clave). Se borra a Juan Martínez
        agenda.remove("93456789B");

        System.out.println("DESPUÉS DE BORRAR ---------------------------------------------------");
        agenda.forEach((clave, valor) -> System.out.println("Clave " + clave + " -- Objeto " + valor));

    }

}
