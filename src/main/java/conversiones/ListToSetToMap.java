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
public class ListToSetToMap {
    
    public static void main(String[] args) {
        
        List<Persona> juntaDirectiva = new ArrayList<>();
        
        juntaDirectiva.add(new Persona("12345678A", "Pepe", "Perez", LocalDate.of(1990, 1, 2)));
        juntaDirectiva.add(new Persona("23456789B", "Juan", "Martínez", LocalDate.of(1991, 2, 3)));
        juntaDirectiva.add(new Persona("34567890C", "Ana", "Ramírez", LocalDate.of(1992, 3, 4)));
        juntaDirectiva.add(new Persona("45678901D", "María", "López", LocalDate.of(1993, 4, 5)));
        //juntaDirectiva.add(new Persona("45678901D", "María", "López", LocalDate.of(1993, 4, 5)));

        System.out.println("----- Lista de personas -----------");
        juntaDirectiva.forEach(System.out::println);
        
        // Obtención de un set a partir de la lista. Si hay elementos duplicados
        // se añade solo uno
        Set<Persona> setPersona = new HashSet(juntaDirectiva);
        System.out.println("---------- Set a partir de la lista -----------");
        setPersona.forEach(System.out::println);
        
        // Obtención de un map a partir de la lista.
        // Se crea un Stream intermedio y usando una función de colección se genera un 
        // map con keys el nif de la persona y como valor de ese key la persona en cuestión
        // Si hay keys duplicadas, entonces se lanza una excepción y no se crea el map
        Map<String, Persona> mapa = juntaDirectiva.stream().collect(Collectors.toMap(Persona::getNif, Function.identity()));
        System.out.println("------ Map a partir de la lista ------------ ");
        for (Map.Entry<String, Persona> entry : mapa.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("key -> " + key  + " value -> " + val);
            
        }
        
    }
    
}
