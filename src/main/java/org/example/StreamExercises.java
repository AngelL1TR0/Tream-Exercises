package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExercises {

    private int sum(List<Integer> numbers) {

        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private List<Integer> sum10(List<Integer> numbers) {

        List<Integer> numberPlus10 = new LinkedList<>();

        for (int number : numbers) {
            numberPlus10.add(number + 10);
        }
        return numberPlus10;
    }

    private int sum10(int number) {
        return number + 10;
    }

    private List<Integer> minus10(List<Integer> numbers) {

        List<Integer> numberPlus10 = new LinkedList<>();

        for (int number : numbers) {
            numberPlus10.add(number - 10);
        }
        return numberPlus10;
    }

    private List<Integer> sum10Fun(List<Integer> numbers) {
        return numbers
                //Es necesario conveertir la lista a stream, para poder usar
                // los metodos funcionales
                .stream()
                //Map es un metodo funcional que convierte A en B, f: A -> B
                .map(number -> number + 10)
                //Vuelvo a convertir el Stream en lista de Integer
                .collect(Collectors.toList());

    }

    //Lo mismo pero en minus
    private List<Integer> minus10Fun(List<Integer> numbers) {
        return numbers
                .stream()
                .map(number -> number - 10)
                .collect(Collectors.toList());
    }

    private List<String> getSurnames(List<Person> people){
        List<String> surnames = new LinkedList<>();

        for (Person person : people) {
            surnames.add(person.getSurname());
        }
        return surnames;
    }

    private List<String> getSurnamesFun(List<Person> people){

        return people
                .stream()
                .map(person -> person.getSurname())
                .collect(Collectors.toList());
    }

    private List<Person> findGarcia(List<Person> people){

        List<Person> garcias = new LinkedList<>();

        for (Person person : people) {
            if (person.getSurname().equals("Garcia")) {
                garcias.add(person);
            }
        }
        return garcias;
    }

    private List<String> findGarciaNamesFun(List<Person> people){

        return people
                .stream()
                .filter(person -> person.getSurname().equals("Garcia"))
                .map(person -> person.getName())
                .collect(Collectors.toList());
    }

    private List<String> getEmails(List<Person> people){

        return people
                .stream()
                .flatMap(person -> person.getEmail().stream())
                .collect(Collectors.toList());

    }

    private int sum1 (List<Integer> numbers){
        int sum = 0;
        for (int number : numbers){
            sum = sum + number;
        }
        return sum;
    }

    private int sumFun(List<Integer> numbers){
        return numbers
                .stream()
                .reduce(0, (a, b) -> a + b);
     }

     private int getNumberOfEmails(List<Person> people){

        return people
                .stream()
                .map(person -> person.getEmail().size())
                .reduce(0, (a, b) -> a + b);
     }

     private  boolean existBobEsponja(List<Person> people){

        for (Person person : people){
            if (person.getName().equals("Bob") && person.getSurname().equals("Espoponja"))
                return true;
        }
            return false;
     }

     private boolean existBobEsponjaFun(List<Person> people){

        return people
                .stream()
                .anyMatch(person -> person.getName().equals("Bob") && person.getSurname().equals("Esponja"));
     }

}

