/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversiones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author carlos
 */
public class SetToListToMap {

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

        // Obtención de una lista a partir del set
        List<Persona> lista = new ArrayList<>(juntaDirectiva);
        System.out.println("Lista a partir del set");
        System.out.println("---------- Lista a partir del set -------------");
        lista.forEach(System.out::println);
        
        // Obtención de un map a partir del set
        // Se crea un Stream intermedio y usando una función de colección se genera un 
        // map con keys el nif de la persona y como valor de ese key la persona en cuestión
        Map<String, Persona> mapa = juntaDirectiva.stream().collect(Collectors.toMap(Persona::getNif, Function.identity()));
        System.out.println("---------- Mapa a partir del set ------------- ");
        for (Map.Entry<String, Persona> entry : mapa.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("key -> " + key  + " value -> " + val);
            
        }
    }

}
